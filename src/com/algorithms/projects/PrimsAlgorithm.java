package com.algorithms.projects;

import java.util.*;

/**
 * Created by ronak on 10/1/2016.
 */
public class PrimsAlgorithm {

    private Set<Integer> graphVertices;
    private Set<Edge> treeEdges;
    private Heap queue;

    public PrimsAlgorithm(int m) {
        graphVertices =new HashSet<Integer>();
        treeEdges=new LinkedHashSet<Edge>();
        queue=new Heap(m);
    }

    public void getMinimumSpanningTree(Graph graph){
        int totalWeight=0;
        List<Integer> vertices=graph.getVertices();
        int source=vertices.get(0);
        List<Edge> edges=graph.getEdges(source);
        this.graphVertices.add(source);
        for(Edge edge:edges){
            if(!this.graphVertices.contains(edge.getW())){
                queue.add(edge);
            }
        }
        while(this.graphVertices.size()<vertices.size()){

            Edge edge=queue.poll();
            int v=edge.getW();
            int u=edge.getV();
            if(!graphVertices.contains(v)){
                totalWeight+=edge.getWeight();
                treeEdges.add(edge);
                graphVertices.add(v);
                List<Edge> list=graph.getEdges(v);
                if(list!=null){
                    for(Edge e:list){
                        if(!this.graphVertices.contains(e.getW())){
                            queue.add(e);
                        }
                    }
                }
            }
        }
        Iterator<Edge> itr=this.treeEdges.iterator();
        System.out.println(totalWeight);
        while(itr.hasNext()){
            Edge e=itr.next();
            int v=e.getV();
            int w=e.getW();
            int weight=e.getWeight();
            System.out.println(v+" "+w+" "+weight);
        }

    }
}
