package com.atguigu.algorithm.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}

class ArrayQueue{
    private int maxSize;
    private int front; // 头
    private int rear; // 尾
    private int[] arr; // 存放队列的数组

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断数组队列是否为空
     * @return
     */
    private boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断数值中队列是否已满
     * @return
     */
    private boolean isFull(){
        return front + 1 == maxSize;
    }

    /**
     * 添加队列
     * @param number
     */
    private void addQueue(int number){
        if (isFull()) {
            System.out.println("数组队列已满，无法添加...");
            return;
        }
        front++;
        arr[front] = number;
    }

    /**
     * 移除队列
     */
    private void removeQueue(){
        if (isEmpty()) {
            System.out.println("数组队列为空，无法移除元素");
            return;
        }
        rear++;
        arr[rear] = 0;
    }

    private int showHeadQueue(){
        if (isEmpty()) {
            System.out.println("队列为空，无法显示头部数值!");
            return 0;
        }
        return arr[front];
    }
}
