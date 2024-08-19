package htable;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class HTableColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Table Background", HTableSyntaxHighlighter.TABLE_BACKGROUND),
            new AttributesDescriptor("Row Background", HTableSyntaxHighlighter.ROW_BACKGROUND),
            new AttributesDescriptor("Header Background", HTableSyntaxHighlighter.HEADER_BACKGROUND),
            new AttributesDescriptor("Data Background", HTableSyntaxHighlighter.DATA_BACKGROUND),
            new AttributesDescriptor("Data Content Background", HTableSyntaxHighlighter.DATA_CONTENT_BACKGROUND),
            new AttributesDescriptor("Expression Background", HTableSyntaxHighlighter.EXPRESSION_BACKGROUND),
//            new AttributesDescriptor("Identifier Foreground", HTableSyntaxHighlighter.IDENTIFIER_FOREGROUND),
            new AttributesDescriptor("String Foreground", HTableSyntaxHighlighter.STRING_FOREGROUND),
            new AttributesDescriptor("Number Foreground", HTableSyntaxHighlighter.NUMBER_FOREGROUND),
            new AttributesDescriptor("Comment Foreground", HTableSyntaxHighlighter.COMMENT_FOREGROUND),
            new AttributesDescriptor("Operator Foreground", HTableSyntaxHighlighter.OPERATOR_FOREGROUND),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return null; // Return an icon if available
    }

    @NotNull
    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "HTable";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Nullable
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new HTableSyntaxHighlighter();
    }

    @Nullable
    @Override
    public String getDemoText() {
        return "<table>\n" +
                "<tr><th> particulars </th> <th> amount </th>   </tr>\n" +
                "<tr><td> ballpen </td> <td> 10.25 </td>   </tr>\n" +
                "<tr> <td> pencil </td> <td> 5.55 </td>    </tr>\n" +
                "<tr> <td> total  amount </td> <td> =10.25+2*5.55 </td>  </tr>\n" +
                "<tr> <td> Conversion rule:12 eggs ,as a  group,  make 1dozen;thanks  .</td> <td> [10.25 + 2*5.55] </td>    </tr>\n" +
                "</table>";
    }

}
