package htable;

import com.intellij.lexer.FlexAdapter;
import java.io.Reader;
import htable._HTableLexer;

public class HTableLexerAdapter extends FlexAdapter {
    public HTableLexerAdapter() {
        super(new _HTableLexer((Reader) null));
    }
}