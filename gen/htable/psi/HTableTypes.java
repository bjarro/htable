// This is a generated file. Not intended for manual editing.
package htable.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import htable.psi.impl.*;

public interface HTableTypes {

  IElementType DATA = new HTableElementType("DATA");
  IElementType DATA_CONTENT = new HTableElementType("DATA_CONTENT");
  IElementType DIV_EXPR = new HTableElementType("DIV_EXPR");
  IElementType EVALUATED_EXPRESSION = new HTableElementType("EVALUATED_EXPRESSION");
  IElementType EXPR = new HTableElementType("EXPR");
  IElementType EXP_EXPR = new HTableElementType("EXP_EXPR");
  IElementType HEADER = new HTableElementType("HEADER");
  IElementType HEADER_ROW = new HTableElementType("HEADER_ROW");
  IElementType IDENT = new HTableElementType("IDENT");
  IElementType LITERAL_EXPR = new HTableElementType("LITERAL_EXPR");
  IElementType MINUS_EXPR = new HTableElementType("MINUS_EXPR");
  IElementType MODULO_EXPR = new HTableElementType("MODULO_EXPR");
  IElementType MUL_EXPR = new HTableElementType("MUL_EXPR");
  IElementType NON_EVALUATED_EXPRESSION = new HTableElementType("NON_EVALUATED_EXPRESSION");
  IElementType NUMB = new HTableElementType("NUMB");
  IElementType PAREN_EXPR = new HTableElementType("PAREN_EXPR");
  IElementType PLUS_EXPR = new HTableElementType("PLUS_EXPR");
  IElementType PUNCTUATION = new HTableElementType("PUNCTUATION");
  IElementType ROW = new HTableElementType("ROW");
  IElementType ROW_LIST = new HTableElementType("ROW_LIST");
  IElementType STRING = new HTableElementType("STRING");
  IElementType TABLE = new HTableElementType("TABLE");
  IElementType UNARY_MIN_EXPR = new HTableElementType("UNARY_MIN_EXPR");
  IElementType UNARY_PLUS_EXPR = new HTableElementType("UNARY_PLUS_EXPR");

  IElementType COLON = new HTableTokenType(":");
  IElementType COMMA = new HTableTokenType(",");
  IElementType COMMENT = new HTableTokenType("COMMENT");
  IElementType DIVIDE = new HTableTokenType("/");
  IElementType DQUOTE = new HTableTokenType("DQUOTE");
  IElementType EQUALS = new HTableTokenType("=");
  IElementType EXP = new HTableTokenType("**");
  IElementType GTHAN = new HTableTokenType(">");
  IElementType IDENTIFIER = new HTableTokenType("IDENTIFIER");
  IElementType LBRACKET = new HTableTokenType("[");
  IElementType LPAREN = new HTableTokenType("(");
  IElementType LTHAN = new HTableTokenType("<");
  IElementType MINUS = new HTableTokenType("-");
  IElementType MODULO = new HTableTokenType("%");
  IElementType MULT = new HTableTokenType("*");
  IElementType NUMBER = new HTableTokenType("NUMBER");
  IElementType PERIOD = new HTableTokenType(".");
  IElementType PLUS = new HTableTokenType("+");
  IElementType QUOTE = new HTableTokenType("'");
  IElementType RBRRACKET = new HTableTokenType("]");
  IElementType RPAREN = new HTableTokenType(")");
  IElementType SCOLON = new HTableTokenType(";");
  IElementType __ = new HTableTokenType("\\\"");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DATA) {
        return new HTableDataImpl(node);
      }
      else if (type == DATA_CONTENT) {
        return new HTableDataContentImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new HTableDivExprImpl(node);
      }
      else if (type == EVALUATED_EXPRESSION) {
        return new HTableEvaluatedExpressionImpl(node);
      }
      else if (type == EXP_EXPR) {
        return new HTableExpExprImpl(node);
      }
      else if (type == HEADER) {
        return new HTableHeaderImpl(node);
      }
      else if (type == HEADER_ROW) {
        return new HTableHeaderRowImpl(node);
      }
      else if (type == IDENT) {
        return new HTableIdentImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new HTableLiteralExprImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new HTableMinusExprImpl(node);
      }
      else if (type == MODULO_EXPR) {
        return new HTableModuloExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new HTableMulExprImpl(node);
      }
      else if (type == NON_EVALUATED_EXPRESSION) {
        return new HTableNonEvaluatedExpressionImpl(node);
      }
      else if (type == NUMB) {
        return new HTableNumbImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new HTableParenExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new HTablePlusExprImpl(node);
      }
      else if (type == PUNCTUATION) {
        return new HTablePunctuationImpl(node);
      }
      else if (type == ROW) {
        return new HTableRowImpl(node);
      }
      else if (type == ROW_LIST) {
        return new HTableRowListImpl(node);
      }
      else if (type == STRING) {
        return new HTableStringImpl(node);
      }
      else if (type == TABLE) {
        return new HTableTableImpl(node);
      }
      else if (type == UNARY_MIN_EXPR) {
        return new HTableUnaryMinExprImpl(node);
      }
      else if (type == UNARY_PLUS_EXPR) {
        return new HTableUnaryPlusExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
