public class CircularDoublyLinkedList {
 DoublyLinkedListNode Head;
 DoublyLinkedListNode Tail;


 public void insert(int data){
     DoublyLinkedListNode node = new DoublyLinkedListNode(data);
     if (Head==null){ // inserting first element
         Head  = node;
         Tail =node;
         node.prev = node;
         node.next =node;
     }else {// insert from tail
         node.prev =Tail;
         Tail.next = node;
         Tail = node;

         Tail.next = Head;
     }
 }

 public void print(){
     // starts from head and loop til the tail
     if(Head==null){
         System.out.println("the list is empty");
         return;
     }
     DoublyLinkedListNode temp = Head;
     System.out.print("[");
     while(temp != Tail){// goes only till the last one don't read last node

         System.out.print(temp+", ");
         temp =temp.next; // this should come after printing
     }
     System.out.println(temp + "]");
 }

 public static void main(String args[]){
     CircularDoublyLinkedList list = new CircularDoublyLinkedList();
     list.insert(1);
     list.insert(2);
     list.insert(3);
     list.insert(4);
     list.insert(5);
     list.delete(5);
     list.print();


 }
private void deleteNode(DoublyLinkedListNode temp){
    DoublyLinkedListNode prevNode = temp.prev;
    DoublyLinkedListNode nextNode = temp.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
}





public void delete(int val){
     /* loop through the list head to tail if the value was found delete it and set it */
    if(Head.next==Head){ // if only one element was in the list
        Head =null;
        Tail = null;
        return;
    }

    DoublyLinkedListNode temp = Head;
    if (Head.data == val){ // the first node deleting
        deleteNode(temp);
        Head =Head.next;
        return;
    }
    while (temp.next != Head){ // head to the tail excluding tail or do wile can be used
        if (temp.data == val) {
            deleteNode(temp);
            break;
        }
        temp = temp.next;
    }

    if(Tail.data==val){// the last item
        System.out.println(temp);
        deleteNode(temp);
        Tail = Tail.prev;
    }
}

}
