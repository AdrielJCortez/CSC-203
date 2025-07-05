public class LinkedList {
    private Node head;
    private int size;
    private Node tail;

    public LinkedList(Node head, int size, Node tail) {
        this.head = head;
        this.size = size;
        this.tail = tail;

    }

    public Node getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public void addStart(int data) { //this is to put the list in the correct reverse order (adding at the start)
        if (this.head == null) {
            Node N1 = new Node(data, null);
            this.head = N1;
            this.tail = N1;
        } else {
            Node tempNode = this.head; // This will be the nodes head next
            this.head = new Node(data, tempNode);
        }
        this.size++;
    }

    public void addEnd(int data) { // adding at the end of the list
        Node N1 = new Node(data, null);
        if (this.head == null) {
            this.head = N1;
        } else {
            Node currentN = this.tail;
            currentN.updateNext(N1);
        }
        this.tail = N1;
        this.size++;
    }

    public void AddStringToList(String data) {
        char[] numListAsChar = data.toCharArray();
        for (char c : numListAsChar) { // 345
            int dataToStore = Integer.parseInt(String.valueOf(c));
            this.addStart(dataToStore); // add the node to the linked list, 345 will become 5 -> 4 -> 3 in the linked list
        }

    }

    public int[] getListContents() { // This is just for testing
        Node currentNode = this.head;
        int[] returnArray = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            returnArray[i] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return returnArray;
    }

    public String ReturnString() { // returns in user reader
        if (this.head == null) {
            return null;
        }
        Node currentNode = this.head;
        StringBuilder myString = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            myString.append(Character.forDigit(currentNode.getData(), 10));
            currentNode = currentNode.getNext();
        }
        return myString.reverse().toString();
    }

    public int returnAsInt() {
        String asString = this.ReturnString();
        return Integer.parseInt(asString);
    }
}