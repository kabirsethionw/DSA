package JavaFiddle;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {
    public static int INF = 9999999;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int counter = 0;
        for(List<String> eqn: equations){
            if(map.get(eqn.get(0)) == null){
                map.put(eqn.get(0), counter++);
            }
            if(map.get(eqn.get(1)) == null) {
                map.put(eqn.get(1), counter++);
            }
        }
        double mat[][] = new EvaluateDivision().customfloydWarshall(map.size(), equations, values, map);
        double res[] = new double[queries.size()];
        int count = 0;
        for(List<String> q: queries){
            int x = map.get(q.get(0)) == null ? -1 : map.get(q.get(0));
            int y = map.get(q.get(1)) == null ? -1 : map.get(q.get(1));
            if(q.get(0) == q.get(1))  res[count++] = 1.00;
            else if(x == -1 || y == -1) res[count++] = -1.00;
            else{
                res[count++] = mat[x][y] == INF  ? -1.00 : formatDecimal(mat[x][y]);
            }
        }
        return res;
    }

    private double[][] customfloydWarshall(int n, List<List<String>> equations, double[] values, HashMap<String, Integer> map)
    {
        double dist[][] = new double[n][n];
        int i, j, k;

        for (i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);

        for (i = 0; i < equations.size(); i++){
            dist[map.get(equations.get(i).get(0))][map.get(equations.get(i).get(1))] = values[i];
            dist[map.get(equations.get(i).get(1))][map.get(equations.get(i).get(0))] = 1/values[i];
        }


        for (k = 0; k < n; k++)
        {
            for (i = 0; i < n; i++)
            {
                for (j = 0; j < n; j++)
                {
                    boolean con = dist[i][k] != INF|| dist[k][j] != INF;
                    if (con && dist[i][k] * dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] * dist[k][j];
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        String eqns[][] = {{"a","b"},{"b","c"}};
        double testValues[] = {2.0,3.0};
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(eqns[0]));
        equations.add(Arrays.asList(eqns[1]));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        List<List<String>> queries = new ArrayList<>();
        String q[][] = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        for (String query[]: q){
            List<String> tempQ = new ArrayList<>();
            tempQ.add(query[0]);
            tempQ.add(query[1]);
            queries.add(tempQ);
        }
        new EvaluateDivision().calcEquation(equations, testValues, queries);
    }

    private static double formatDecimal(double val){
        val = val*100000;
        val = Math.round(val);
        val = val /100000;
        return val;
    }
}
