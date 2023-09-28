//  why hash map? search something faster than going through the whole list
// how using a hash function?
// todo: terminology ??? good hash function,perfect // there is no deletion
public class Hashmap {
    int[] arr;
    Hashmap(int size){
        arr = new int[size];
    }

    private int hash(int value){
        return value%arr.length;
    }

    public void insert(int data){
        int hashCode = hash(data);
        // todo :is not full
        // use i to count
        while(arr[hashCode]>0){
            hashCode = (hashCode+1)%arr.length;
        }
        arr[hashCode] = data;

        //linear hashing
    }


}
