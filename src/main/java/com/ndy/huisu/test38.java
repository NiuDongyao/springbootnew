package com.ndy.huisu;

import org.apache.logging.log4j.util.Strings;

import java.util.*;

public class test38 {

    public static void main(String[] args) {
//        permutation("abc");
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("abc");
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb);
        List<String> strings = letterCombinations("23");
        System.out.println("*****************");
        for(String s : strings){
            System.out.println(s);
        }
    }


    public static int reverse(int x) {
        int result = 0;
        while(x>0){
            int xlast = x % 10;
            System.out.println("xlast:" + xlast );
            x = x / 10;
            System.out.println("x: " + x);
            if(Integer.MAX_VALUE / 10 < result ||
                    (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < xlast)){
                return 0;
            }
            result = result * 10 + xlast;
            System.out.println("result：" + result);
        }
        return result;
    }

    public static boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        int indexs = 0;
        int indexp = 0;
        while(indexs < s.length() && indexp < p.length()){
            if((chars[indexs] == charp[indexp] || charp[indexp] == '.') && indexp<p.length()-1 && charp[indexp+1] != '*'){
                indexp++;
                indexs++;
            }else if(chars[indexs] == charp[indexp] || charp[indexp] == '.' && indexp==p.length()-1){
                indexp++;
                indexs++;
            }else if(indexp<p.length()-1 && charp[indexp+1] == '*'){ // 相当于p这里是 字符*组合
                char cp = charp[indexp];  // 字符*的第一个字符

                if(cp == '.'){
                    if(indexp < p.length()-2){ //.*后还有字符
                        char tempp = charp[indexp+2];
                        while(indexs < s.length() && chars[indexs] != tempp){
                            indexs++;
                        }
                        indexp+=2;
                        continue;
                    }
                    return true;
                }

                if(cp != chars[indexs]){
                    indexp += 2;
                    continue;
                }

                while(indexs < s.length() && chars[indexs] == cp){
                    indexs++;
                }
                indexp+=2;

                // if(cp == '.'){
                //     return true;
                // }
                // if(chars[indexs] != cp){
                //     indexp++;
                //     continue;
                // }
                // while(indexs < s.length() && chars[indexs] == cp){
                //     indexs++;
                // }
                // indexp++;
            }else{
                return false;
            }
        }

        if(indexs >= s.length()) return true;
        if(indexp >= p.length()) return false;
        return true;
    }

    public static List<String> letterCombinations(String digits) {
        //回溯?
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;

        // Deque<String> deque = new ArrayDeque<>();
        // dfs();
        // return result;

        Stack<String> queue = new Stack<>();
        Set<StringBuffer> set = new HashSet<>();
        for(int i=0;i<digits.length();i++){
            if(digits.charAt(i) == '2'){
                queue.add("abc");
            }else if(digits.charAt(i) == '3'){
                queue.add("def");
            }else if(digits.charAt(i) == '4'){
                queue.add("ghi");
            }else if(digits.charAt(i) == '5'){
                queue.add("jkl");
            }else if(digits.charAt(i) == '6'){
                queue.add("mno");
            }else if(digits.charAt(i) == '7'){
                queue.add("pqrs");
            }else if(digits.charAt(i) == '8'){
                queue.add("tuv");
            }else if(digits.charAt(i) == '9'){
                queue.add("wxyz");
            }

            while(i==0 || !result.isEmpty()){
                String temp = "";
                if(i != 0){
                    temp = result.remove(0);
                    System.out.println("temp : " + temp);
                }
                //StringBuffer sb = new StringBuffer(temp);

                    String tempq = queue.peek();
                    System.out.println("queue:" + tempq);
                    for(int j=0;j<tempq.length();j++){
                        StringBuffer sb = new StringBuffer(temp);
                        sb.append(tempq.charAt(j));
                        System.out.println("sb:"+sb.toString());
                        set.add(sb);
                        //sb.deleteCharAt(sb.length()-1);
                    }

                if(i==0) break;
            }
            for(StringBuffer sb : set){
                System.out.println("set:" + sb.toString());
                result.add(sb.toString());
            }
            set.clear();
        }
        return result;
    }


}
