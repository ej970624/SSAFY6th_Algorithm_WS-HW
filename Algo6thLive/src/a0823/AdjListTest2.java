package a0823;

import java.util.*;
import java.io.*;

public class AdjListTest2 {
    static int N; // 정점 개수
    static List<Integer>[] adjList; // 인접리스트  (가중치 없음) 
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adjList = new ArrayList[N];
        for(int i=0; i<N; i++) {
            adjList[i]=new ArrayList<Integer>();
        }
        int C = Integer.parseInt(in.readLine()); // 간선 개수
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        System.out.println("=============bfs==================");
        bfs();
        System.out.println("=============dfs==================");
        boolean[] visited = new boolean[N];
        dfs(0,visited);
    }
    
    static void bfs() {        
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N];
        
        visited[0] = true;        
        queue.offer(0);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char)(current+'A'));
            for(int next : adjList[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
    
    static void dfs(int current,boolean[] visited) { //        
        visited[current] = true;
        System.out.println((char)(current+'A'));        
        for(int next : adjList[current]) {
            if(!visited[next]) {
                dfs(next, visited);
            }
        }
    }
}