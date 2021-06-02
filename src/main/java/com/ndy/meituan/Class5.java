package com.ndy.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }

        int count = 0;

        int choose = 0;
        List<Integer> list = new ArrayList<>();
        for(;choose<n;choose++){
            int jishuSum = 0;
            int oushuSum = 0;
            int i=0;
            while(i<choose){
                if(i%2 == 0){
                    jishuSum += height[i];
                }else{
                    oushuSum += height[i];
                }
                i++;
            }
            i++;
            while(i<n){
                if(i%2 == 0) oushuSum+=height[i];
                else jishuSum += height[i];
                i++;
            }
            if(jishuSum == oushuSum){
                count++;
                list.add(choose+1);
            }
        }
        System.out.println(count);
        StringBuffer sb = new StringBuffer();
        for(Integer i : list){
            sb.append(i);
            sb.append(" ");
        }
        String trim = sb.toString().trim();
        System.out.println(trim);

    }
}
