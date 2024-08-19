import static org.junit.jupiter.api.Assertions.*;

import lexer.Lexer;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class LexerTest {

    @Test
    public void testLexer() {
        String input = """
            <!-- a comment -->
            <table>
            <tr><td> ballpen </td> <td> 10.25 </td>   </tr>
            <tr> <td> pencil </td> <td> 5.55 </td>    </tr>
            </table>""";

        Lexer lexer = new Lexer(new StringReader(input));

        try {
            String token;
            while ((token = lexer.yylex()) != null) {
                System.out.println(token);
            }
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testLexerWithFile() {
        try (FileReader reader = new FileReader("build/resources/test/table.htable")) {
            Lexer lexer = new Lexer(reader);
            String token;
            while ((token = lexer.yylex()) != null) {
                System.out.println(token);
            }
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}