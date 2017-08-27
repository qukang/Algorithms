/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Question2 {
    public static int[] countOfSmallerNumberII(int[] A) {
        int[] r = new int[A.length];
        if(A.length == 0){
            return r;
        }
        int min = A[0];
        int max = A[0];
        for(int i = 0; i < A.length; ++i){
            if(A[i] < min){
                min = A[i];
            }

            if(A[i] > max){
                max = A[i];
            }
        }
        Node node = new Node(min, max);
        for(int i = 0; i < A.length; ++i){
            r[i]=(i-node.add(A[i]));
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int i = 0;i<n;i++){
            score[i]=in.nextInt();
        }
        int[] res = countOfSmallerNumberII(score);
        for(int i = 0;i<res.length-1;i++){
            System.out.print(res[i]);
            System.out.print(" ");
        }
        System.out.println(res[res.length-1]);
    }
}
class Node{
    public int begin;
    public int end;
    public int mid;
    public int count;
    public Node left;
    public Node right;

    public Node(int begin, int end){
        this.begin = begin;
        this.end = end;
        this.mid = (begin + end) / 2;
        this.count = 0;
        this.left = null;
        this.right = null;
    }

    int add(int num){
        ++count;
        if(begin == end){
            return 0;
        }else{
            if(left == null){
                left = new Node(begin, mid);
            }
            if(right == null){
                right = new Node(mid + 1, end);
            }

            if(num <= mid){
                return this.left.add(num);
            }else{
                return this.left.count + this.right.add(num);
            }
        }
    }
}
*/
