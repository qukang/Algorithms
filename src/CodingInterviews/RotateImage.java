package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i< length; i++){
            for(int j = 0; j< i; j++){
                swap(matrix,i,j,j,i);
            }
        }
        for(int i = 0; i< length; i++){
            for(int j = 0; j< length /2; j++){
                swap(matrix,i,j,i,length-1-j);
            }
        }
    }

    private static void swap(int[][] matrix,int a,int b,int c,int d){
        if(a!=c||b!=d){
            matrix[a][b] = matrix[a][b]^matrix[c][d];
            matrix[c][d] = matrix[a][b]^matrix[c][d];
            matrix[a][b] = matrix[a][b]^matrix[c][d];
        }

    }

    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        rotate(a);
        for(int i =0 ;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                System.out.println(a[i][j]);
            }
        }
    }
}
