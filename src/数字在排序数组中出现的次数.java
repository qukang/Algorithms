/**
 * Created by qukan on 2017/5/8.
 */
public class 数字在排序数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        int firstK = getFirstk(array,k);
        int lastK = getLastk(array,k);
        if (firstK == -1 || lastK == -1) {
            return 0;
        }
        return lastK-firstK+1;
    }

    public static int getFirstk(int [] array,int k){
        int begin = 0;
        int end = array.length-1;
        int mid;
        while(begin<=end){
            mid = (begin+end)/2;
            if(array[mid]==k&&(mid==0||array[mid-1]<k)){
                return mid;
            }else if(array[mid]<k){
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static int getLastk(int [] array,int k){
        int begin = 0;
        int end = array.length-1;
        int mid;
        while(begin<=end){
            mid = (begin+end)/2;
            if(array[mid]==k&&(mid==array.length-1||array[mid+1]>k)){
                return mid;
            }else if(array[mid]>k){
                end = mid-1;
            }else{
                begin = mid+1;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        int[] a = {1,3,3,3,3,4,5};
        int k = 2;
        数字在排序数组中出现的次数 s = new 数字在排序数组中出现的次数();
        int b = s.GetNumberOfK(a,k);
        System.out.print(b);
    }
}
