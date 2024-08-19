package htable;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


public class HTableAnnotator implements Annotator {

    private static final TextAttributesKey OPENING_TAG = TextAttributesKey.createTextAttributesKey("HTML_OPENING_TAG", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey CLOSING_TAG = TextAttributesKey.createTextAttributesKey("HTML_CLOSING_TAG", DefaultLanguageHighlighterColors.KEYWORD);

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        String text = element.getText();
        IElementType elementType = element.getNode().getElementType();

        if (!(element instanceof htable.psi.impl.HTableTableImpl || element instanceof htable.psi.impl.HTableHeaderRowImpl ||
                element instanceof htable.psi.impl.HTableRowImpl || element instanceof htable.psi.impl.HTableDataImpl ||
                element instanceof htable.psi.impl.HTableHeaderImpl)) {
            // Skip elements that are not one of the specified types
            return;
        }

        System.out.println("Element Text: " + text);
        System.out.println("Element Type: " + elementType);

//        String text = element.getText();
        TextRange textRange = element.getTextRange();

        // Find opening tag range
        int openingTagEnd = text.indexOf('>') + 1;
        if (openingTagEnd > 0) {
            TextRange openingTagRange = new TextRange(textRange.getStartOffset(), textRange.getStartOffset() + openingTagEnd);
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(openingTagRange)
                    .textAttributes(OPENING_TAG)
                    .create();
        }

        // Find closing tag range
        int closingTagStart = text.lastIndexOf('<');
        if (closingTagStart >= 0) {
            TextRange closingTagRange = new TextRange(textRange.getEndOffset() - (text.length() - closingTagStart), textRange.getEndOffset());
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(closingTagRange)
                    .textAttributes(CLOSING_TAG)
                    .create();
        }
    }
}