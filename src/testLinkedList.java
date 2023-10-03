public class testLinkedList {
    Node head;

    public static void main(String[] args) {
            testLinkedList list = new testLinkedList();
            list.head = new Node(1);

    }

    void insert(int data, int index){

        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }
        if(index==0){
            //
        }
        Node temp = head;
        int curIndex = 0;
        while (temp.next != null && curIndex<index){
            temp = temp.next;
            curIndex++;
        }
        if (temp.next== null){
            temp.next = newNode;
        }else {
            Node next = temp.next;
            temp.next = newNode;
            newNode.next = next;

        }



    }




}
