package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class ValidSudoku {

    private static int trans(char a){
        if(a=='.'){
            return -1;
        }else{
            return a-'0';
        }
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[] v;
        for(int i =0 ;i<9;i++){
            v = new boolean[9];
            for(int j = 0;j<9;j++){
                int curNum = trans(board[i][j]);
                if(curNum!=-1&&v[curNum]){
                    return false;
                }else if(curNum!=-1){
                    v[curNum]=true;
                }
            }
        }
        for(int i =0 ;i<9;i++){
            v = new boolean[9];
            for(int j = 0;j<9;j++){
                int curNum = trans(board[j][i]);
                if(curNum!=-1&&v[curNum]){
                    return false;
                }else if(curNum!=-1){
                    v[curNum]=true;
                }
            }
        }

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                v = new boolean[9];
                for(int k = 3*i;k<3*i+3;k++){
                    for(int l = 3*j;l<3*j+3;l++){
                        int curNum = trans(board[k][l]);
                        if(curNum!=-1&&v[curNum]){
                            return false;
                        }else if(curNum!=-1){
                            v[curNum]=true;
                        }
                    }
                }
            }
        }

        return true;

    }

}
