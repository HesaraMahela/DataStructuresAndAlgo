public class Queue {
    int[] arr;
    int front =-1;
    int rear =-1;

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enque(1);
        queue.enque(2);
        queue.deque();
        queue.deque();

        queue.enque(3);
//        System.out.println(queue.rear);
//        System.out.println(queue.front);
        queue.enque(4);
        queue.print();
    }

    public Queue(int size){
        arr =new int[size];

    }

    public void enque(int data){
        if(!isFull()){
            if(isEmpty()){
                front=0;
                rear=0;
            }
            arr[rear]=data;
            System.out.println(rear);
            rear = (rear+1)%arr.length;

        }
    }

    public int deque(){
        if(!isEmpty()){
            int temp = arr[front];
            arr[front]=0;
            front =(front+1)%arr.length;
            if(front == rear){
                front =-1;
                rear =-1;
            }
            return temp;
        }
        return -1;
    }


    public boolean isFull(){
        return (rear  == front && rear!=-1)  || (front == 0 && rear == arr.length -1);
    }

    public boolean isEmpty(){
        return rear == -1 && front == -1;
    }
    public void print(){
        for(int i=0; i<arr.length ;i++){
            System.out.print(arr[i] + ", ");
        }
    }


}
