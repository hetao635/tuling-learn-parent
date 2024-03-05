package com.atguigu.algorithm.queue;

import java.util.Scanner;

public class RingArrayQueueDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入队列的方法");
        RingArrayQueue arrayQueue = new RingArrayQueue(5);
        boolean loop = true;
        while (loop) {
            System.out.println("isEmpty：判断当前队列是否为空");
            System.out.println("isFull：判断当前队列是否已满");
            System.out.println("add：向队列中添加元素");
            System.out.println("remove：移除队列的元素");
            System.out.println("show:显示头部元素");
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

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int number) {
        if (isFull()) {
            System.out.println("环形队列已满，无法添加");
            return;
        }
        arr[rear] = number;
        rear = (rear + 1) % maxSize;
    }


    public void removeQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法删除元素！");
            return;
        }
        arr[front] = 0;
        front = (front + 1) % maxSize;
    }

    public void showHeadQueue() {
        System.out.println(rear);
        System.out.println(front);
        System.out.println(arr[rear-1]);
    }

    public int number() {
        return (rear + maxSize - front) % maxSize;
    }
}
