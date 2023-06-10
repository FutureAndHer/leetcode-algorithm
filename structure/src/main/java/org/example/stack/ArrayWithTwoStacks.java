package org.example.stack;

import java.util.EmptyStackException;

/**
 * 一个数组实现两个栈
 *
 * @className: ArrayWithTwoStacks
 * @author: Max Solider
 * @date: 2023-06-09 07:42
 */
public class ArrayWithTwoStacks {

    private Integer[] dataArray;

    private int topOne;

    private int topTwo;

    private int size;

    public ArrayWithTwoStacks(int size) {
        if (size < 2) {
            throw new IllegalStateException("size < 2 is no persmissible");
        }
        dataArray = new Integer[size];
        this.size = size;
        topOne = -1;
        topTwo = size;
    }

    public void push(int stackId, int data) {
        if (topOne + 1 == topTwo) {
            throw new StackOverflowError("Array is full");
        }
        if (stackId == 1) {
            dataArray[++topOne] = data;
        } else if (stackId == 2){
            dataArray[++topTwo] = data;
        }
        return;
    }

    public Integer pop(int stackId) {
        if (stackId == 1) {
            if (topOne == -1) {
                throw new EmptyStackException();
            }
            int data = dataArray[topOne];
            dataArray[topOne--] = null;
            return data;
        } else if (stackId == 2) {
            if (topTwo == size) {
                throw new EmptyStackException();
            }
            int data = dataArray[topTwo];
            dataArray[topTwo++] = null;
            return data;
        }
        return null;
    }

}