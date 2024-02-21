import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                arr[j][i] = sc.nextInt();
                
            }

        }
        
        System.out.print(paths(arr,m-1,n-1));
    }
    static int paths(int[][] arr,int x,int y)
    {
        if(x<0 || y<0) return 0;
        
        if(arr[x][y]==0) return 0;
        if(x==0 && y==0) return 1;
        arr[x][y]=paths(arr,x-1,y)+paths(arr,x,y-1);
        return arr[x][y];
    }
  }
