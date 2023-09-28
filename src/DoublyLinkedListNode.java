public class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int data){
        this.data =data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
