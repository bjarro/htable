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

Number = {Floating} | {DecIntegerLiteral}

DecIntegerLiteral = 0 | [1-9][0-9]*
Floating = [0-9]+ \. [0-9]+ [eE] [\+\-]? [0-9]+
FloatingRightSide = \. [0-9]+ [eE] [\+\-]? [0-9]+


%state STATE_NUMBER_INTEGER
%state STATE_NUMBER_DECIMAL
%state STATE_NUMBER_FAIL
%state STATE_COMMENT

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
  [1-9]              {yybegin(STATE_NUMBER_INTEGER);}
  [0]                {yybegin(STATE_NUMBER_DECIMAL);}
  "<!--"             {yybegin(STATE_COMMENT);}
{IDENTIFIER}         {return IDENTIFIER; }

}


<STATE_NUMBER_INTEGER> {
{WHITE_SPACE} {yybegin(YYINITIAL); return NUMBER;}
{Number} {}
<<EOF>> {yybegin(YYINITIAL); return EOF;}
[^] {yybegin(STATE_NUMBER_FAIL);}
}

<STATE_NUMBER_DECIMAL> {
{WHITE_SPACE} {yybegin(YYINITIAL); return NUMBER;}
{FloatingRightSide} {}
<<EOF>> {yybegin(YYINITIAL); return EOF;}
[^] {yybegin(STATE_NUMBER_FAIL);}
}

<STATE_NUMBER_FAIL> {
{WHITE_SPACE} {yybegin(YYINITIAL); return BAD_NUMBER;}
<<EOF>> {yybegin(YYINITIAL); return EOF;}
[^] {}
}

<STATE_COMMENT> {
"-->" {yybegin(YYINITIAL); return COMMENT;}
<<EOF>> {yybegin(YYINITIAL); return EOF;}
[^] {}
}

[^] { return BAD_CHARACTER; }
