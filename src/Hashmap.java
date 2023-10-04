import java.util.Arrays;

//  why hash map? search something faster than going through the whole list
// how using a hash function?
// todo: terminology ??? good hash function, perfect // there is no deletion
public class Hashmap {
    // liner hash

    public static void main(String[] args) {
        Hashmap myhash = new Hashmap(10);
        myhash.put(456);
        myhash.put(455);
        myhash.put(468);
       // myhash.remove(456);
        System.out.println(Arrays.toString(myhash.arr));
        //System.out.println(myhash.get(455));
    }
    int[] arr;
    Hashmap(int size){
        arr = new int[size];
    }

    public int hash(int value){
        return value%arr.length;
    }

    public void put(int data){
        int hashCode = hash(data);
        // todo :is not full
        // use i to count
        int j=0;

        while(arr[hashCode]>0 && j<arr.length){// arr[hashCode]>0 check the place is occupid
            j++;
            hashCode= (hashCode+1)%arr.length; // linear probing
        }
        if(j<arr.length){
            arr[hashCode] = data;
        }else {
            System.out.println("hash table is full");
        }
        //linear hashing
    }

    public boolean contains(int val){ // should be renamed as contains
        int hashCode = hash(val);// get the hash code and check the table and travel right until 0 is met

        int index=hashCode;

        while(arr[index]!=0 && index != hashCode-1){
            if(arr[index]==val){
                return true;
            }
            index =(index+1)%arr.length;

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
