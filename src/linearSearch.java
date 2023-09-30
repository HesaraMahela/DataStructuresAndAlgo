import java.util.Arrays;

public class linearSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(binarySearch(arr, 3));

    }
    public static int lSearch(int[] arr, int val){
        // 3,2,1 ->
        for(int index=0; index<arr.length; index++){ // 0 to 2
            if(arr[index]==val){
                return index;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr,int val){
        // sorted array is nessasory
        // log(n)
        int start =0;
        int end = arr.length-1;


        while(start < end){
            int mid = (end+start)/2;

            if(arr[mid] == val){
                return mid;
            }else if(arr[mid]>val){// the item should be in left side of the array
                end = mid-1;
            }else if(arr[mid]<val){//in right side
                start = mid+1;
            }

        }
        return -1;
    }
    
}

