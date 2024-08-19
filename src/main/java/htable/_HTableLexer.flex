package htable;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static htable.psi.HTableTypes.*;

%%

%{
  public _HTableLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _HTableLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

IDENTIFIER=[a-zA-Z]+
NUMBER=([0-9]+\.[0-9]+[eE][+-]?[0-9]+)|([0-9]+(\.[0-9]*)?)
COMMENT=(<!--)(\.|.)*(-->)
WHITE_SPACE=\r|\n|\r\n|[ \t\f]

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "+"                { return PLUS; }
  "-"                { return MINUS; }
  "*"                { return MULT; }
  "/"                { return DIVIDE; }
  "%"                { return MODULO; }
  "**"               { return EXP; }
  "="                { return EQUALS; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  ">"                { return GTHAN; }
  "<"                { return LTHAN; }
  "["                { return LBRACKET; }
  "]"                { return RBRRACKET; }
  ";"                { return SCOLON; }
  ","                { return COMMA; }
  "'"                { return QUOTE; }
  ":"                { return COLON; }
  "."                { return PERIOD; }
  "\""               { return DQUOTE; }

  {IDENTIFIER}       { return IDENTIFIER; }
  {NUMBER}           { return NUMBER; }
  {COMMENT}          { return COMMENT; }
  {WHITE_SPACE}      { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
