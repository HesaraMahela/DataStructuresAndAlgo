public class CircularLinedList {

    public Node head;

    public CircularLinedList(){}

    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            head.next = head;
        } else if (head.next ==head) { // inserting 2 nd Node
            newNode.next=head;
            head.next=newNode;
        } else{
            Node temp = head;
            while (temp.next != head){
                temp = temp.next;
                // returns the last element
            }

            newNode.next=head;
            temp.next=newNode;

        }
    }



    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(new String("[ "));
        Node temp= head;

        while (temp.next !=head){
            output.append(temp.data);
            output.append(", ");
            temp =temp.next;
        }
        output.append(temp.data);
        output.append(" ]");
        return output.toString();
    }


    public void insert(int index,int data){
        Node newNode = new Node(data);
        if(index==0) {
            newNode.next=head;
            head=newNode;
        } else{
            int currIndex =0;
            Node temp = head;
            while (temp.next != head && currIndex != index -1){
                temp = temp.next;
                // returns the element before the node
                currIndex++;
            }
            if (temp.next != head  && currIndex == index -1){ // TODO this have to be changed. setting last une to head.
                Node prevNext=temp.next;
                newNode.next=prevNext;
                temp.next =newNode;

            } else if (currIndex == index -1) {// last element
                newNode.next=head;
                temp.next=newNode;

            } else {
                throw new IndexOutOfBoundsException(index);
            }


        }

    }

    public void deleteByData(int data){
        if(head.data==data){
            head = head.next;
        }else{
            Node temp = head;
            while (temp.next != head ){
                if(temp.next.data == data){
                    temp.next = temp.next.next;

                    break;
                 }
                temp = temp.next;
                // returns the element before the node
            }
        }
    }
}
