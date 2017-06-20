/**
 * Created by qukan on 2017/5/6.
 */
public class 数组中的逆序对 {
        public int InversePairs(int [] array) {
            if(array.length<=1){
                return 0;
            }
            int[] temp = new int[array.length];
            return MergeSort(array,temp,0,array.length-1);
        }

        public int MergeSort(int[] array,int[] temp,int begin,int end){
            if(begin>=end){
                return 0;
            }
            int count = 0;
            int mid = (begin+end)/2;
            count += MergeSort(array,temp,begin,mid);
            count += MergeSort(array,temp,mid+1,end);
            count += Merge(array,temp,begin,mid,end);
            return count%1000000007;
        }
        public int Merge(int[] array,int[] temp, int begin,int mid,int end){
            int count = 0;
            int left = begin;
            int right = mid+1;
            int tmp = begin;
            while(left<=mid&&right<=end){
                if(array[left]<=array[right]){
                    temp[tmp++]=array[left++];
                }else{
                    temp[tmp++]=array[right++];
                    count+=(mid-left+1);
                }
            }
            while(left<=mid){
                temp[tmp++] = array[left++];
            }
            while(right<=end){
                temp[tmp++] = array[right++];
            }
            tmp = begin;
            while(tmp<=end){
                array[tmp]=temp[tmp++];
            }
            return count%1000000007;
        }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,0};
        数组中的逆序对 s = new 数组中的逆序对();
        int b = s.InversePairs(a);
        System.out.print(b);
    }
}
