package com.keshav.ctci.leetcode;


/*
*
* 200. Number of Islands
Medium

2358

85

Favorite

Share
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and
 is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all
 surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
* */

import com.keshav.ctci.queue.Queue;
import com.keshav.ctci.util.Tuple;

public class NumIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        // Keep a queue to visit

        Queue<Tuple<Integer>> q = new Queue<>();
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    q.insert(new Tuple<Integer>(i, j));
                    while(!q.isEmpty()) {
                        Tuple<Integer> t = q.deque();
                        int x = t.x;
                        int y = t.y;
                        if (x >= m || x < 0 || y >= n || y < 0) continue;
                        if(grid[x][y] == '0') continue;
                        if (!visited[x][y]) {
                            visited[x][y] = true;
                            q.insert(new Tuple<Integer>(x+1, y));
                            q.insert(new Tuple<Integer>(x-1, y));
                            q.insert(new Tuple<Integer>(x, y+1));
                            q.insert(new Tuple<Integer>(x, y-1));
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        /*
        * Example 2:

        Input:
        11000
        11000
        00100
        00011

        Output: 3
        * */
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }
}
