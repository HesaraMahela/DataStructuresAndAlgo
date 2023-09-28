public class stack {
    int[] arr;
    int top;

    public static void main(String[] args){
        stack mystack = new stack(5);
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        mystack.pop();
        mystack.push(5);
        mystack.print();
    }
    stack(int len){
        arr =new int[len];
        top =-1;
    }
    public void push(int data){
        if(top<arr.length){
            arr[++top]=data;
        }else{
            //throw IndexOutOfBoundsException;
        }

    }

    public int pop(){
        int temp = arr[top--];
            arr[top+1] = 0;
        return temp;
    }
    public int peek(){
        int temp = arr[top];
        return temp;
    }

    public void print(){
        for(int i=0; i<arr.length ;i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
