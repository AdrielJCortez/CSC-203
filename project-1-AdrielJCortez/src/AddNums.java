public class AddNums {
    public static LinkedList AddTwoLists(LinkedList L1, LinkedList L2) {
        // both nodes head will be the one's place
        Node currentOne = L1.getHead();
        Node currentTwo = L2.getHead();
        int carry = 0;
        LinkedList result = new LinkedList(null, 0, null);

        while (true) {
            int data;
            if (currentOne != null && currentTwo != null) { // check that both the nodes have digits
                data = currentOne.getData() + currentTwo.getData() + carry; // add the two nodes data and the carry
                currentOne = currentOne.getNext();
                currentTwo = currentTwo.getNext();
                }

            else if (currentOne != null){
                data = currentOne.getData() + carry; // add NodeOne and the carry
                currentOne = currentOne.getNext();
            }

            else if (currentTwo != null){
                data = currentTwo.getData() + carry; // add NodeTwo and the carry
                currentTwo = currentTwo.getNext();

            }
            else {
                break;

            }
            carry = data/10; // if data is 10 or over will become 1
            result.addEnd(data%10);


            }
        if (carry > 0) {
            result.addEnd(carry);
        }
        return result;
    }
    }
