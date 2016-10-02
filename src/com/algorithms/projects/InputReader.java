package com.algorithms.projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ronak on 10/1/2016.
 */
public class InputReader {

    public static void main(String[] args){
        BufferedReader br;
        String[] params;
        int n;
        int m=0;
        int counter=0;
        PrimsAlgorithm obj=null;
        String currentLine;
        Graph graph=null;
        try {
            File file=new File("B:\\Softwares\\CSE531\\P1_Public_Cases\\test6.txt");
            //System.out.print(file.exists());
            br=new BufferedReader(new FileReader(file));

            while((currentLine=br.readLine())!=null){
                if(counter==0){
                    params=currentLine.split(" ");
                    n=Integer.parseInt(params[0]);
                    m=Integer.parseInt(params[1]);
                    graph=new Graph(n,m);
                }else{
                    params=currentLine.split(" ");
                    if(params.length==1){
                        break;
                    }
                    int u=Integer.parseInt(params[0]);
                    int v=Integer.parseInt(params[1]);
                    int weight=Integer.parseInt(params[2]);
                    graph.addEdge(u,v,weight);
                }
                counter++;
            }
            obj=new PrimsAlgorithm(m);
            obj.getMinimumSpanningTree(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
