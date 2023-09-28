public class Linkedlist {
    Node head;

    Linkedlist(){

    }

    public void insertLast(int data){
        Node newNode = new Node(data);
        if (head==null){
            head=newNode;
        }else{
            Node temp = head;

            while (temp.next !=null){
                temp =temp.next;
            }

            temp.next=newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(new String("[ "));
        Node temp= head;

        while (temp.next !=null){
            output.append(temp.data);
            output.append(", ");
            temp =temp.next;
        }
        output.append(temp.data);
        output.append(" ]");
        return output.toString();
    }

    public void deleteByData(int data){
        if(head==null){throw new IndexOutOfBoundsException("List is empty");}

        if(head.data==data){
            head=head.next;
        }else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data == data) { // now it stops Node before the Node that should be deleted.
                    break;
                }
                temp = temp.next;
            }
            if (temp.next.data == data) {
                temp.next = temp.next.next;
            } else {
                throw new IndexOutOfBoundsException("No similar data found");
            }
        }
    }

    public void deleteByIndex(int index){

        if (index==0){
            head =head.next;
        }else{
            Node temp = head;
            int currIndex=0;

            while (temp.next.next !=null && currIndex !=index-1){
                temp =temp.next;
                currIndex++;
            }

            if (temp.next.next !=null &&  currIndex ==index-1){
                temp.next =temp.next.next;
            } else if (temp.next.next ==null && currIndex ==index-1) {// last node
                temp.next =temp.next.next;
            } else {
                throw new IndexOutOfBoundsException(index);
            }

        }
    }
    public void insertByIndex(int data,int index) {
        Node NewNode = new Node(data);
        if (index==0){
            NewNode.next=head;
            head =NewNode;
        }else{
            Node temp = head;
            int currIndex=0;

            while (temp.next.next !=null && currIndex !=index-1){
                temp =temp.next;
                currIndex++;
            }// returns temp which is one Node before the index

            if (temp.next.next !=null &&  currIndex ==index-1){
                NewNode.next =temp.next;
                temp.next =NewNode;
            } else if (temp.next.next ==null && currIndex ==index-1) {// last node
                temp.next =NewNode;
            } else {
                throw new IndexOutOfBoundsException(index);
            }

        }
    }

}
