public class node {

    public node next;
    public node previous;
    public int val;

    public node(int val){
        this.val = val;
    }

    public void setNext(node node){
        this.next = node;
    }

    public node getNext(){
        return next;
    }

    public node getPrevious(){
        return previous;
    }

    public void setPrevious(node node){
        this.previous = node;
    }
    
}