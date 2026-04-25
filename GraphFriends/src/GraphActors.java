import java.util.*;

class Graph {
    private Map<Actor, List<Actor>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(Actor u, Actor v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public void DFS(Actor startNode) {
        Set<Actor> visited = new HashSet<>();
        Stack<Actor> stack = new Stack<>();
        stack.push(startNode);
        visited.add(startNode);
        System.out.println("Depth-First Search (DFS):");
        while (!stack.isEmpty()) {
            Actor node = stack.pop();
            System.out.print(node + " ");
            List<Actor> neighbors = adjList.getOrDefault(node, new ArrayList<>());
            for (Actor neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void BFS(Actor startNode) {
        Set<Actor> visited = new HashSet<>();
        Queue<Actor> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);
        System.out.println("Breadth-First Search (BFS):");
        while (!queue.isEmpty()) {
            Actor node = queue.poll();
            System.out.print(node + " ");
            List<Actor> neighbors = adjList.getOrDefault(node, new ArrayList<>());
            for (Actor neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void printConnectedNodesList() {
        for (Map.Entry<Actor, List<Actor>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " - connected nodes: ");
            System.out.println(entry.getValue());
        }
    }
}

public class GraphActors {

    private static Actor chuckNorris;

    public static void main(String[] args) {
        Graph graph = new Graph();
        buildGraph(graph);
        runTraversals(graph);
        printConnections(graph);
    }

    private static void buildGraph(Graph graph) {
        chuckNorris                    = new Actor("Chuck Norris",           "Hub");
        Actor bruceLee                 = new Actor("Bruce Lee",              "Sub-Hub");
        Actor sylvesterStallone        = new Actor("Sylvester Stallone",     "Sub-Hub");
        Actor arnoldSchwarzenegger     = new Actor("Arnold Schwarzenegger",  "Sub-Hub");
        Actor bruceWillis              = new Actor("Bruce Willis",           "Sub-Hub");
        Actor jackieChan               = new Actor("Jackie Chan",            "Node");
        Actor jimKelly                 = new Actor("Jim Kelly",              "Node");
        Actor jamesEarlJones           = new Actor("James Earl Jones",       "Node");
        Actor lindaHamilton            = new Actor("Linda Hamilton",         "Node");
        Actor dannyDeVito              = new Actor("Danny DeVito",           "Node");
        Actor markHamill               = new Actor("Mark Hamill",            "Node");

        // Chuck Norris - Hub
        graph.addEdge(chuckNorris, bruceLee);
        graph.addEdge(bruceLee, chuckNorris);
        graph.addEdge(chuckNorris, sylvesterStallone);
        graph.addEdge(sylvesterStallone, chuckNorris);
        graph.addEdge(chuckNorris, arnoldSchwarzenegger);
        graph.addEdge(arnoldSchwarzenegger, chuckNorris);
        graph.addEdge(chuckNorris, bruceWillis);
        graph.addEdge(bruceWillis, chuckNorris);

        // Bruce Lee branch
        graph.addEdge(bruceLee, jackieChan);
        graph.addEdge(jackieChan, bruceLee);
        graph.addEdge(bruceLee, jimKelly);
        graph.addEdge(jimKelly, bruceLee);

        // Expendables triangle
        graph.addEdge(sylvesterStallone, arnoldSchwarzenegger);
        graph.addEdge(arnoldSchwarzenegger, sylvesterStallone);
        graph.addEdge(sylvesterStallone, bruceWillis);
        graph.addEdge(bruceWillis, sylvesterStallone);
        graph.addEdge(arnoldSchwarzenegger, bruceWillis);
        graph.addEdge(bruceWillis, arnoldSchwarzenegger);

        // Arnold branch
        graph.addEdge(arnoldSchwarzenegger, jamesEarlJones);
        graph.addEdge(jamesEarlJones, arnoldSchwarzenegger);
        graph.addEdge(arnoldSchwarzenegger, lindaHamilton);
        graph.addEdge(lindaHamilton, arnoldSchwarzenegger);
        graph.addEdge(arnoldSchwarzenegger, dannyDeVito);
        graph.addEdge(dannyDeVito, arnoldSchwarzenegger);

        // Deepest chain
        graph.addEdge(jamesEarlJones, markHamill);
        graph.addEdge(markHamill, jamesEarlJones);
    }

    private static void runTraversals(Graph graph) {
        graph.DFS(chuckNorris);
        graph.BFS(chuckNorris);
    }

    private static void printConnections(Graph graph) {
        System.out.println("List of Connections:");
        graph.printConnectedNodesList();
    }
}