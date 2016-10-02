package com.algorithms.projects;

/**
 * Created by ronak on 10/2/2016.
 */
public class Heap {

    int capacity;
    Edge[] array;
    int size;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.array = new Edge[this.capacity];
        this.size = 0;
    }

    public void add(Edge e) {
        array[size++] = e;
        heapify();
    }

    private void heapify() {
        int i = size - 1;
        int parent = (i - 1) / 2;
        while (parent >= 0 && array[parent].compareTo(array[i]) > 0) {
            swap(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        Edge temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Edge peek() {
        return array[0];
    }

    public Edge poll() {
        Edge min = array[0];
        remove(0);
        return min;
    }

    public void remove(int index) {
        if (size == 0) {
            return;
        }
        Edge last_element = array[size-1];
        size--;
        array[index]=last_element;

        int left_index = (2 * index) + 1;
        int right_index = (2 * index) + 2;


        while (left_index < size-1) {
            if (array[index].compareTo(array[left_index]) < 0 && array[index].compareTo(array[right_index]) < 0) {
                return;
            }else{
                if(left_index+1<size){
                    if(array[left_index].compareTo(array[right_index]) < 0){
                        swap(left_index,index);
                        index=left_index;
                    }else{
                        swap(right_index,index);
                        index=right_index;
                    }
                    left_index=(2*index)+1;
                    right_index=(2*index)+2;
                }
            }
        }
    }

}
