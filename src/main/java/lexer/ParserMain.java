package lexer;

import htable.psi.HTableData;
import htable.psi.HTableDataContent;
import htable.psi.HTableEvaluatedExpression;
import htable.psi.HTableHeader;
import htable.psi.HTableHeaderRow;
import htable.psi.HTableNonEvaluatedExpression;
import htable.psi.HTablePunctuation;
import htable.psi.HTableRow;
import htable.psi.HTableRowList;
import htable.psi.HTableTable;
import org.intellij.grammar.LightPsi;
import com.intellij.lang.ParserDefinition;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import htable.HTableParserDefinition;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ParserMain {
    public static void main(String[] args) throws IOException, ScriptException {


        String path = args[0];
        String dest = args[1];


        ParserDefinition parserDefinition = new HTableParserDefinition();
//        File file = new File("test/htable/parser/table.htable");
        File file = new File(path);

        PsiFile psiFile = LightPsi.parseFile(file, parserDefinition);
//        PsiFile psiFile = parseFile(file, parserDefinition);

        PsiElement root = psiFile.getNode().getPsi();

        List<HTableTable> tables = PsiTreeUtil.getChildrenOfTypeAsList(root, HTableTable.class);

        for (HTableTable table : tables) {
            HTableHeaderRow headerRow = PsiTreeUtil.getChildOfType(table, HTableHeaderRow.class);
            List<HTableHeader> headers = headerRow.getHeaderList();

        }

        System.out.println(getData(root));
        Files.write(Paths.get(dest), getData(root).getBytes());
    }

    public static String getData(PsiElement root) throws ScriptException {

        StringBuilder sb = new StringBuilder();

        List<HTableTable> tables = PsiTreeUtil.getChildrenOfTypeAsList(root, HTableTable.class);

        for (HTableTable table : tables) {
            HTableHeaderRow headerRow = PsiTreeUtil.getChildOfType(table, HTableHeaderRow.class);
            List<HTableHeader> headers = headerRow.getHeaderList();

            Iterator<HTableHeader> headerIterator = headers.iterator();

            while (headerIterator.hasNext()) {
                HTableHeader headerData = headerIterator.next();
                sb.append(headerData.getString().getText());
                if (headerIterator.hasNext()) {
                    sb.append(",");
                }
            }
            sb.append("\n");

            sb.append(getData(table.getRowList()));
        }

        return sb.toString();
    }


    public static String getData(HTableRowList rows) throws ScriptException {

        StringBuilder sb = new StringBuilder();

        List<HTableRow> rowList = rows.getRowList();

        Iterator<HTableRow> rowListIterator = rowList.iterator();

        while (rowListIterator.hasNext()) {

            HTableRow row = rowListIterator.next();
            List<HTableData> dataList = row.getDataList();
            Iterator<HTableData> dataIterator = dataList.iterator();
            while (dataIterator.hasNext()) {
                HTableData data = dataIterator.next();
                sb.append(evaluateData(data.getDataContent()));
                if (dataIterator.hasNext()) {
                    sb.append(",");
                }
            }
            if (rowListIterator.hasNext()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }


    public static String evaluateData(HTableDataContent dataContent) throws ScriptException {

        if (dataContent.getChildren()[0] instanceof HTableEvaluatedExpression) {

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");

            if (engine == null) {
                throw new IllegalStateException("JavaScript script engine not found. Ensure you have the correct dependencies.");
            }

            double result = (double) engine.eval(dataContent.getEvaluatedExpression().getExpr().getText());

            return String.valueOf(result);
        } else if ((dataContent.getChildren()[0] instanceof HTableNonEvaluatedExpression)) {
            return dataContent.getNonEvaluatedExpression().getExpr().getText();
        } else {


            //List<PsiElement> tokens = PsiTreeUtil.getChildrenOfAnyType(dataContent.getString());

            List<PsiElement> tokens = Arrays.asList(dataContent.getString().getChildren());
            Iterator<PsiElement> tokenIterator = tokens.iterator();

            StringBuilder sb = new StringBuilder();
            PsiElement prevElement = null;
            while (tokenIterator.hasNext()) {
                PsiElement element = tokenIterator.next();

                if (!(element instanceof HTablePunctuation)) {
                    if (prevElement != null) {
                        sb.append(" ");
                    }
                }


                sb.append(element.getText());
                prevElement = element;
            }

            return sb.toString();
        }
    }
}