import java.util.Comparator;

/**
 * Created by qukan on 2017/6/5.
 */
public class SortUtil {
    public static void selectionSort(Comparable[] a){
        /*if(isOrdered(a)){
            return;
        }*/
        int N = a.length;
        for(int i = 0;i<N;i++){
            int min = i;
            for(int j = i+1;j<N;j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            swap(a,min,i);
        }
    }

    public static void insertionSort(Comparable[] a){
        /*if(isOrdered(a)){
            return;
        }*/
        int N = a.length;
        for(int i = 1;i<N;i++){
            for(int j = i;j>0&&less(a[j],a[j-1]);j--){
                swap(a,j,j-1);
            }
        }
    }

    public static void shellSort(Comparable[] a){
        /*if(isOrdered(a)){
            return;
        }*/
        int N = a.length;
        int h = 1;
        while(h<N/3) h = h*3+1;
        while(h>=1){
            for(int i = h;i<N;i++){
                for(int j = i;j>=h&&less(a[j],a[j-h]);j = j - h){
                    swap(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void mergeSort(Comparable[] a){
        /*if(isOrdered(a)){
            return;
        }*/
        int N = a.length;
        Comparable[] b = new Comparable[N];
        mergeSort(a,b,0,N-1);
    }

    private static void mergeSort(Comparable[] a, Comparable[] b, int begin, int end){
        if(begin>=end)
            return ;
        int N = a.length;
        int mid = (begin+end)/2;
        mergeSort(a,b,begin,mid);
        mergeSort(a,b,mid+1,end);
        merge(a,b,begin,mid,end);
    }

    private static void merge(Comparable[] a, Comparable[] b, int begin, int mid, int end){
        int left = begin;
        int right = mid+1;
        for(int i = begin;i<=end;i++){
            b[i] = a[i];
        }
        int k = begin;
        while(k<=end){
            if(left>mid){
                a[k]=b[right++];
            }
            else if(right>end){
                a[k]=b[left++];
            }
            else if(less(b[right],b[left])){
                a[k]= b[right++];
            }
            else{
                a[k]= b[left++];
            }
            k++;
        }
    }

    public static void quickSort(Comparable[] a){
        int N = a.length;
        quickSort(a,0,N-1);
    }
    private static void quickSort(Comparable[] a,int begin, int end){
        if(begin>=end) return ;
        int pos = partition(a,begin,end);
        quickSort(a,begin,pos-1);
        quickSort(a,pos+1,end);
    }

    private static int partition(Comparable[] a,int begin, int end){
        int left = begin;
        int right = end+1;
        Comparable target = a[begin];
        while(left<right){
            while (less(target,a[--right])&&right>=begin) ;
            while (less(a[++left],target)&&left<end) ;
            if(left<right) swap(a,left,right);
        }
        if(right>begin) swap(a,begin,right);
        return right;
    }

    public static void heapSort(Comparable[] a){
        int N = a.length-1;
        for(int i = N/2;i>=1;i--){
            sink(a,i,N);
        }
        while(N>1){
            swap(a,1,N--);
            sink(a,1,N);
        }
    }

    private static void sink(Comparable[] a, int p, int N){
        while(2*p<=N){
            int j = 2*p;
            if(j<N&&less(a[j],a[j+1])) j++;
            if(!less(a[p],a[j])) break;
            swap(a,j,p);
            p = j;
        }
    }



    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static void swap(Comparable[] a,int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isOrdered(Comparable[] a){
        for(int i = 1;i<a.length;i++){
            if(!less(a[i-1],a[i])) return false;
        }
        return true;
    }

    public static void main(String[] args){
        int n = 100000;
        Integer[] a = new Integer[n];
        for(int i = 0;i<n;i++){
            a[i] = (int)(Math.random()*n);
        }
        Integer[] b = new Integer[n];
        for(int i = 0;i<n;i++){
            b[i] = (int)(Math.random()*n);
        }
        Integer[] c = new Integer[n];
        for(int i = 0;i<n;i++){
            c[i] = (int)(Math.random()*n);
        }
        Integer[] d = new Integer[n+1];
        for(int i = 1;i<=n;i++){
            d[i] = (int)(Math.random()*n);
        }
        /*Stopwatch timer1 = new Stopwatch();
        SortUtil.selectionSort(a);
        double t1 = timer1.elapsedTime();
        Stopwatch timer2 = new Stopwatch();
        SortUtil.insertionSort(b);
        double t2 = timer2.elapsedTime();*/
        Stopwatch timer1 = new Stopwatch();
        SortUtil.mergeSort(a);
        double t1 = timer1.elapsedTime();
        Stopwatch timer2 = new Stopwatch();
        SortUtil.quickSort(b);
        double t2 = timer2.elapsedTime();
        Stopwatch timer3 = new Stopwatch();
        SortUtil.shellSort(c);
        double t3 = timer3.elapsedTime();
        Stopwatch timer4 = new Stopwatch();
        SortUtil.heapSort(d);
        double t4 = timer4.elapsedTime();
/*
        SortUtil.show(d);
*/
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);

    }

}
