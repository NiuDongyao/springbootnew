package com.ndy.meituan;

import java.util.Scanner;

public class Class3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }

        for(int i=0;i<m;i++){
            int x = in.nextInt();
            int left = 0;
            int right = array.length-1;

            while(left<=right){
                if(array[left] == x){
                    break;
                }
                left++;
            }
            if(left == array.length){
                System.out.println(0);
                continue;
            }
            while(right>=left){
                if(array[right] == x){
                    break;
                }
                right--;
            }
            System.out.println(++left);
            System.out.println(++right);
        }
    }
}
