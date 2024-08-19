package lookup;

public class HTMLLexDict extends LexDict {

    public static final String STATE_NUMBER = "NUMBER";
    public static final String STATE_COMMENT = "COMMENT";


    public HTMLLexDict(String path) {
        super(path);
        initializeStates();

    }


    @Override
    public void loadFile(String path) {
        super.loadFile(path);
        put("NUMBER", "{Number}");
        put("IDENT", "{Identifier}");
        put("TAGIDENT", "\"<\" {Identifier}");
        put("EOF", "EOF");
    }


    public void initializeStates() {
        addState(STATE_NUMBER, "[0-9]", " ");
        addState(STATE_COMMENT, "<!--", "-->");
    }


}



