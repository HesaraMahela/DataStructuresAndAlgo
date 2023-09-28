// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//
//        Linkedlist list = new Linkedlist();
//        list.insertLast(11);
//        list.insertLast(22);
//        list.insertLast(33);
//        list.insertLast(44);
//
//        System.out.println(list.toString());
//        list.deleteByIndex(3);
//        System.out.println(list.toString());
//        list.insertByIndex(55,1);
//        System.out.println(list.toString());
//        list.deleteByData(22);
//        System.out.println(list.toString());


        CircularLinedList CList = new CircularLinedList();
        CList.insert(1);
        CList.insert(2);
        CList.insert(3);
        CList.insert(4);
        CList.insert(5);
        System.out.println(CList.toString());
        //System.out.println(CList.head.next.next.data);
        CList.insert(5,66); // TODO: have to fix the looping of toString function when inserted into 0
        System.out.println(CList.toString());
        CList.deleteByData(66);
        System.out.println(CList.toString());
        System.out.println(CList.head.data);

    }
}