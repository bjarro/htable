package lookup;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/*import jflex.Main;
import jflex.SilentExit;*/

/**
 * Contains the dictionary of lexeme - tokens pairs for a specific language
 * Also contains the lexical states used for determining syntax
 */
public class LexDict extends HashMap<String, String> {
    private String path;
    private HashMap<String, LexState> stateMap;

    /*    To do:
        Required::: Explicitly handle same keys (Tokens)
        */
    public LexDict(String path) {
        this.path = path;
        loadFile(path);
    }

    /**
     * @param path - path to file containing lexeme - token pairs
     */
    protected void loadFile(String path) {

        String string = "";

        File file = new File(path);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
            String[] tokens = line.split("\\s+", 2);

            System.out.println("token 0 : " + tokens[0]);

            if (tokens.length == 2)
                this.put(tokens[0], "\"" + tokens[1] + "\"");
        }
    }

    /**
     * overwrites original textFile
     */
    public void writeFile() {
        StringBuilder string = new StringBuilder();
        for (Entry entry : this.entrySet()) {
            String line = String.format("%s    %s\n", entry.getKey(), entry.getValue());
            string.append(line);
        }

        try {
            Files.write(Paths.get(path), string.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes to a specific file
     * Sets this.path as path
     *
     * @param path - path where file will be written
     */
    public void writeFile(String path) {
        this.path = path;
        writeFile();
    }

/*    public void generateLexer(String path) throws SilentExit {
        Main.generate(new String[]{path});
    }*/


    public void addState(String stateName, String openString, String closeString) {
        LexState lexState = new LexState(stateName, openString, closeString);
        stateMap.put(stateName, lexState);
    }

    public String getOpenString(String stateName) {
        LexState lexState = stateMap.get(stateName);
        if (lexState != null)
            return lexState.getOpenString();

        else return "No such LexState : " + stateName;
    }

    public String getCloseString(String stateName) {
        LexState lexState = stateMap.get(stateName);
        if (lexState != null)
            return lexState.getCloseString();

        else return "No such LexState : " + stateName;
    }

    public HashMap<String, LexState> getStates() {
        return stateMap;
    }


}