import java.util.Arrays;

public class QuickSort {

//
//    public static void quickSort(int[] arr ,int start, int end) {
//        //System.out.println(start +" "+ end);
//
//        if(start<end) {
//            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, end+1)) +" start "+ start + " end " +end);
//            int pivot = arr[end];
//            int i = start;
//            int j = end-1;


// 
//
//            }
//            // swap pivot and recurse
//
//            //System.out.println("pivot "+arr[end] +" arr[j] "+ arr[j]);
//            if(j==start){// to make the first element
//                //if array is two this makes wrong
//                if (start +1 ==end && arr[start]<arr[end]){
//
//                }else {
//
//                    arr[end] = arr[j];
//                    arr[j] = pivot;
//                }
//            }else {
//                arr[end] = arr[j + 1];
//                arr[j + 1] = pivot;
//            }
//            //System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start,i)));
//
//           // System.out.println(i+"fff" +j);
//            quickSort(arr,start,i);
//            quickSort(arr,i+1,end);
//        }
//    }
//
//    public static void main(String[] args) {
//      //  int[] array = new int[] {5,3,9,4,6};
//        int[] array = new int[] {5,3,9,4,6};
//        quickSort(array,0,array.length-1);
//        System.out.println(Arrays.toString(array));
//    }
//public static void quickSort(int[] arr, int start, int end) {
//    if (start < end) {
//        int pivotIndex = partition(arr, start, end);
//        quickSort(arr, start, pivotIndex - 1);
//        quickSort(arr, pivotIndex + 1, end);
//    }
//}

//    public static int partition(int[] arr, int start, int end) {
//        int pivot = arr[end];
//        int i = start - 1;
//
//        for (int j = start; j < end; j++) {
//            if (arr[j] < pivot) {
//                i++;
//                swap(arr, i, j);
//            }
//        }
//
//        swap(arr, i + 1, end);
//        return i + 1;
//    }
//
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
//
    public static void main(String[] args) {
        int[] array = new int[] { 3,2,1};
        quickSort1(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public static void  quickSort(int[] arr, int start,int end) {
        if (start < end) {
            int pivot = arr[end];
            int i = start;
            for (int j = start; j < end; j++) { // if you found something less than the pivot place it in the leftside
                if (arr[j] < pivot) {
                    swap(arr,i++,j);
                }
            }
            //swap pivot with i+1
            swap(arr,i,end);
            // recursion
            quickSort(arr, start, i -1);
            quickSort(arr, i + 1, end);
        }
    }

    static void quickSort1(int[] arr, int start,int end){
        if(start<end){

        }
        int pivot =arr[end];
        int i=start;
        for(int j=start; j<end;j++){
            if(arr[j]<pivot){
                //swap(1,j)
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] =temp;
                i++;
            }
        }
        // swap last one with the i position

        arr[end] = arr[i];
        arr[i] = pivot;

        quickSort(arr, start,i-1);
        quickSort(arr,i+1,end);
    }


}
