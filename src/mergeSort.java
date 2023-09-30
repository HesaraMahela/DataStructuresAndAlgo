import javax.swing.*;
import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        mSort(arr);
        System.out.println(Arrays.toString(arr));
        int i=(2+1)/2;
        System.out.println(i);
    }
    public static void mSort(int[] arr){
        mSortImp(arr,0,arr.length-1);

    }

    public static void mSortImp(int[] arr, int start, int end){
        if( start<end){
            // todo : i do not understand how the numbers work get a 4 numbered array explain me
            int mid =(start+end)/2; // = 0+3/2 = 1
            //then it is time to spilt to 2
            mSortImp(arr,start,mid); // 0,1 indexes
            mSortImp(arr,mid+1,end);// 2,3 indexes
            merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr , int start, int mid ,int end){
        int[] temp = new int[end-start+1];// 3-0+1 = 4
        int left = start;//0
        int right = mid + 1;//1+1=2
        int index = 0;
        while(left<=mid && right<=end){ // loop until one side is finished
            if(arr[left]<arr[right]){//
                temp[index++] = arr[left++];
            }else {
                temp[index++]=arr[right++];
            }
            while (left<=mid){
                temp[index++] = arr[left++];
            }
            while (right<end){
                temp[index++] = arr[right++];
            }// temp array is sorted

            // it's time to place it on the real array
            for (int k =0; k<temp.length;k++){
                arr[start+k] =temp[k];
            }

        }
    }
}
