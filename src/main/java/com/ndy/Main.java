package com.ndy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    static int count = 0;
    static int depth;

    private static String bigNumAdd(String number1, String number2) {



        int maxLength, minLength;
        int flag = 0;//进位标志
        StringBuilder temp = new StringBuilder();
        maxLength = number1.length() > number2.length() ? number1.length() : number2.length();
        minLength = number1.length() < number2.length() ? number1.length() : number2.length();
        String result = "";//结果集
        //先把2个不同长度的字符串补齐0，短的那一边前面补齐0,例如，1234,0012.
        for (int i = 0; i < maxLength - minLength; i++) {
            temp.append("0");
        }
        if (minLength == number1.length()) {
            number1 = temp + number1;
        } else number2 = temp + number2;

        for (int i = maxLength-1; i >=0; i--) {
            int tempA =Integer.parseInt(String.valueOf(number1.charAt(i)));
            int tempB = Integer.parseInt(String.valueOf(number2.charAt(i)));
            int tempI = 0;
            if (tempA + tempB + flag >= 10) {
                tempI = tempA + tempB - 10 + flag;
                flag = 0;
                flag++;
            } else {
                tempI = tempA + tempB + flag;
                flag = 0;
            }
            result = tempI + result;
        }
        if (flag == 1)
            result = flag + result;
        return result;
    }
    public static void main(String[] args) {

        //BufferedReader br = new BufferedReader(new FileReader());

        //System.out.println(bigNumAdd("9449", "558"));

        /*
        Scanner in = new Scanner(System.in);
          String str = in.next();
          char[] chars = str.toCharArray();
          int maxcount = 0;
          int curcount = 0;
          int index = 0;
          int curindex = 0;
          for(int i=0; i<chars.length; i++){
              if (chars[i] < '0' && chars[i] > '9' && (chars[i] != '+' || chars[i] != '-' || chars[i] != '.')) {
                  curcount = 0;
                  continue;
              }else if(chars[i] >= '0' && chars[i] <= '9'){
                  if(i != 0 && chars[i-1] < '0' && chars[i-1] > '9' && (chars[i-1] != '+' || chars[i-1] != '-')){
                      curindex = i;
                  }
                  curcount++;
              }else if(chars[i] == '+' || chars[i] == '-'){
                  curcount = 1;
                  curindex = i;
                  continue;
              }else if(chars[i] == '.'){
                  if(i!=0 && chars[i-1] <'0' && chars[i-1] > '9'){
                      curcount = 0;
                      continue;
                  }
                  for(int j=curindex;j< i; j++){

                  }
//                  if(preDotindex != 0){
//                      i = preDotindex + 1;
//                  }
                  curcount++;
                  //preDotindex = i;
              }

              if(curcount >= maxcount){
                  maxcount = curcount;
                  index = i - maxcount;
              }
          }
          StringBuffer sb = new StringBuffer();
          for(int i=index; i<maxcount;i++){
                sb.append(chars[i]);
          }
          System.out.println(sb.toString());
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        for(int i=0;i<T;i++){
//            int n = in.nextInt();
//            depth = n;
//            int m = in.nextInt();
//            int k = in.nextInt();
//            for(int j=1;j<=m;j++){
//                recur(j, m, k,1);
//            }
//
//            System.out.println(count);
//        }

         */
    }

    public static void recur(int i, int m, int k,int curdepth){
        if(curdepth == depth+1){
            return;
        }
        for(int index = 1;index<=m;index++){

            if(i + index < k){
                recur(index, m, k-i, curdepth+1);
            }else if(i + index == k && curdepth == depth){
                count++;
                return;
            }else{
                return;
            }
        }
    }
}