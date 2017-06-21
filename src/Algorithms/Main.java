package Algorithms;

import java.util.*;

public class Main {

    public static int getMinKth(int[] arr,int k){
        if(arr.length<k){
            return -1;
        }
        int[] copyArr = copyArray(arr);
        return select(copyArr,0,copyArr.length-1,k-1);
    }
    public static int[] copyArray(int[] arr){
        int[] res = new int[arr.length];
        for(int i = 0;i!=res.length;i++){
            res[i]=arr[i];
        }
        return res;
    }
    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2]= temp;
    }
    public static int select(int[] arr,int begin,int end,int i){
        if(begin==end){
            return arr[begin];
        }
        int pivot = medianOfMedians(arr,begin,end);
        int[] pivotRange = partition(arr,begin,end,pivot);
        if(i>=pivotRange[0]&&i<=pivotRange[1]){
            return arr[i];
        }else if(i<pivotRange[0]){
            return select(arr,begin,pivotRange[0]-1,i);
        }else{
            return select(arr,pivotRange[1]+1,end,i);
        }
    }
    public static int getMedian(int[] arr,int begin,int end){
        insertionSort(arr,begin,end);
        int sum = end+begin;
        int mid = (sum/2)+(sum%2);
        return arr[mid];
    }
    public static int medianOfMedians(int[] arr,int begin,int end){
        int num= end-begin+1;
        int offset = num%5==0?0:1;
        int[] mArr = new int[num/5+offset];
        for(int i =0;i<mArr.length;i++){
            int beginM = begin+i*5;
            int endM = beginM+4;
            mArr[i] = getMedian(arr,beginM,Math.min(end,endM));
        }
        return select(mArr,0,mArr.length-1,mArr.length/2);
    }
    public static int[] partition(int[] arr,int begin,int end,int pivotValue){
        int small = begin-1;
        int cur = begin;
        int big = end+1;
        while(cur!=big){
            if(arr[cur]<pivotValue){
                swap(arr,++small,cur++);
            }else if(arr[cur]>pivotValue){
                swap(arr,cur,--big);
            }else{
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small+1;
        range[1] = big-1;
        return range;
    }

    public static void insertionSort(int[] arr,int begin,int end){
        for(int i =begin+1 ;i!=end+1;i++){
            for(int j= i;j!=begin;j--){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[50];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i= 0;i<n;i++){
            set.add(arr[i]);
        }
        int[] data = new int[set.size()];
        Iterator it = set.iterator();
        for(int i =0;i<set.size();i++){
            data[i] = (int)it.next();
        }
        int ans = getMinKth(data,3);
        System.out.println(ans);

    }
}