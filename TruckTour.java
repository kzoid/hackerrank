package com.kzoid.hackerrank;

import java.util.Scanner;

/**
 * Created by Ricardo Gelschleiter on 09/02/2017.
 */
public class TruckTour {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pumpsSize = in.nextInt();
        int[][] ar = new int[pumpsSize][2];

        // read values
        for (int i = 0; i < ar.length; i++) {
            ar[i][0] = in.nextInt(); //amount of petrol
            ar[i][1] = in.nextInt(); //distance to the next petrol pump
        }

        for (int i = 0; i < ar.length; i++) {
            if (completeCircle(i, ar)) {
                System.out.println(i);
                break;
            }
        }

        in.close();
    }

    private static boolean completeCircle(int start, int[][] ar) {
        int currPetrol = 0;
        for (int i = start; i < ar.length; i++) {
            currPetrol = currPetrol + (ar[i][0] - ar[i][1]);
            //System.out.println("\tPetrol: " + ar[i][0] + " - " + ar[i][1] + " = " + currPetrol);
            if (currPetrol <= 0) return false; // check petrol
        }

        // rest of circle
        for (int i = 0; i < start; i++) {
            currPetrol = currPetrol + (ar[i][0] - ar[i][1]);
            //System.out.println("\tPetrol: " + ar[i][0] + " - " + ar[i][1] + " = " + currPetrol);
            if (currPetrol <= 0) return false; // check petrol
        }

        return Boolean.TRUE;
    }
}
