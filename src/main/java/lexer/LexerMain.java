package lexer;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LexerMain {

    public static void main(String[] args) throws IOException {

        String path = args[0];
        String dest = args[1];

        Lexer lexer = new Lexer(new FileReader(path));


        StringBuilder string = new StringBuilder();

        String match = lexer.yylex();
        do {
            string.append(match);
            System.out.println(match);
            match = lexer.yylex();
        } while (match != null);

        Files.write(Paths.get(dest), string.toString().getBytes());


    }


}
