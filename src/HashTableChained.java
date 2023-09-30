import java.util.LinkedList;

public class HashTableChained {

    LinkedList[] arr ;
    HashTableChained(int size){
        arr = new LinkedList[size];
    }

    private int getHashCode(int val){
      return val% arr.length;
    }

    public void put(int val){
        arr[getHashCode(val)].add(val);
    }

    public int get(int val){
       return arr[getHashCode(val)].indexOf(val);
    }

    public void remove(int val){
         arr[getHashCode(val)].remove(val);
    }


}
