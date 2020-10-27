
/*Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

* */

package com;

public class Islands {

    private static int islandCount(int[][] island){
        if (island.length==0 || island==null){
            return 0;
        }
        int numberOfIslands=0;
        for (int i = 0; i < island.length; i++) {
                for (int j = 0; j < island[i].length; j++) {
                    if (island[i][j]==1){
                        numberOfIslands+=sink(island,i,j);
                    }
                }

            }
        return  numberOfIslands;
    }

    private static int sink(int[][] island, int i, int j) {
        if (i<0 || i>=island.length || j>=island[0].length||j<0||island[i][j]==0){
            return 0;
        }

        island[i][j]=0;
        sink(island,i+1,j);
        sink(island,i-1,j);
        sink(island,i,j+1);
        sink(island,i,j-1);

        return 1;
    }

    public static void main(String[] args){
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}};
        int i = islandCount(grid);
        System.out.println(i);
    }
}
