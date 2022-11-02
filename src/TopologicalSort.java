import java.util.*;

public class TopologicalSort<T> {
    private List<T> vertices;
    private Stack<T> stack;
    private Set<T> set;

    public List<T> sort(Graph graph){
        this.vertices = graph.getAllVertices();
        this.stack = new Stack<>();
        this.set = new HashSet<>();

        for(T vertex: vertices){
            sortHelper(graph, vertex);
        }

        return stack.stream().toList();
    }

    private void sortHelper(Graph<T> graph,T vertex){
        if(!set.contains(vertex)){
            set.add(vertex);
            for(Object dest: graph.getAdjacentList(vertex)){
                sortHelper(graph, (T)dest);
            }
            stack.add(vertex);
        }
    }
    
}
