public class Node {
    private final int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public int getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public void updateNext(Node next){
        this.next = next;
    }
}
