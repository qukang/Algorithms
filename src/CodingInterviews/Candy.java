package CodingInterviews;

/**
 * Created by qukan on 2017/8/16.
 */
public class Candy {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] c = new int[N];
        int inc = 1;
        for(int i = 1;i<N;i++){
            if(ratings[i]>ratings[i-1]){
                c[i]=Math.max(inc++,c[i]);
            }else{
                inc=1;
            }
        }
        inc = 1;
        for(int i = N-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                c[i] = Math.max(inc++,c[i]);
            }else{
                inc=1;
            }
        }

        int sum = 0;

        for(int i = 0;i<N;i++){
            sum+=c[i];
        }

        return sum+N;
    }
}
