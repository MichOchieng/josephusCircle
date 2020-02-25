public class main {

    public static void main(String[] args) {
        linkedlist list1 = new linkedlist();

        node a = new node(12);
        node b = new node(1);
        node c = new node(100);       

        linkedlist list2 = new linkedlist();

        node d = new node(13);
        node e = new node(2);
        node f = new node(101);  

        // list1.addValue(a);
        // list1.addValue(b);
        // list1.addValue(c);
        
        // list2.addValue(d);
        // list2.addValue(e);
        // list2.addValue(f);
        
        // doublelinkedlist dlist = new doublelinkedlist(list1,list2);
        // dlist.combine();        
        // dlist.printList(); 

        circularlist clist = new circularlist(41,3);        
                
    }
}