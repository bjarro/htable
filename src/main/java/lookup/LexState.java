package lookup;

public class LexState {
    private String name;
    private String openString;
    private String closeString;
    private String condition;
    private String error;

    public LexState(String name, String openString, String closeString, String condition, String error) {
        this.name = name;
        this.openString = openString;
        this.closeString = closeString;
        this.condition = condition;
        this.error = error;
    }

    public LexState(String name, String openString, String closeString) {
        this.name = name;
        this.openString = openString;
        this.closeString = closeString;
    }

    public String getName() {
        return name;
    }

    public String getOpenString() {
        return openString;
    }

    public String getCloseString() {
        return closeString;
    }


}
