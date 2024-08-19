package htable;

import com.intellij.lang.Language;

public class HTable extends Language {
    public static final HTable INSTANCE = new HTable();

    private HTable() {
        super("HTable");
    }
}