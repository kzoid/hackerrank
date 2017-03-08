package com.kzoid.hackerrank;

import java.util.Scanner;

/**
 * Created by Ricardo Gelschleiter on 08/02/2017.
 */
public class StockMaximize {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int testCaseSize = in.nextInt();
            int[] stockPrice = new int[testCaseSize];

            long profit = 0;

            for (int j = 0; j < testCaseSize; j++) {
                // test case prices
                stockPrice[j] = in.nextInt();
            }

            int currMax = Integer.MIN_VALUE;
            for (int j = testCaseSize - 1; j >= 0; j--) {
                if (currMax < stockPrice[j]) {
                    currMax = stockPrice[j];
                }
                profit += (currMax - stockPrice[j]);
            }

            System.out.println(profit);
        }
    }
}