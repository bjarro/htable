package lexer;

import jflex.Main;
import jflex.SilentExit;
import lookup.LexDict;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LexerGenerator {

    private LexDict lexDict;
    private String flexPath;
    private String templatePath;


    public LexerGenerator(LexDict lexDict, String destPath, String templatePath) {
        this.lexDict = lexDict;
        this.templatePath = templatePath;
        this.flexPath = destPath;
    }

    /*Open Template
     * Copy Template
     * Point to End of File
     * Write Lexical Rules
     * */

    public void generateFlex() throws IOException {
        List<String> templateString = Files.readAllLines(Paths.get(templatePath));
        templateString.addAll(getTokens());


        Path path = Paths.get(flexPath);
        Files.delete(path);
        Files.createFile(path);
        Files.write(path, templateString);
    }

    public void generateLexer(String path) throws SilentExit {
        Main.generate(new String[]{"-d", path, flexPath});
    }


    public List<String> getTokens() {

        List<String> lexicalRules = new ArrayList<>();
        for (Map.Entry entry : lexDict.entrySet()) {
            lexicalRules.add(String.format("<YYINITIAL> %s { return \"%s\"; }",
                    entry.getValue(), entry.getKey()));
        }
        return lexicalRules;
    }



/*
    public List<String> getStates() {
        StringBuilder string = new StringBuilder();

        for (Map.Entry entry : lexDict.getStates().entrySet()) {
            string.append(String.format("<%s> %s { return \"%s\"; }",
                    entry.getValue(), entry.getKey()));
        }
        return lexicalRules;
    }
*/


}
