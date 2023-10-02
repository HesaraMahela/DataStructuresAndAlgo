import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,9,1,5,6,4,11};
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void inSort(int[] arr){
        // todo : i am not comfortable with this
        for (int i =1; i<arr.length; i++){
            int temp = arr[i];
            int j =i;
            while (j>0 && arr[j-1]>temp){
                // swap them temp with j-1
                arr[j] = arr[j-1];
                j--;
                //arr[j-1]=temp;
                // j--; this is less efficient
            }
            arr[j] = temp;

        }
    }
    public static void insertionsort(int[] arr){
        for(int j=1; j<arr.length; j++){ // 0 th element is already sorted
           int key = arr[j];
           int i =j-1;
           while(i>=0 && arr[i]>key){
               arr[i+1]=arr[i];
               i--;
           }
           arr[i+1]=key;
        }
    }
}
