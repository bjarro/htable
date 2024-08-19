package htable.psi;

import com.intellij.psi.tree.IElementType;
import htable.HTable;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HTableElementType extends IElementType {
    public HTableElementType(@NotNull @NonNls String debugName) {
        super(debugName, HTable.INSTANCE);
    }
}