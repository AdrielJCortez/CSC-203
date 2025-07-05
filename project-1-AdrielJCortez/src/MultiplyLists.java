public class MultiplyLists {
    public static LinkedList MultiplyNums(LinkedList L1, LinkedList L2) {
        // first step -> second step -> etc
        // Example:  127
        //            52
        //          254 first row
        //        +6350
        if (L1.getHead().getData() == 0 || L2.getHead().getData() == 0) {
            Node zeroNode = new Node(0, null);
            return new LinkedList(zeroNode, 1, zeroNode);
        }
        Node temp2 = L2.getHead();
        Node newN = new Node(0, null);
        LinkedList currentSum = new LinkedList(newN, 1, newN);
        LinkedList ListPlus = new LinkedList(null, 0, null); // this will be the list to keep on adding
        int zeroCounter = 0; // To determine how many zeros have to be added to the next step of multiplication such
        // as adding the zero on the second line in the example

        while (temp2 != null) {
            int carry = 0;
            Node temp = L1.getHead();
            for (int i = 0; i < zeroCounter; i ++){ // add needed zeros
                ListPlus.addEnd(0);
            }
            while (temp != null) { // step 1) going to iterate through L1 and multiply one piece of L2 data by each L1 data
                int num = temp.getData() * temp2.getData() + carry;
                carry = num / 10;
                int data = num % 10;
                ListPlus.addEnd(data);
                temp = temp.getNext();
            }
                if (carry > 0){ // need to add the carry to the end
                    ListPlus.addEnd(carry);
                }

            currentSum = AddNums.AddTwoLists(currentSum, ListPlus); // updates current value
            ListPlus = new LinkedList(null, 0, null); // reset the linked list to add
            zeroCounter = zeroCounter + 1;
            temp2 = temp2.getNext(); // step 2) shift the L2 data to get multiplied by each L1 data
        }
        return currentSum;
    }
}
