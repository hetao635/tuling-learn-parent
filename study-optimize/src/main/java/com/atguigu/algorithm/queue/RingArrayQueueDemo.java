package com.atguigu.algorithm.queue;

public class RingArrayQueueDemo {

    public static void main(String[] args) {

    }
}

class RingArrayQueue{
    private int maxSize; // 最大长度
    private int front; // 头
    private int rear; // 尾
    private int[] arr; // 存放队列的数组

    public RingArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return front == rear;
    }

}
