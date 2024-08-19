package htable.psi;

import com.intellij.psi.tree.IElementType;
import htable.HTable;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HTableTokenType extends IElementType {
    public HTableTokenType(@NotNull @NonNls String debugName) {
        super(debugName, HTable.INSTANCE);
    }

    @Override
    public String toString() {
        return "HTableTokenType." + super.toString();
    }
}