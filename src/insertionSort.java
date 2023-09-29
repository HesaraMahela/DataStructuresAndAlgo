import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,9,1,5,6};
        inSort(arr);
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
                arr[j-1]=temp;
                j--;
            }
        }
    }
}
