import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Folder18 {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void addEdgeDirected(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void print(ArrayList<ArrayList<Integer>> adj, int v) {
        for (int i = 0; i < v; i++) {
            for (int x : adj.get(i)) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int v, int s, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (q.isEmpty() == false) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int x : adj.get(u)) {
                if (visited[x] == false) {
                    visited[x] = true;
                    q.add(x);
                }
            }

        }
    }

    public static void bfsDis(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v + 1];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {

                breadthFirstSearch(adj, v, i, visited);

                count++;
            }
        }
        System.out.println("No of islands " + count);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        boolean visited[] = new boolean[v + 1];
        int count = 0;
        for (int i = 0; i < v; i++) {

            if (visited[i] == false) {

                dfsrec(adj, i, visited);
                count++;
            }
        }
        System.out.println(count + " <-count");
    }

    public static void dfsrec(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]) {
        visited[s] = true;
        System.out.println(s + " ");
        for (int u : adj.get(s)) {
            if (visited[u] == false) {
                dfsrec(adj, u, visited);
            }
        }
    }

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        boolean visited[] = new boolean[v + 1];
        int distance[] = new int[v + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (q.isEmpty() == false) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int x : adj.get(u)) {
                if (visited[x] == false) {
                    distance[x] = (distance[u]) + 1;
                    visited[x] = true;
                    q.add(x);
                }
            }

        }
        return distance;
    }

    public static boolean DFSrec(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[], int parent) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (visited[u] == false) {
                if (DFSrec(adj, u, visited, s) == true) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                if (DFSrec(adj, i, visited, -1) == true) {

                    return true;
                }
            }

        }
        return false;
    }

    public static boolean DFSRECdirected(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[], boolean stack[]) {
        visited[s] = true;
        stack[s] = true;
        for (int u : adj.get(s)) {
            if (visited[u] == false) {
                if (DFSRECdirected(adj, u, visited, stack) == true) {
                    return true;
                }
            } else if (stack[u] == true) {
                return true;
            }
        }
        stack[s] = false;
        return false;
    }

    public static boolean DFSdirected(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v];
        boolean stack[] = new boolean[v];

        Arrays.fill(stack, false);
        Arrays.fill(visited, false);
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                if (DFSRECdirected(adj, i, visited, stack) == true) {

                    return true;
                }
            }

        }
        return false;
    }

    public static ArrayList<Integer> topologySort(ArrayList<ArrayList<Integer>> adj, int v) {
        int indegree[] = new int[v];
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < v; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            a.add(u);
            System.out.println(u);
            for (int i : adj.get(u)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return a;
    }

    public static boolean kahnsAlgo(ArrayList<ArrayList<Integer>> adj, int v) {
        int indegree[] = new int[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i : adj.get(u)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            count++;
        }
        System.out.println(count);
        return (count != v);
    }

    public static void DFStopological(ArrayList<ArrayList<Integer>> adj, int v) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                DFStopologicalSearch(adj, i, visited, s);
            }
        }

        while (s.empty() == false) {
            int ans = s.pop();
            System.out.println(ans);
        }
    }

    public static void DFStopologicalSearch(ArrayList<ArrayList<Integer>> adj, int i, boolean visited[],
            Stack<Integer> s) {
        visited[i] = true;
        for (int u : adj.get(i)) {
            if (visited[u] == false) {
                DFStopologicalSearch(adj, u, visited, s);
            }
        }
        s.push(i);
    }

    // public static int[] DAGshortestPath(ArrayList<ArrayList<Integer>>
    // adj,ArrayList<ArrayList<Integer>> b,int v){
    // int distance[]=new int[v];
    // Arrays.fill(distance, Integer.MAX_VALUE);
    // for(int u:b){
    // for(int x:adj.get(u)){
    // if (distance[x]>distance[u]+) {

    // }
    // }
    // }

    // return distance;
    // }

    public static int[] dijkstra(int graph[][], int src) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] fin = new boolean[V];
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            fin[u] = true;
            for (int v = 0; v < V; v++) {
                if (!fin[v] && graph[u][v] != 0) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }

        return dist;
    }

    public static void main(String args[]) {
        // int v = 6;
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        // for (int i = 0; i < v; i++) {
        // adj.add(new ArrayList<Integer>());
        // }

        // addEdge(adj, 0, 1);
        // addEdge(adj, 2, 1);
        // addEdge(adj, 3, 4);
        // addEdge(adj, 5, 6);
        // addEdge(adj, 7, 6);
        // addEdge(adj, 7, 5);

        // print adjacency list
        // print(adj, v);

        // print breadth first search,count of islands, bfs of disconnected graphs
        // bfsDis(adj, v);

        // dfs
        // dfs(adj, v, 0);

        // shortest path
        // int ans[] = shortestPath(adj, v, 0);
        // System.out.println();
        // for (int i : ans) {
        // System.out.println(i + "s");
        // }

        // cycle in undirected graph
        // boolean ans = DFS(adj, v);
        // System.out.println(ans);

        // cycle in directed graph

        // addEdgeDirected(adj, 0, 1);
        // addEdgeDirected(adj, 0, 4);
        // addEdgeDirected(adj, 1, 2);
        // addEdgeDirected(adj, 4, 2);
        // addEdgeDirected(adj, 2, 3);
        // addEdgeDirected(adj, 4, 5);
        // addEdgeDirected(adj, 5, 3);
        // print(adj, v);
        // boolean ans = DFSdirected(adj, v);
        // System.out.println(ans);

        // topology sort in directed graph
        ArrayList<Integer> b = topologySort(adj, v);
        // cycle detection using kahns algo
        // boolean ans=kahnsAlgo(adj, v);
        // System.out.println(ans);

        // topological sort using DFS
        // DFStopological(adj, v);

        // shortest path in DAG(directed acyclic graph)
        // DAGshortestPath(adj,b,v); had to create weighted graph so didnt complete it
        // yet, will do in revision
        // same for prims algo

        // dijkstra Algo
        // fix a source node and a destination node
        // from start node keep taking node with smallest weight till now, and then
        // check weight for the remaining non fixed nodes
        // it doesnt work for negative weights
        // if after finding shortest path weights are altered by fixed no shortest path
        // may change, because of the difference in no of nodes.
        // however multiplying doesnt change the shortest path.
        //kosaraju's algorithm to find the strongly connected graph parts.
        // --step 1-find the topological sort,(take the graph start traversing recursively, the moment there are no non visited nodes, put that node in stack and return to its parent, so on...)
        // --step 2-- reverse all the edges.
        //now from the stack take every top element and print all the adjacent nodes they form the first cluster, now take the next node which is non visited find all its adjacent non visited nodes, they form the next and so on.. 
    }

}

















//bfs --reach a vertex in shortest no. of edges (V+E)
// topological sort -- directed and acyclic  (V+E)
//djkistra's  algorithm --directed/undirected cyclic acyclic
//bellman fords algorithm --negatiev edges

//articulation points- removing of which node would result in increase of no of connected components more than 1. Useful to check for vulnerable points in the network. vulnerable nodes are found and then edges are joined with them to mmake them secure.
