// This is a generated file. Not intended for manual editing.
package htable.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static htable.psi.HTableTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class HTableParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(DIV_EXPR, EXPR, EXP_EXPR, LITERAL_EXPR,
      MINUS_EXPR, MODULO_EXPR, MUL_EXPR, PAREN_EXPR,
      PLUS_EXPR, UNARY_MIN_EXPR, UNARY_PLUS_EXPR),
  };

  /* ********************************************************** */
  // '<td>' data_content '</td>'
  public static boolean data(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA, "<data>");
    r = consumeToken(b, "<td>");
    r = r && data_content(b, l + 1);
    r = r && consumeToken(b, "</td>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string | evaluated_expression | non_evaluated_expression
  public static boolean data_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_CONTENT, "<data content>");
    r = string(b, l + 1);
    if (!r) r = evaluated_expression(b, l + 1);
    if (!r) r = non_evaluated_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQUALS expr
  public static boolean evaluated_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "evaluated_expression")) return false;
    if (!nextTokenIs(b, EQUALS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, EVALUATED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // '<th>' string '</th>'
  public static boolean header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER, "<header>");
    r = consumeToken(b, "<th>");
    r = r && string(b, l + 1);
    r = r && consumeToken(b, "</th>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '<tr>' header+ '</tr>'
  public static boolean header_row(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_row")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER_ROW, "<header row>");
    r = consumeToken(b, "<tr>");
    r = r && header_row_1(b, l + 1);
    r = r && consumeToken(b, "</tr>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // header+
  private static boolean header_row_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_row_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = header(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!header(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "header_row_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ident")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET expr RBRRACKET
  public static boolean non_evaluated_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_evaluated_expression")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, RBRRACKET);
    exit_section_(b, m, NON_EVALUATED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean numb(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numb")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, NUMB, r);
    return r;
  }

  /* ********************************************************** */
  // SCOLON | COMMA | QUOTE | DQUOTE | COLON | PERIOD
  public static boolean punctuation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "punctuation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PUNCTUATION, "<punctuation>");
    r = consumeToken(b, SCOLON);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, QUOTE);
    if (!r) r = consumeToken(b, DQUOTE);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '<table>' table '</table>'
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<table>");
    r = r && table(b, l + 1);
    r = r && consumeToken(b, "</table>");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<tr>' data+ '</tr>'
  public static boolean row(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "row")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ROW, "<row>");
    r = consumeToken(b, "<tr>");
    r = r && row_1(b, l + 1);
    r = r && consumeToken(b, "</tr>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // data+
  private static boolean row_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "row_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!data(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "row_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // row*
  public static boolean row_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "row_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, ROW_LIST, "<row list>");
    while (true) {
      int c = current_position_(b);
      if (!row(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "row_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // (ident | numb | punctuation)+
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = string_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!string_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ident | numb | punctuation
  private static boolean string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0")) return false;
    boolean r;
    r = ident(b, l + 1);
    if (!r) r = numb(b, l + 1);
    if (!r) r = punctuation(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // header_row row_list
  public static boolean table(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE, "<table>");
    r = header_row(b, l + 1);
    r = r && row_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(plus_expr) BINARY(minus_expr)
  // 1: BINARY(mul_expr) BINARY(div_expr) BINARY(modulo_expr)
  // 2: PREFIX(unary_plus_expr) PREFIX(unary_min_expr)
  // 3: N_ARY(exp_expr)
  // 4: ATOM(literal_expr) PREFIX(paren_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_plus_expr(b, l + 1);
    if (!r) r = unary_min_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, PLUS)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, MINUS)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, MULT)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, DIVIDE)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, MODULO)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, MODULO_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, EXP)) {
        while (true) {
          r = report_error_(b, expr(b, l, 3));
          if (!consumeTokenSmart(b, EXP)) break;
        }
        exit_section_(b, l, m, EXP_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean unary_plus_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_plus_expr")) return false;
    if (!nextTokenIsSmart(b, PLUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, PLUS);
    p = r;
    r = p && expr(b, l, 2);
    exit_section_(b, l, m, UNARY_PLUS_EXPR, r, p, null);
    return r || p;
  }

  public static boolean unary_min_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_min_expr")) return false;
    if (!nextTokenIsSmart(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, MINUS);
    p = r;
    r = p && expr(b, l, 2);
    exit_section_(b, l, m, UNARY_MIN_EXPR, r, p, null);
    return r || p;
  }

  // NUMBER
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    if (!nextTokenIsSmart(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, NUMBER);
    exit_section_(b, m, LITERAL_EXPR, r);
    return r;
  }

  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r;
    r = p && expr(b, l, -1);
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    exit_section_(b, l, m, PAREN_EXPR, r, p, null);
    return r || p;
  }

}
