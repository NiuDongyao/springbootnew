package com.ndy.meituan;

import java.util.Scanner;

public class Class4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }
        int max = 0;
        for(int i = 0; i<array.length;i++){
            int cur = array[i];
            if(cur > max) max = cur;
            for(int j =i+1;j<i+k;j++) {
                if (j > array.length - 1) break;
                cur = cur ^ array[j];
                if (cur > max) max = cur;
            }
        }
        System.out.println(max);
    }
}
