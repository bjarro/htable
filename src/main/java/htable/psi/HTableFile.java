package htable.psi;


import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import htable.HTable;
import htable.HTableFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class HTableFile extends PsiFileBase {
    public HTableFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, HTable.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return HTableFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "HTable File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}