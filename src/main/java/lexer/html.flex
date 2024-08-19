/* JFlex example: partial Java language lexer specification */

package lexer;

/**
 * This class is a simple example lexer.
 */
%%

%class Lexer
%unicode
%line
%column
%type String

%{
  StringBuffer string = new StringBuffer();
%}


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*


Identifier = [A-Za-z]+
DecIntegerLiteral = 0 | [1-9][0-9]*
Floating = [0-9]+ \. [0-9]+ [eE] [\+\-]? [0-9]+
FloatingRightSide = \. [0-9]+ [eE] [\+\-]? [0-9]+


Number = {Floating} | {DecIntegerLiteral}

%state STATE_NUMBER_INTEGER
%state STATE_NUMBER_DECIMAL
%state STATE_NUMBER_FAIL
%state STATE_COMMENT


%%

<YYINITIAL> {WhiteSpace} {}
<YYINITIAL> "," { return "COMMA " + yytext(); }
<YYINITIAL> "'" { return "QUOTE " +yytext(); }
<YYINITIAL> "=" { return "EQUALS " +yytext(); }
<YYINITIAL> ">" { return "GTHAN " +yytext(); }
<YYINITIAL> "%" { return "MODULO " +yytext(); }
<YYINITIAL> "(" { return "LPAREN " +yytext(); }
<YYINITIAL> "[" { return "LBRACKET " +yytext(); }
<YYINITIAL> "</" { return "ENDTAGHEAD " +yytext(); }
<YYINITIAL> "]" { return "RBRACKET " +yytext(); }
<YYINITIAL> ":" { return "COLON " +yytext(); }
<YYINITIAL> ")" { return "RPAREN " +yytext(); }
<YYINITIAL> "-" { return "MINUS " +yytext(); }
<YYINITIAL> "/" { return "DIVIDE " +yytext(); }
<YYINITIAL> "<" {Identifier} { return "TAGIDENT " +yytext(); }
<YYINITIAL> {Identifier} { return "IDENT " +yytext(); }
<YYINITIAL> "*" { return "MULT " +yytext(); }
<YYINITIAL> "." { return "PERIOD " +yytext(); }
<YYINITIAL> "<" { return "LTHAN " +yytext(); }
<YYINITIAL> ";" { return "SCOLON " +yytext(); }
<YYINITIAL> "**" { return "EXP " +yytext(); }
<YYINITIAL> EOF { return "EOF " +yytext(); }
<YYINITIAL> "\"" { return "DQUOTE " +yytext(); }
<YYINITIAL> "+" { return "PLUS " +yytext(); }
<YYINITIAL> [1-9] {string.setLength(0); yybegin(STATE_NUMBER_INTEGER); string.append( yytext());}
<YYINITIAL> [0] {string.setLength(0); yybegin(STATE_NUMBER_DECIMAL); string.append( yytext());}
<YYINITIAL> "<!--" {string.setLength(0); yybegin(STATE_COMMENT); string.append( yytext());}
<YYINITIAL> [^] { return "illegal character " +yytext();}

<STATE_NUMBER_INTEGER> {
{WhiteSpace} {yybegin(YYINITIAL); return "NUMBER " + string.toString();}
{Number} {string.append(yytext());}
<<EOF>> {yybegin(YYINITIAL); return "unexpected end of file";}
[^] {yybegin(STATE_NUMBER_FAIL);}
}

<STATE_NUMBER_DECIMAL> {
{WhiteSpace} {yybegin(YYINITIAL); return "NUMBER " + string.toString();}
{FloatingRightSide} {string.append(yytext());}
<<EOF>> {yybegin(YYINITIAL); return "unexpected end of file";}
[^] {yybegin(STATE_NUMBER_FAIL);}
}

<STATE_NUMBER_FAIL> {
{WhiteSpace} {yybegin(YYINITIAL); return "badly formed number";}
<<EOF>> {yybegin(YYINITIAL); return "unexpected end of file";}
[^] {}
}

<STATE_COMMENT> {
"-->" {yybegin(YYINITIAL);}
<<EOF>> {yybegin(YYINITIAL); return "unexpected end of file";}
[^] {string.append(yytext());}
}











