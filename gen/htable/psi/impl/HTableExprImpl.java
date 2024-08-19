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

public abstract class HTableExprImpl extends ASTWrapperPsiElement implements HTableExpr {

  public HTableExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HTableVisitor visitor) {
    visitor.visitExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HTableVisitor) accept((HTableVisitor)visitor);
    else super.accept(visitor);
  }

}
