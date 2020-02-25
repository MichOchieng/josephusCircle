public class doublelinkedlist {
    private node headNode;    
    private int listSize = 0;  
    private linkedlist list1;
    private linkedlist list2;
    

    public doublelinkedlist(linkedlist list1, linkedlist list2){
        this.list1 = list1;
        this.list2 = list2;
    }
    
    public void combine(){
        // Handles edges cases for one of the lists being empty or both being empty
        if (list1.listSize == 0 && list2.listSize == 0) {
            System.out.println("Both linked list entered are empty");
        }else if (list1.listSize > 0 && list2.listSize == 0) {
        // Turns single linked list into double linked list
            headNode = list1.headNode; 
            listSize = list1.listSize;
            connectPrevious(headNode);
        }
        else if (list2.listSize > 0 && list1.listSize == 0) {
        // Turns single linked list into double linked list
            headNode = list2.headNode; 
            listSize = list2.listSize;
            connectPrevious(headNode);               
        }else{
        // Used if both lists have elements
            headNode = list1.headNode; 
            listSize = list1.listSize;            
            mergeLists();
        }             
    }

    public void connectPrevious(node n){
        // Sets cursor to the incoming nodes 'next' value and starts setting previous node pointers
        node cursor = n.getNext();               
        while(cursor != null) {
            cursor.setPrevious(n);
            cursor = cursor.getNext();
        }
    }

    public void mergeLists(){  
    /*
    Uses two cursors to prevent infinite loop and mixing up the next node
    value between the lists
    */     
       node temp = list2.headNode;
       node cursor = list2.headNode;
       while (cursor != null) {   
        cursor = cursor.getNext();                        
        addValue(temp);
        temp = cursor;    
       }        
    }

    public void addValue(node n){        
        if(headNode.val >= n.val){
            n.setNext(headNode);
            headNode.setPrevious(n);
            headNode = n;
            listSize++;            
        }else{
            node temp = headNode;
            while (temp.getNext() != null && n.val > temp.getNext().val) {
                temp = temp.getNext();
            }
            n.setNext(temp.getNext());
            // Stops null pointer exception if temp.next is null
            if (temp.getNext()!=null) {
                temp.getNext().setPrevious(n);
            }
            temp.setNext(n);
            n.setPrevious(temp);
            listSize++;            
        }
    }

    public void printList() {
        node temp = headNode;               
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.getNext();
        }
        
    }


}