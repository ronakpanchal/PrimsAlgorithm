package com.algorithms.projects;

/**
 * Created by ronak on 10/1/2016.
 */
public class Edge implements Comparable<Edge> {

    private int v;
    private int w;
    private int weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        if(this.getWeight()>o.getWeight()){
            return 1;
        }else if(this.getWeight()<o.getWeight()){
            return -1;
        }else{
            return 0;
        }
    }
}
