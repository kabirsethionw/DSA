import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();
    public void addNewVertex(T s){
        map.put(s, new LinkedList<T>());
    }
    public void addNewEdge(T src, T dest, boolean bidirectional){
        if(!map.containsKey(src))
            addNewVertex(src);
        if(!map.containsKey(dest))
            addNewVertex(dest);
        map.get(src).add(dest);
        if(bidirectional)
            map.get(dest).add(src);
    }

    public int countVertices(){
        return map.keySet().size();
    }

    public int countEdges(boolean bidirectional){
        int count = 0;
        for(T v: map.keySet()){
            count += map.get(v).size();
        }
        if(bidirectional){
            count /= 2;
        }
        return count;
    }

    public List<T> getAdjacentList(T src){
        return map.get(src);
    }

    public boolean containsVertex(T src){
        return map.containsKey(src);
    }

    public boolean containsEdge(T src, T dest){
        return map.get(src).contains(dest);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        //foreach loop that iterates over the keys
        for (T v : map.keySet())
        {
            builder.append(v.toString() + ": ");
            //foreach loop for getting the vertices
            for (T w : map.get(v))
            {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

    public List<T> getAllVertices(){
        return map.keySet().stream().toList();
    }
}
