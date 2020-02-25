public class circularlist {
    private node headNode = new node(Integer.MAX_VALUE); 
    private node firstNode; 
    private node tailNode;  
    private int numPeople;
    private int numSkip;  
    private int safePos;
    private int listSize = 0;    
    
    public circularlist(){}

    public circularlist(int n,int k){
        numPeople = n;
        numSkip   = k;
        josephus();
    }    
   
    public void addPerson(node n){
        if(firstNode == null){            
            firstNode = n;
            tailNode = n;
            headNode.setNext(firstNode);
            listSize++;
        }else{
            tailNode.setNext(n);
            n.setPrevious(tailNode);
            n.setNext(firstNode);
            firstNode.setPrevious(tailNode);
            tailNode = n;
            listSize++;
        }
    }  
   
    public void josephus(){
        for (int i = 0; i < numPeople; i++) {
             addPerson(new node(i+1));
        }  
        node temp = firstNode;  
        node temp2;     
        while (listSize != 1) {
            int i = 1;                           
            while (i != numSkip) {     
                temp2 = temp;           
                temp = temp.getNext();
                i++;
            }
            i = 1;
            System.out.println("Prisoner #" + temp.getPrevious().val + " killed prisoner #" + temp.val);
            deleteNode(temp);            
        }
        // node temp = firstNode;
        // while (listSize != 1) {
        //     System.out.println("Prisoner #" + temp.val + " killed prisoner #" + temp.getNext().val);
        //     deleteNode(temp.getNext());
        //     temp = temp.getNext();
        // }
        System.out.println("The last prisoner standing is #" + firstNode.val);     
    }

    public void deleteNode(node n){
        if (headNode.getNext() == null) {
            System.out.println("This list is empty.");
        }else if (n == tailNode) {
            firstNode.setPrevious(tailNode.getPrevious());
            tailNode.getPrevious().setNext(firstNode);
            n.setNext(null);
            n.setPrevious(null);
            tailNode = n.getPrevious();
            listSize--;
        }else if(n == firstNode){
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
            firstNode = n.getNext();
            n.setNext(null);
            n.setPrevious(null);
            listSize--;
        }else if(n == firstNode && listSize == 1){
            headNode.setNext(null);
            listSize--;
        }else{
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());            
            listSize--;
        }
    }

    public void printList() { 
        int i = 0;
        node temp = firstNode;   
        while(i != listSize) {
            System.out.println(temp.val);
            temp = temp.getNext();
            i++;
        }
    }


}