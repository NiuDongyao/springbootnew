package com.ndy.daily;

import java.sql.Connection;
import java.util.Arrays;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class Class993 {
    static TreeNode fatherx;
    static TreeNode fathery;
    static int falg = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5};
        System.out.println(change(5, nums));
        //System.out.println(Integer.MAX_VALUE);
    }

    static int res = 0;

    public static int change(int amount, int[] coins) {
        // 回溯？
        if(amount == 0) return 0;

        dfs(amount, coins);

        return res;
    }

    public static void dfs(int amount, int[] coins){

        if(amount < 0) return;
        if(amount == 0){
            res++;
            return;
        }
        for(int i=0;i<coins.length;i++){
            dfs(amount-coins[i], coins);
        }
    }

}
