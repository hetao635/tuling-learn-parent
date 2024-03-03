package com.atguigu.algorithm.sparsearray;

import java.io.*;

public class SparseArray {

    private static int[][] array = new int[11][12];
    public static void main(String[] args) {
        readFileArray("D:\\array.txt");
        print(array);
        int[][] sparseArray = createSparsArray(array);
        initSparseArray(sparseArray, array);
        writeArrayFile(sparseArray);
        print(sparseArray);
        int[][] twoArray = sparseArrayToArray(sparseArray);
        print(twoArray);
    }

    /**
     * 初始化原始数组
     * @param array
     */
    private static void initArray(int[][] array){
        array[1][2] = 1;
        array[2][3] = 2;
        array[1][3] = 1;
        array[1][4] = 2;
        System.out.println("数组初始化完成....");
    }

    /**
     * 数组打印
     * @param array
     */
    private static void print(int[][] array) {
        System.out.println("数组打印~");
        for(int[] row : array) {
            for (int data : row) {
                System.out.printf(data + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 初始化稀疏数组,
     * @param array
     */
    private static int[][] createSparsArray(int[][] array) {
        // 获取原始数组非零值数量
        int count = 0;
        for(int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }
        }
        int sparseArray[][] = new int[count + 1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = count;
        return sparseArray;
    }

    private static void initSparseArray(int[][] sparseArray, int[][] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
    }

    /**
     * 读取文件中的数据
     *
     * @param path
     * @return
     */
    private static int[][] readFileArray(String path){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            int cow = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\t");
                for (int i = 0; i < split.length; i++) {
                    array[cow][i] = Integer.parseInt(split[i]);
                }
                cow++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return array;
    }

    /**
     * 将数组写入文件
     * @param array
     */
    private static void writeArrayFile(int[][] array) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("D:\\sparseArray.txt"));
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    bufferedWriter.write(array[i][j] + "\t");
                }
                if (i < array.length - 1) {
                    bufferedWriter.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 将稀疏数组转换为二维数组
     * @param sparseArray
     * @return
     */
    private static int[][] sparseArrayToArray(int[][] sparseArray){
        // 创建一个二维数组
        int[][] twoArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 遍历稀疏数组给新生成的二维数组赋值
        for (int i = 1; i < sparseArray.length; i++) {
            twoArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return twoArray;
    }
}
