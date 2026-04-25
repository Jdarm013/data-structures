# Data Structures & Algorithms

A collection of Java projects built while studying data structures and algorithms. Each project applies a specific structure to a domain that makes its behavior concrete — a music player for circular iteration, a spell checker for comparing collection performance, a social graph for tree traversal. The goal throughout was to understand *why* each structure exists, not just how to use it.

---

## Projects

### Circular Linked List — Artists Showcase

**`CircularListArtists/`** — A JavaFX application applying a circular linked list to a browsable showcase of classic rock bands (Beatles, Zeppelin, Pink Floyd, Queen, etc.), each with an image, formation year, iconic album, and chart hits. Implements a `CircularLinkedList` with a direction-tracking `CircularIterator` that handles seamless switching between forward and backward traversal without skipping or repeating elements. Includes a "Go to Index" field that accepts any integer, normalizes it, and repositions the iterator accordingly.

**Key concept:** Circular iteration, `ListIterator` implementation, direction-aware cursor management.

---

### Spell Checker — Collection Performance Benchmark

**`SpellCheckerTest/`** — Loads the full text of *War and Peace* and a standard English dictionary, then runs a spell check using four different collection types back to back, timing each one with a hand-rolled `StopWatch` class. The four passes — `ArrayList`, `HashSet`, `LinkedHashSet`, and `TreeSet` — demonstrate the real-world performance gap between O(n) linear search and O(1) average lookup at scale.

**Key concept:** Big-O complexity in practice, tradeoffs between collection types, file I/O, benchmark design.

---

### Graph — Actor Connections

**`GraphFriends/`** — Builds a directed graph of action movie actors using an adjacency list, then runs both Depth-First Search (DFS) and Breadth-First Search (BFS) from a root node. DFS is implemented with an explicit `Stack` rather than recursion. BFS uses a `Queue`. Both use a `HashSet` to track visited nodes. A separate `AdjacencyMatrix` class implements the same graph using a 2D boolean array, demonstrating the space/lookup tradeoff between the two representations.

**Key concept:** Graph traversal, DFS vs BFS, adjacency list vs adjacency matrix.

---

### Stack Exercises

**`Stack Exercises/`** — Two programs demonstrating stack behavior. `SentenceReverser` reverses multi-sentence text word by word using a `Stack<String>`. `IntegerReverser` takes a user-entered integer, extracts digits using modulo arithmetic, and reverses them using a stack.

**Key concept:** Stack as a reversal mechanism, LIFO behavior.

---

### Heap Exercises

**`Heap Exercises/`** — Three exercises exploring `PriorityQueue` behavior. Min and max heaps of integers and strings, custom comparators, and heap sort via repeated polling.

**Key concept:** Heap structure, min vs max ordering, custom comparators.

---

### Recursion Lab

**`Recursion/`** — An interactive console program c
