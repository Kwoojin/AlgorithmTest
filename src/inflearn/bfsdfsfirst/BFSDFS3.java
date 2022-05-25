package inflearn.bfsdfsfirst;

import java.util.Scanner;

public class BFSDFS3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = DFS(n);
        System.out.print(answer);
    }

    public static int DFS(int n){
        if(n==1) return 1;
        else{
            return n*DFS(n-1);
        }
    }
}
