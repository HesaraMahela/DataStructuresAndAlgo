import java.util.Arrays;

public class bubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,6,9,4};
        bSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bSort(int[] arr){
        // swap if out of order
        // through that largest item is placed at the end


        for(int i=0;i<arr.length-1;i++){
            boolean isSwaped =false;

            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){// is out of order
                    //swap
                    int temp=arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                    isSwaped = true;
                }
            }
            if(!isSwaped) break;
        }
    }
}
