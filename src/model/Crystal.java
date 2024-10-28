package src.model;

public enum Crystal {
    RED_CRYSTAL("red"),
    WHITE_CRYSTAL("white");

    private final String type;

    Crystal(String type) {
        this.type = type;
    }

    public String toString() {
        return "Crystal type: " + type;
    }
}
