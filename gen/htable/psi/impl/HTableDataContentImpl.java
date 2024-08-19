// This is a generated file. Not intended for manual editing.
package htable.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static htable.psi.HTableTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import htable.psi.*;

public class HTableDataContentImpl extends ASTWrapperPsiElement implements HTableDataContent {

  public HTableDataContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HTableVisitor visitor) {
    visitor.visitDataContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HTableVisitor) accept((HTableVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HTableEvaluatedExpression getEvaluatedExpression() {
    return findChildByClass(HTableEvaluatedExpression.class);
  }

  @Override
  @Nullable
  public HTableNonEvaluatedExpression getNonEvaluatedExpression() {
    return findChildByClass(HTableNonEvaluatedExpression.class);
  }

  @Override
  @Nullable
  public HTableString getString() {
    return findChildByClass(HTableString.class);
  }

}
