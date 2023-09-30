import java.util.Arrays;

public class HashTableQua {
    // quadratic probing

    public static void main(String[] args) {
        HashTableQua myhash = new HashTableQua(10);
        myhash.put(456);
        myhash.put(455);
        myhash.put(468);
        myhash.remove(456);
        myhash.put(422);
        myhash.put(422);
        myhash.put(422);
        System.out.println(Arrays.toString(myhash.arr));
        System.out.println(myhash.get(455));
    }
    int[] arr;
    HashTableQua(int size){
        arr = new int[size];
    }

    public int hash(int value){
        return value%arr.length;
    }

    public void put(int data){
        int hashCode = hash(data);

        // use i to count
        int j=0;

        while(arr[hashCode]>0 && j*j<arr.length){ // this cant fill the

            j++;
            hashCode= (hash(data+j*j))%arr.length;
        }
        if(j<arr.length){
            arr[hashCode] = data;
        }else {
            System.out.println("hash table is full");
        }
        //linear hashing
    }

    public int get(int val){
        int hashCode = hash(val);// get the hash code and check the table and travel right until 0 is met

        int index=hashCode;
        int j=0;

        while(arr[index]!=0 && index != hashCode-1){

            if(arr[index]==val){
                return index;
            }
            index =(hash(val+j*j))%arr.length;
            j++;

        }
        return -1;

    }


    public void remove(int val){
        int index=get(val);
        if(index>-1){
            arr[index]=-1;
        }
    }



}
