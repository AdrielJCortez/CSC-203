import java.util.Arrays;

// removes leading zeros in each "number" before operation
public class RemoveLeadingZeros {
    public static String removeZeros (String str) {
        char [] chars = str.toCharArray();
        int counter = 0;
        if (str.length() > 1) {
            for (char current : chars) {
                if (current == '0') {
                    counter ++;
                }
                else {
                    break;
                }
            }
        }
        char [] newArray = Arrays.copyOfRange(chars, counter, (str.length()));
        StringBuilder sb = new StringBuilder();
        for (char current : newArray) {
            sb.append(current);
        }
        return sb.toString();
    }
}
