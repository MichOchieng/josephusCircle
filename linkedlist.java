public class linkedlist {
    public node headNode;
    public node tailNode;
    public int listSize = 0;   
    
    public void addValue(node n){
        if(headNode == null || headNode.val >= n.val){
            n.setNext(headNode);
            headNode = n;
            listSize++;
        }else{
            node temp = headNode;
            while (temp.getNext() != null && n.val > temp.getNext().val) {
                temp = temp.getNext();
            }
            n.setNext(temp.getNext());
            temp.setNext(n);
            listSize++;
        }
    }

    public void printList() {
        node temp = headNode;               
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.getNext();
        }
        System.out.println("There are " + listSize + " elements in this list.");
    }

    public int getFirst() {
        return headNode.val;
    }

    public int getLast() {
        return tailNode.val;
    }
}