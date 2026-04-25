import java.util.*;

public class SimpleTreeNode<T>{
    private T data = null;
    private List<SimpleTreeNode> children = new ArrayList<>();
    private SimpleTreeNode parent = null;

    public SimpleTreeNode(T data) {
        this.data = data;
    }

    public void addChild(SimpleTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        SimpleTreeNode<T> newChild = new SimpleTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<SimpleTreeNode> children) {
        for(SimpleTreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<SimpleTreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(SimpleTreeNode parent) {
        this.parent = parent;
    }

    public SimpleTreeNode getParent() {
        return parent;
    }

    public String getParents(SimpleTreeNode node)
    {
        Deque stack = new LinkedList<SimpleTreeNode>();
        String path="";
        SimpleTreeNode parentNode = node.getParent();
        while (parentNode != null)
        {
            stack.push(parentNode);
            parentNode = parentNode.getParent();
        }
        Iterator<SimpleTreeNode> itr = stack.iterator();
        while (itr.hasNext()) {
            path = path + ((SimpleTreeNode) itr.next()).data + ":";
        }
        return path;
    }

    public int childCount()
    {
        return (int)getChildren().stream().count();
    }

    public void printChildren(SimpleTreeNode node) {
        if (node.parent != null) {
            if (node.children.size() == 0) {
                System.out.println(node.getParents((SimpleTreeNode) node) + ((SimpleTreeNode) node).data);
            } else {
                for (Object child : node.getChildren()) {
                    System.out.println(node.getParents((SimpleTreeNode) child) + ((SimpleTreeNode) child).data);
                    for (Object childOfChild : ((SimpleTreeNode) child).getChildren())
                        printChildren((SimpleTreeNode) childOfChild);
                }
            }
        }
    }

    public void printTree(String indent) {
        String display = this.getData().toString();
        System.out.println(indent + "└── " + display);
        for (SimpleTreeNode<T> child : getChildren()) {
            child.printTree(indent + "    ");
        }
    }

    public static SimpleTreeNode<SpaceNode> buildSolarSystem() {

        // Level 1 - Root
        SimpleTreeNode<SpaceNode> root = new SimpleTreeNode<>(
                new SpaceNode("Solar System", "System", "N/A"));

        // Level 2 - Major Groups
        SimpleTreeNode<SpaceNode> sun = new SimpleTreeNode<>(
                new SpaceNode("The Sun", "Star", "N/A"));
        SimpleTreeNode<SpaceNode> innerPlanets = new SimpleTreeNode<>(
                new SpaceNode("Inner Planets", "Group", "N/A"));
        SimpleTreeNode<SpaceNode> outerPlanets = new SimpleTreeNode<>(
                new SpaceNode("Outer Planets", "Group", "N/A"));
        SimpleTreeNode<SpaceNode> dwarfPlanets = new SimpleTreeNode<>(
                new SpaceNode("Dwarf Planets", "Group", "N/A"));

        // Level 3 - Inner Planets
        SimpleTreeNode<SpaceNode> mercury = new SimpleTreeNode<>(
                new SpaceNode("Mercury", "Planet", "88 Earth days"));
        SimpleTreeNode<SpaceNode> venus = new SimpleTreeNode<>(
                new SpaceNode("Venus", "Planet", "225 Earth days"));
        SimpleTreeNode<SpaceNode> earth = new SimpleTreeNode<>(
                new SpaceNode("Earth", "Planet", "365 days"));
        SimpleTreeNode<SpaceNode> mars = new SimpleTreeNode<>(
                new SpaceNode("Mars", "Planet", "687 Earth days"));

        // Level 3 - Outer Planets
        SimpleTreeNode<SpaceNode> jupiter = new SimpleTreeNode<>(
                new SpaceNode("Jupiter", "Planet", "11.9 Earth years"));
        SimpleTreeNode<SpaceNode> saturn = new SimpleTreeNode<>(
                new SpaceNode("Saturn", "Planet", "29.5 Earth years"));
        SimpleTreeNode<SpaceNode> uranus = new SimpleTreeNode<>(
                new SpaceNode("Uranus", "Planet", "84 Earth years"));
        SimpleTreeNode<SpaceNode> neptune = new SimpleTreeNode<>(
                new SpaceNode("Neptune", "Planet", "165 Earth years"));

        // Level 3 - Dwarf Planets
        SimpleTreeNode<SpaceNode> pluto = new SimpleTreeNode<>(
                new SpaceNode("Pluto", "Dwarf Planet", "248 Earth years"));
        SimpleTreeNode<SpaceNode> eris = new SimpleTreeNode<>(
                new SpaceNode("Eris", "Dwarf Planet", "559 Earth years"));
        SimpleTreeNode<SpaceNode> ceres = new SimpleTreeNode<>(
                new SpaceNode("Ceres", "Dwarf Planet", "4.6 Earth years"));

        // Level 4 - Moons
        SimpleTreeNode<SpaceNode> moon = new SimpleTreeNode<>(
                new SpaceNode("Moon", "Moon", "27.3 days"));
        SimpleTreeNode<SpaceNode> phobos = new SimpleTreeNode<>(
                new SpaceNode("Phobos", "Moon", "0.32 days"));
        SimpleTreeNode<SpaceNode> deimos = new SimpleTreeNode<>(
                new SpaceNode("Deimos", "Moon", "1.26 days"));
        SimpleTreeNode<SpaceNode> io = new SimpleTreeNode<>(
                new SpaceNode("Io", "Moon", "1.77 days"));
        SimpleTreeNode<SpaceNode> europa = new SimpleTreeNode<>(
                new SpaceNode("Europa", "Moon", "3.55 days"));
        SimpleTreeNode<SpaceNode> ganymede = new SimpleTreeNode<>(
                new SpaceNode("Ganymede", "Moon", "7.15 days"));
        SimpleTreeNode<SpaceNode> callisto = new SimpleTreeNode<>(
                new SpaceNode("Callisto", "Moon", "16.7 days"));
        SimpleTreeNode<SpaceNode> titan = new SimpleTreeNode<>(
                new SpaceNode("Titan", "Moon", "15.9 days"));
        SimpleTreeNode<SpaceNode> enceladus = new SimpleTreeNode<>(
                new SpaceNode("Enceladus", "Moon", "1.37 days"));
        SimpleTreeNode<SpaceNode> triton = new SimpleTreeNode<>(
                new SpaceNode("Triton", "Moon", "5.88 days"));

        // Attach moons to their planets
        earth.addChild(moon);
        mars.addChild(phobos);
        mars.addChild(deimos);
        jupiter.addChild(io);
        jupiter.addChild(europa);
        jupiter.addChild(ganymede);
        jupiter.addChild(callisto);
        saturn.addChild(titan);
        saturn.addChild(enceladus);
        neptune.addChild(triton);

        // Attach planets to their groups
        innerPlanets.addChild(mercury);
        innerPlanets.addChild(venus);
        innerPlanets.addChild(earth);
        innerPlanets.addChild(mars);
        outerPlanets.addChild(jupiter);
        outerPlanets.addChild(saturn);
        outerPlanets.addChild(uranus);
        outerPlanets.addChild(neptune);
        dwarfPlanets.addChild(pluto);
        dwarfPlanets.addChild(eris);
        dwarfPlanets.addChild(ceres);

        // Attach groups to root
        root.addChild(sun);
        root.addChild(innerPlanets);
        root.addChild(outerPlanets);
        root.addChild(dwarfPlanets);

        return root;
    }

    public static void printSolarSystem(SimpleTreeNode<SpaceNode> root) {
        System.out.println("Solar System Hierarchy:");
        System.out.println("=======================");
        root.printTree("");
    }

    public static void main(String[] args) {
        SimpleTreeNode<SpaceNode> root = buildSolarSystem();
        printSolarSystem(root);
    }
}