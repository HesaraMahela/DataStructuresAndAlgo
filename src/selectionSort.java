import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,9,1,5,6};
        sSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sSort(int[] arr){
        // find the largest element and place it at the end.
        for (int i=0;i<arr.length-1;i++){// -1 is one element is already sorted
            int maxIndex =0;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[maxIndex]){
                    maxIndex=j;
                }
            }
            // swap
            int max = arr[maxIndex];
            arr[maxIndex]=arr[arr.length-1-i] ;
            arr[arr.length-1-i]=max;
        }
    }
}
