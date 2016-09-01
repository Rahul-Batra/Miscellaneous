/*
 * Travel Information Center 
 * Rahul Batra
 * 
 */
import java.util.Scanner;

public class Main {
	int minimumDistance(int dist[],Boolean set[],int n) {
		int min = Integer.MAX_VALUE, minindex=-1;
		for(int v=0; v<n;v++) {
			if(set[v]==false && dist[v]<=min) {
				min = dist[v];
				minindex = v;
			}
		}
		return minindex;
	}
	int[] dijkstra(int graph[][], int src, int n, int spath[]) {
		int dist[] = new int[n];
		Boolean set[] = new Boolean[n];
		for(int i=0;i<n;i++) {
			dist[i]=Integer.MAX_VALUE;
			set[i]=false;
		}
		dist[src]=0;
		spath[src]=0;
		for(int count=0; count < n-1; count++) {
			int u = minimumDistance(dist,set,n);
			set[u]=true;
			for(int v=0;v<n;v++) {
				if(!set[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
					dist[v]=dist[u]+graph[u][v];
					if(src == 0)
						spath[v]=dist[v];
					else if(spath[v]>dist[v])
						spath[v]=dist[v];
				}
			}
		}
		return spath;
	}
	
	public static void main(String[] args) {
		Scanner in = null;
		try {
		    in = new Scanner(System.in);
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] graph = new int[n][n];
			for(int k=n-1;k>0;k--) {
				int i = in.nextInt();
				int j = in.nextInt();
				graph[i-1][j-1] = 1;
			}
			Main highwayCitiesProblem = new Main();
			int[] shortestpath = new int[n];
			shortestpath=highwayCitiesProblem.dijkstra(graph, 0, n, shortestpath);
			for(int k=0;k<m;k++) {
				int i = in.nextInt();
				int j = in.nextInt();
				if(i==2)
					System.out.println(shortestpath[j-1]);
				else if(i==1 && j==1) continue;
				else
					shortestpath=highwayCitiesProblem.dijkstra(graph, j-1, n,shortestpath);
			}
		}
		finally {
		    if(in!=null)
		        in.close();
		}
	}
}
