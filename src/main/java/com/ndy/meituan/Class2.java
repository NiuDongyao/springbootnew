package com.ndy.meituan;

import java.math.BigInteger;
import java.util.Scanner;

public class Class2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        String str = in.next();
        Integer use = 0;
        if(c1<=c2) use = c1;
        else use = c2;
        int startindex = -1;
        int lastTureindex = 0;
        int count = 0;
        int num = 1000000000;
        int sxz = 1000000000;

        System.out.println(num);
        System.out.println(Integer.MAX_VALUE);
        char[] chars = str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(chars[i] == 'F'){
                count++;
            }else {
                num += count/3;
                count = 0;
            }
        }
        num+=count/3;

        BigInteger numm = new BigInteger(String.valueOf(num));
        System.out.println(numm);
        BigInteger usee = new BigInteger(String.valueOf(use));
        BigInteger multiply = usee.multiply(numm);
        System.out.println(usee);
        //total = num * use;
        System.out.println( multiply);
    }
}
