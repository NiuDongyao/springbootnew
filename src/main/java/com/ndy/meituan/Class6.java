package com.ndy.meituan;

import java.util.Stack;

public class Class6 {

    public static void main(String[] args) {
        String[][] matrix = new String[][]{{"1","0","1","0","0"}, {"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};

        if(matrix.length == 0 || matrix[0].length == 0) System.out.println(0);

        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == "1"){
                    int tempi = i;
                    int tempj = j;
                    while(tempi<matrix.length && matrix[tempi][tempj] == "1"){
                        tempi++;
                    }
                    tempi--;
                    int rowsSum = tempi-i+1;
                    res = Math.max(res, rowsSum);
                    tempj++;
                    for(int k=i;k<=tempi;k++){
                        if(matrix[k][tempj] == "0"){
                            tempi = k-1;
                            if(tempi == i-1) break;
                            k = i-1;
                            res = Math.max(res, (tempi - i+1)*(tempj-j+1));
                            tempj++;
                        }else if(k==tempi && matrix[k][tempj] == "1"){
                            res = Math.max(res, (tempi - i+1)*(tempj-j+1));
                            k = i-1;
                            tempj++;
                        }
                        if(tempj >= matrix[0].length) break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
