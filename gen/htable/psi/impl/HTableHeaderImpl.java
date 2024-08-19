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

public class HTableHeaderImpl extends ASTWrapperPsiElement implements HTableHeader {

  public HTableHeaderImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HTableVisitor visitor) {
    visitor.visitHeader(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HTableVisitor) accept((HTableVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HTableString getString() {
    return findNotNullChildByClass(HTableString.class);
  }

}
