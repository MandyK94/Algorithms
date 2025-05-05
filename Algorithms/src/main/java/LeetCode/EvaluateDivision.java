package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		
		
		Map<String, Map<String, Double>> graph = new HashMap<String, Map<String, Double>>();
		
		for(int i = 0;i<equations.size();i++) {
			String var1 = equations.get(i).get(0);
			String var2 = equations.get(i).get(1);
			double val = values[i];
			
			graph.putIfAbsent(var1, new HashMap<String, Double>());
			graph.get(var1).put(var2, val);
			graph.putIfAbsent(var2, new HashMap<String, Double>());
			graph.get(var2).put(var1, 1/val);
		}
		
		
		double[] res = new double[queries.size()];
		for(int i=0;i<queries.size();i++) {
			String num = queries.get(i).get(0);
			String den = queries.get(i).get(1);
			res[i] = dfs(graph, num, den, new HashSet<String>());
		}
		
		return res;
		
	}
	
	private static double dfs(Map<String, Map<String, Double>> graph, String num, String den, Set<String> visited) {
		
		if(!graph.containsKey(num) || !graph.containsKey(den)) {
			return -1.0;
		}
		
		if(visited.contains(num)) {
			return -1.0;
		}
		
		if(num.equals(den)) {
			return 1.0;
		}
		
		if(graph.get(num).containsKey(den)) {
			return graph.get(num).get(den);
		}
		visited.add(num);
		for(Map.Entry<String, Double> neighbour: graph.get(num).entrySet()) {
			double res = dfs(graph, neighbour.getKey(), den, visited);
			if(res!=-1.0) {
				return res*neighbour.getValue();
			}
		}
		return -1.0;
	}
	
	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<List<String>>();
		// Add variables to equation
		List<String> eq1 = new ArrayList<String>();
		Collections.addAll(eq1, "x1", "x2");
		List<String> eq2 = new ArrayList<String>();
		Collections.addAll(eq2, "x2", "x3");
		List<String> eq3 = new ArrayList<String>();
		Collections.addAll(eq3, "x3", "x4");
		List<String> eq4 = new ArrayList<String>();
		Collections.addAll(eq4, "x4", "x5");
		// Add equations to main to list
		Collections.addAll(equations, eq1, eq2, eq3, eq4);
		
		
		double[] values =  {3.0, 4.0, 5.0, 6.0};
		
		List<List<String>> queries = new ArrayList<List<String>>();
		List<String> q1 = new ArrayList<String>();
		Collections.addAll(q1, "x1", "x5");
		List<String> q2 = new ArrayList<String>();
		Collections.addAll(q2, "x5", "x2");
		List<String> q3 = new ArrayList<String>();
		Collections.addAll(q3, "x2", "x4");
		List<String> q4 = new ArrayList<String>();
		Collections.addAll(q4, "x2", "x2");
		List<String> q5 = new ArrayList<String>();
		Collections.addAll(q5, "x2", "x9");
		List<String> q6 = new ArrayList<String>();
		Collections.addAll(q6, "x9", "x9");
		Collections.addAll(queries, q1, q2, q3, q4, q5, q6);
		
		double[] res = calcEquation(equations, values, queries);
		for(double r:res) {
			System.out.println(r + " ");
		}
	}
}
