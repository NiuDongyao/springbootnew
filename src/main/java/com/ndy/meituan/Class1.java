package com.ndy.meituan;

import java.util.Scanner;

public class Class1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            int n = in.nextInt();
            String s = in.next();
            int mid = s.length() / 2;
            char[] chars = s.toCharArray();
            int notCount = 0; // 如果有回文数，有多少
            int notindexleft = 0;
            int notindexright = 0;
            int left = 0;
            int right = s.length() - 1;
            while(left <= right){
                if(chars[left] != chars[right]){
                    notCount++;
                    if(notCount > 1) { // 说明不能改为回文串。
                        break;
                    }
                    notindexleft = left;
                    notindexright = right;
                }
                left++;
                right--;

            }
            if(notCount > 1){
                for(int j=0;j<s.length();j++){
                    if(chars[j] == '0') continue;
                    chars[j] = '0';
                    s = String.valueOf(chars);
                    System.out.println(s);
                    break;
                }
            }else if(notCount == 0){
                if(s.length() % 2 == 1){
                    chars[s.length()/2] = '0';
                    s = String.valueOf(chars);

                }
                System.out.println(s);
            }else{
                if(chars[notindexleft] < chars[notindexright]){
                    chars[notindexright] = chars[notindexleft];
                }else{
                    chars[notindexleft] = chars[notindexright];
                }
                s = String.valueOf(chars);
                System.out.println(s);
            }
        }
    }
}
