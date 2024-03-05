package com.atguigu.algorithm.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入队列的方法");
        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean loop = true;
        while (loop) {
            System.out.println("isEmpty：判断当前队列是否为空");
            System.out.println("isFull：判断当前队列是否已满");
            System.out.println("add：向队列中添加元素");
            System.out.println("remove：移除队列的元素");
            System.out.println("show:显示头部元");
            String value = scanner.nextLine();
            switch (value) {
                case "isEmpty":
                    System.out.println("当前数组队列是否为空?" + arrayQueue.isEmpty());
                    break;
                case "isFull":
                    System.out.println("当前数组队列是否已满?" + arrayQueue.isFull());
                    break;
                case "add":
                    System.out.println("请输入需要添加的元素");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case "remove":
                    arrayQueue.removeQueue();
                    break;
                case "show":
                    arrayQueue.showHeadQueue();
                    break;
                case "exit":
                    System.out.println("退出当前队列操作!");
                    loop = false;
                    break;
                default: break;
            }
            System.out.println("队列元素个数为:" + arrayQueue.number());
        }
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
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断数值中队列是否已满
     * @return
     */
    public boolean isFull(){
        return front + 1 == maxSize;
    }

    /**
     * 添加队列
     * @param number
     */
    public void addQueue(int number){
        if (isFull()) {
            System.out.println("数组队列已满，无法添加...");
            return;
        }
        rear++;
        arr[rear] = number;
    }

    /**
     * 移除队列
     */
    public void removeQueue(){
        if (isEmpty()) {
            System.out.println("数组队列为空，无法移除元素");
            return;
        }
        front++;
        arr[front] = 0;
    }

    public int showHeadQueue(){
        if (isEmpty()) {
            System.out.println("队列为空，无法显示头部数值!");
            return 0;
        }
        return arr[front +1];
    }

    public int number(){
        return front - rear;
    }
}
