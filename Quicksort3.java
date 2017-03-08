package com.kzoid.hackerrank;

import java.util.Scanner;

/**
 * Created by Ricardo Gelschleiter on 09/02/2017.
 */
public class Quicksort3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arraySize = in.nextInt();
        int[] ar = new int[arraySize];

        for (int i = 0; i < ar.length; i++) {
            ar[i] = in.nextInt();
        }

        quickSort(ar);

        in.close();
    }

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
    }

    static void quickSort(int[] ar, int begin, int end) {
        if (end <= begin) {
            return;
        }

        int pivotIndex = partition(ar, begin, end);
        quickSort(ar, begin, pivotIndex - 1);
        quickSort(ar, pivotIndex + 1, end);
    }

    static int partition(int[] ar, int begin, int end) {
        int pivot = ar[end];
        int rightIndex = 0;
        for (int i = 0; i < end; i++) {
            if (ar[i] < pivot) {
                swap(ar, rightIndex, i);
                rightIndex++;
            }
        }
        swap(ar, rightIndex, end);

        print(ar);

        return rightIndex;
    }

    static void swap(int[] ar, int index1, int index2) {
        int temp = ar[index1];
        ar[index1] = ar[index2];
        ar[index2] = temp;
    }

    static void print(int[] ar) {
        for (int i : ar) {
            System.out.print(i);
            System.out.print(" ");
        }
        // break line
        System.out.println();
    }
}