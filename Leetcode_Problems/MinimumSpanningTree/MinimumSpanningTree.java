package Leetcode_Problems.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MinimumSpanningTree {
    int V;
    public int minKey(int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                               + graph[i][parent[i]]);
    }

    public void primMST(int graph[][], int n)
    {
        V = n;
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0; 
        parent[0] = -1; 
        for (int count = 0; count <= V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false
                    && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }


    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] graph;
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n][n];
        int k = m;
        while(k-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u-1][v-1] = w;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        MinimumSpanningTree mst = new MinimumSpanningTree();
        mst.primMST(graph, n);
        }
    }


