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
Number = {Floating} | {DecIntegerLiteral}

%state STRING

%%

<YYINITIAL> {WhiteSpace} {}
<YYINITIAL> {Comment} {}
