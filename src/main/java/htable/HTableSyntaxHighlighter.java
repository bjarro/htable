package htable;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import htable.psi.HTableTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HTableSyntaxHighlighter extends SyntaxHighlighterBase {

    // Define TextAttributesKey for containers (background colors)
    public static final TextAttributesKey TABLE_BACKGROUND = createTextAttributesKey("HTABLE_TABLE_BACKGROUND", JBColor.LIGHT_GRAY);
    public static final TextAttributesKey ROW_BACKGROUND = createTextAttributesKey("HTABLE_ROW_BACKGROUND", JBColor.LIGHT_GRAY);
    public static final TextAttributesKey HEADER_BACKGROUND = createTextAttributesKey("HTABLE_HEADER_BACKGROUND", JBColor.LIGHT_GRAY);
    public static final TextAttributesKey DATA_BACKGROUND = createTextAttributesKey("HTABLE_DATA_BACKGROUND", JBColor.LIGHT_GRAY);
    public static final TextAttributesKey DATA_CONTENT_BACKGROUND = createTextAttributesKey("HTABLE_DATA_CONTENT_BACKGROUND", JBColor.LIGHT_GRAY);
    public static final TextAttributesKey EXPRESSION_BACKGROUND = createTextAttributesKey("HTABLE_EXPRESSION_BACKGROUND", JBColor.LIGHT_GRAY);

    // Define TextAttributesKey for tokens (foreground colors)
    public static final TextAttributesKey IDENTIFIER_FOREGROUND = createTextAttributesKey("HTABLE_IDENTIFIER_FOREGROUND", JBColor.BLUE);
    public static final TextAttributesKey STRING_FOREGROUND = createTextAttributesKey("HTABLE_STRING_FOREGROUND", (JBColor) JBColor.MAGENTA);
    public static final TextAttributesKey NUMBER_FOREGROUND = createTextAttributesKey("HTABLE_NUMBER_FOREGROUND", (JBColor) JBColor.CYAN);
    public static final TextAttributesKey COMMENT_FOREGROUND = createTextAttributesKey("HTABLE_COMMENT_FOREGROUND", JBColor.GRAY);
    public static final TextAttributesKey OPERATOR_FOREGROUND = createTextAttributesKey("HTABLE_OPERATOR_FOREGROUND", JBColor.RED);

    private static TextAttributesKey createTextAttributesKey(@NotNull String externalName, @Nullable JBColor foreground) {
        TextAttributes textAttributes = new TextAttributes();
        if (foreground != null) {
            textAttributes.setForegroundColor(foreground);
        }
        return TextAttributesKey.createTextAttributesKey(externalName, textAttributes);
    }

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES;

    static {
        Map<IElementType, TextAttributesKey> map = new HashMap<>();
        // Map containers (HTableElementType) to TextAttributesKeys
        map.put(HTableTypes.TABLE, TABLE_BACKGROUND);
        map.put(HTableTypes.ROW, ROW_BACKGROUND);
        map.put(HTableTypes.HEADER, HEADER_BACKGROUND);
        map.put(HTableTypes.DATA, DATA_BACKGROUND);
        map.put(HTableTypes.DATA_CONTENT, DATA_CONTENT_BACKGROUND);
        map.put(HTableTypes.EXPR, EXPRESSION_BACKGROUND);
        map.put(HTableTypes.EVALUATED_EXPRESSION, EXPRESSION_BACKGROUND);
        map.put(HTableTypes.NON_EVALUATED_EXPRESSION, EXPRESSION_BACKGROUND);

        // Map tokens (HTableTokenType) to TextAttributesKeys
//        map.put(HTableTypes.IDENTIFIER, IDENTIFIER_FOREGROUND);
        map.put(HTableTypes.STRING, STRING_FOREGROUND);
        map.put(HTableTypes.NUMBER, NUMBER_FOREGROUND);
        map.put(HTableTypes.COMMENT, COMMENT_FOREGROUND);
        map.put(HTableTypes.PLUS, OPERATOR_FOREGROUND);
        map.put(HTableTypes.MINUS, OPERATOR_FOREGROUND);
        map.put(HTableTypes.MULT, OPERATOR_FOREGROUND);
        map.put(HTableTypes.DIVIDE, OPERATOR_FOREGROUND);
        map.put(HTableTypes.MODULO, OPERATOR_FOREGROUND);
        map.put(HTableTypes.EQUALS, OPERATOR_FOREGROUND);
        map.put(HTableTypes.GTHAN, OPERATOR_FOREGROUND);
        map.put(HTableTypes.LTHAN, OPERATOR_FOREGROUND);
        map.put(HTableTypes.COLON, OPERATOR_FOREGROUND);
        map.put(HTableTypes.COMMA, OPERATOR_FOREGROUND);
        map.put(HTableTypes.SCOLON, OPERATOR_FOREGROUND);
        map.put(HTableTypes.PERIOD, OPERATOR_FOREGROUND);
        map.put(HTableTypes.DQUOTE, OPERATOR_FOREGROUND);
        map.put(HTableTypes.QUOTE, OPERATOR_FOREGROUND);
        map.put(HTableTypes.LPAREN, OPERATOR_FOREGROUND);
        map.put(HTableTypes.RPAREN, OPERATOR_FOREGROUND);
        map.put(HTableTypes.LBRACKET, OPERATOR_FOREGROUND);
        map.put(HTableTypes.RBRRACKET, OPERATOR_FOREGROUND);

        ATTRIBUTES = Collections.unmodifiableMap(map);
    }

    @Override
    @NotNull
    public Lexer getHighlightingLexer() {
        return new HTableLexerAdapter();
    }

    @Override
    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));

    }
}