
public class SpaceNode {
    private String name;
    private String type;
    private String yearLength;

    public SpaceNode(String name, String type, String yearLength) {
        this.name = name;
        this.type = type;
        this.yearLength = yearLength;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getYearLength() { return yearLength; }

    @Override
    public String toString() {
        return name + "\n(" + type + ")\n" + yearLength;
    }
}