package com.ndy.baidu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Class11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        long[] array = new long[2*n];
        for(int i=0;i<array.length;i++){
            array[i] = in.nextLong();
        }
        //System.out.println(1e11>Long.MAX_VALUE);
        Arrays.sort(array);


        BigInteger res = new BigInteger("0");
        if(p>50){
            for(int i=0;i<array.length;i++){
                if(i <array.length/2){

                    res = res.add(new BigInteger(String.valueOf((100-p)*array[i])));
                }else{
                    res= res.add(new BigInteger(String.valueOf(p*array[i])));

                }
            }
        }else{
            for(int i=0;i<array.length;i++){
                if(i % 2 == 0){
                    res= res.add(new BigInteger(String.valueOf((100-p)*array[i])));
                }else{
                    res= res.add(new BigInteger(String.valueOf(p*array[i])));
                }
            }
        }
        String result = res.toString();
        //System.out.println(result);
        if(result.charAt(result.length()-1) == '0' && result.charAt(result.length()-2) == '0'){
            System.out.println(res.divide(new BigInteger("100")).toString());
        }else{
            System.out.println(res.toString()+"%");
        }

    }
}
