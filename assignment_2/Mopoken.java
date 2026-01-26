package assignment_2.Mopoken;

public class Mopoken {

    private String type;
    private int level;

    public Mopoken(String type, int level) {
        this.type = type;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return type + "#" + level;
    }
}
