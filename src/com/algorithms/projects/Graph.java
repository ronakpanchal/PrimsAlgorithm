package com.algorithms.projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ronak on 10/1/2016.
 */
@SuppressWarnings("Duplicates")
public class Graph {

    private int vertices;
    private int edges;
    private HashMap<Integer,List<Edge>> adjacencyList;


    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        adjacencyList=new HashMap<Integer,List<Edge>>();
    }

    public void addEdge(int u,int v,int weight){
        if(adjacencyList.get(u)!=null){
            adjacencyList.get(u).add(new Edge(u,v,weight));
        }else{
            List<Edge> neighbours=new ArrayList<Edge>();
            neighbours.add(new Edge(u,v,weight));
            adjacencyList.put(u,neighbours);
        }
        if(adjacencyList.get(v)!=null){
            adjacencyList.get(v).add(new Edge(v,u,weight));
        }else{
            List<Edge> neighbours=new ArrayList<Edge>();
            neighbours.add(new Edge(v,u,weight));
            adjacencyList.put(v,neighbours);
        }
    }

    public List<Edge> getEdges(int vertex){
        return adjacencyList.get(vertex);
    }
    public List<Integer> getVertices(){
        List<Integer> vertices=new ArrayList<>();
        Iterator<Integer> itr=adjacencyList.keySet().iterator();
        while(itr.hasNext()){
            vertices.add(itr.next());
        }
        return vertices;
    }


}
