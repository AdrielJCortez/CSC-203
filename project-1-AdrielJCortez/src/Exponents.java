public class Exponents {
    public static LinkedList power (LinkedList base, LinkedList exponentAsList) {
        int exponent = exponentAsList.returnAsInt();
        // could add a check here for if exponent is negative

        Node newN = new Node(1, null);
        LinkedList result = new LinkedList(newN, 1, newN); // result starts at value 1
        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return result;
        }
        LinkedList currentBase = base; // set as temp so we don't change the initial base value
        while (exponent > 0) {
            if ((exponent % 2) != 0) { // check if the number is odd
                result = MultiplyLists.MultiplyNums(currentBase, result);// update the result value when the exponent is odd
            }
            currentBase = MultiplyLists.MultiplyNums(currentBase, currentBase);
            exponent = exponent / 2; // divide the exponent by 2, will subtract 1 when its odd (ex: 5/2 = 2) 12^5 -> 12^2
        }
        return result;
    }
}
