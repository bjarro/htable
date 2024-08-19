// This is a generated file. Not intended for manual editing.
package htable.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static htable.psi.HTableTypes.*;
import htable.psi.*;

public class HTableUnaryPlusExprImpl extends HTableExprImpl implements HTableUnaryPlusExpr {

  public HTableUnaryPlusExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull HTableVisitor visitor) {
    visitor.visitUnaryPlusExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HTableVisitor) accept((HTableVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HTableExpr getExpr() {
    return findChildByClass(HTableExpr.class);
  }

}
