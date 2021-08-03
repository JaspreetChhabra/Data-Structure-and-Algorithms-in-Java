package Algorithms.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

// GeeksForGeeks Rat in a Maze | Backtracking-2 https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/

public class RatInAMaze {
    public static List<String> pathList;

    public static List<String> findAllPaths(int[][] maze, int n){
        pathList = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if(maze[0][0] == 1){
            visited[0][0] = true;
            findPath(maze, n,0,0,"",visited);
        }

        return pathList;
    }

    private static boolean isWithinMatrix(int n, int destI, int destJ){
        return destI >=0 && destJ >=0 && destI < n && destJ < n;
    }
    public static void findPath(int[][] m, int n, int i, int j, String path, boolean[][] visited){
        if(i == n-1 && j == n-1) pathList.add(path);
        else {
            int[][] dir = new int[][] {
                    {i + 1, j} ,{i, j + (-1)}, {i , j+1}, {i + (-1), j}
            };

            String charDir = "DLRU";

            for(int k =0; k<dir.length; k++){

                int destI = dir[k][0];
                int destJ = dir[k][1];

                if(isWithinMatrix(n, destI, destJ) && m[destI][destJ] == 1 && !visited[destI][destJ]) {

                    visited[destI][destJ] = true;
                    findPath(m,n,destI,destJ,path + charDir.charAt(k), visited);
                    visited[destI][destJ] = false;
                }
            }
        }
    }

    public static void main(String args[])
    {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 1, 1, 0, 0 },
                         { 0, 1, 1, 1 } };

        findAllPaths(maze, maze.length).forEach(System.out::println);

    }
}
