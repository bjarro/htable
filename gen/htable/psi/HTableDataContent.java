// This is a generated file. Not intended for manual editing.
package htable.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HTableDataContent extends PsiElement {

  @Nullable
  HTableEvaluatedExpression getEvaluatedExpression();

  @Nullable
  HTableNonEvaluatedExpression getNonEvaluatedExpression();

  @Nullable
  HTableString getString();

}
