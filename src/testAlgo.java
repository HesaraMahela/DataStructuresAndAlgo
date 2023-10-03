import java.util.Arrays;

public class testAlgo {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,9,1,5,6,4,11};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr){
        mergeSortImp(arr,0,arr.length-1);
    }
    public static void mergeSortImp(int[] arr,int start, int end){
        if (start<end){
         int mid = (start+end)/2;
         mergeSortImp(arr,start,mid);
         mergeSortImp(arr,mid+1,end);
         merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int tempIndex=0;
        int i=start;
        int j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[tempIndex++] = arr[i++];
            }else {
                temp[tempIndex++] = arr[j++];
            }
        }

        while (i<=mid){
            temp[tempIndex++] = arr[i++];
        }
        while (j<=end){
            temp[tempIndex++] = arr[j++];
        }

        for(int k =0; k<temp.length; k++){
            arr[start+k] = temp[k];
        }
    }


    public static void quickSort(int[] arr, int start, int end){
        // you find a pivot value in this case the last one cause it is easy, ideally
        // it should spilt it in to two half's
        if(start<end){
            int pivot = arr[end];
            int i=start-1;
            for(int j =start; j<end;j++){
                if(arr[j]<pivot){
                    i++;// pre increment
                    //swap j and i
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j] = temp;
                }
            }
            // swap i+1 and pivot
            arr[end] = arr[i+1];
            arr[i+1] = pivot;

            //split the 2

            quickSort(arr,start,i);
            quickSort(arr,i+2,end);
        }

    }
}
