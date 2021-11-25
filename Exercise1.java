package com.active.edge.stock.api.activedge;

import java.util.Arrays;

public class Exercise1 {


    public static void main(String[] args) {
        int[] smallestIntArray = {1,6,2,4,7,9};
        System.out.println(solution(smallestIntArray));

    }


    public static int solution(int[] arr){
        int smallestInit = 1;

        if(arr.length ==0)
            return smallestInit;
        Arrays.sort(arr);
        if(arr[0] > 1 ) {
            return smallestInit;
        }
        if(arr[arr.length-1] <= 0 ) {
            return smallestInit;
        }

        for (int i=0; i<arr.length; i++){
            if(arr[i]==smallestInit){
                smallestInit++;
            }
        }
        return smallestInit;
    }


}
