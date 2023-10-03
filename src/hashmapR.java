import java.util.Arrays;

public class hashmapR {
    int[] arr ;

    hashmapR(int size){
        arr =new int[size];
    }

 /* rehashing */

    public int getHashCode(int val){
        return val%arr.length;
    }

    public static void main(String[] args) {
        HashTableQua myhash = new HashTableQua(10);
        myhash.put(456);
        myhash.put(455);
        myhash.put(468);

        myhash.put(422);
        myhash.put(422);
        myhash.put(455);
        System.out.println(Arrays.toString(myhash.arr));

    }


    public int hash2(int value){
        return value%(4);
    }

    public void put(int data){
        int hashCode = getHashCode(data);

        // use i to count
        int j=0;

        while(arr[hashCode]>0 && j*j<arr.length){ // this cant fill the

            j++;
            hashCode= (getHashCode(data)+j*hash2(data))%arr.length;
        }
        if(j<arr.length){
            arr[hashCode] = data;
        }else {
            System.out.println("hash table is full");
        }
        //linear hashing
    }

    public boolean contains(int val){
        int hashCode = getHashCode(val);// get the hash code and check the table and travel right until 0 is met

        int index=hashCode;
        int j=0;

        while(arr[index]!=0 && index != hashCode-1){

            if(arr[index]==val){
                return true;
            }
            index =(getHashCode(val)+j*hash2(val))%arr.length;
            j++;

        }
        return false;

    }


//    public void remove(int val){
//        int index=get(val);
//        if(index>-1){
//            arr[index]=-1;
//        }
//    }


}
