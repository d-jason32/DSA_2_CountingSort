package edu.farmingdale;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,1,2,3,1};

        System.out.println("Unsorted");
        showArray(arr);

        int[] sorted = countingsort(arr, 3);

        System.out.println("sorted");
        showArray(sorted);

        int[] randomArray = new int[1000];
        int highest = 0;

        // Generate Random Data
        for (int i = 0; i < randomArray.length; i++) {
            Random rand = new Random();
            int randNum;
            randNum = rand.nextInt(500);

            randomArray[i] = randNum;

            if (randNum > highest) {highest = randNum;}
        }

        System.out.println("Unsorted");
        showArray(randomArray);

        randomArray = countingsort(randomArray, highest);

        System.out.println("Sorted");
        showArray(randomArray);



    }

    public static void showArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ",a[i]);
        }
        System.out.println();
    }

    public static int[] countingsort(int[] in, int k){
        int[] countArray = new int[k+1];
        int[] outArray = new int[in.length];

        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = 0;
        }

        for (int i = 0; i < in.length; i++) {
            int currItem = in[i];
            countArray[currItem] = countArray[currItem] + 1;
        }

        for (int i = 1; i <= k; i++) {
            countArray[i] = countArray[i] + countArray[i-1];
        }

        for (int i = in.length-1; i >= 0; i--) {
            int currItem = in[i];
            countArray[currItem] = countArray[currItem] - 1;
            outArray[countArray[currItem]] = currItem;
        }

        return outArray;
    }
}