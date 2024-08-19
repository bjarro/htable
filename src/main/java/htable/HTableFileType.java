package htable;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class HTableFileType extends LanguageFileType {
    public static final HTableFileType INSTANCE = new HTableFileType();

    private HTableFileType() {
        super(HTable.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "HTable file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "HTable language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "htable";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return HTableIcon.FILE;
    }
}