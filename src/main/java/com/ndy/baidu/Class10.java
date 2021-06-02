package com.ndy.baidu;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class Class10 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        //searchRange(nums, 8);
        //search(nums, 1);
        double v = myPow(2.0, -2147483648);
        System.out.println(v);
        //nextGreaterElement(num);
        //System.out.println(s.charAt(5) > s.charAt(3));
         //Integer i = (Integer)s;


//        int[][] res = new int[][]{{1,4},{0,4}};
//        HashSet<Integer> set = new HashSet<>();
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        Arrays.sort(res, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] != o2[0]){
//                    return o1[0]-o2[0];
//                }else{
//                    return o1[1]-o2[1];
//                }
//            }
//        });
//        for(int i=0;i<res.length;i++){
//            for(int j=0;j<res[0].length;j++){
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static double myPow(double x, int n) {
        //int absn = Math.abs(n);

        if(x == 1 || n==0) return 1;
        if(x == 0)         return 0;
        int absn = Math.abs(n);
        double res = 1;
        while(absn>=2){
            if(absn % 2 != 0) res *= x;
            absn = absn / 2;
            x = x * x;
        }
        res *= x;
        return n >= 0 ? res : 1/res;
    }

    public static int[] searchRange(int[] nums, int target) {
        //找两次，一次获取target最左边的位置，一次获取target最右边的位置

        if(nums.length==0) return new int[]{-1,-1};
        if(nums.length == 1){
            if(nums[0] == target) return new int[]{0,0};
            return new int[]{-1,-1};
        }
        int[] res = new int[]{-1,-1};
        int left = 0;
        int right = nums.length;
        res[0] = findLeft(nums, left, right, target);
        res[1] = findRight(nums, left, right, target);
        //if(res[0] == res[1] && nums[res[0]] != target) return new int[]{-1,-1};
        return res;
    }

    public static int findLeft(int[] nums, int left, int right, int target){
        int res = -1;
        while(left < right){
            int mid = left + (right - left);
            if(nums[mid] == target){
                res = mid;
                right = mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        return res;
    }

    public static int findRight(int[] nums, int left, int right, int target){
        int res = -1;
        while(left < right){
            int mid = left + (right - left) >> 1;
            if(nums[mid] == target){
                res = mid;
                left = mid+1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        return res;
    }


    public static int search(int[] nums, int target) {
        // 肯定是用二分
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] < nums[mid]){ // 说明前半部分有序
                if(target >= nums[left] && target <nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target >nums[mid] && target <=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static int nextGreaterElement(int n) {
        // 和31题挺像的
        String num = String.valueOf(n);
        int i = 0, j = 0, k = 0;
        int len = num.length();
        for(int index = len-1; index > 0; index--){
            if(num.charAt(index) > num.charAt(index-1)){
                i = index-1;
                j = index;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
        //System.out.println(k);
        if(j==0) return -1;

        StringBuffer sb = new StringBuffer();

        for(int index = len-1; index >=j; i--){
            if(num.charAt(index) > num.charAt(i)){
                k = index;
                System.out.println(k);
                sb.append(num.substring(0, i));
                sb.append(num.charAt(k));
                sb.append(num.substring(i+1, k));
                sb.append(num.charAt(i));
                break;
            }
        }
        long resnum = Long.parseLong(sb.toString());
        if(resnum > Integer.MAX_VALUE) return -1;
        return (int)resnum;
    }
}
