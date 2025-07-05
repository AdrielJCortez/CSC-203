import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine().trim();
                // Process each line of the input file, handling blank lines and spacing differences
                if (!line.isEmpty()) {
                    String[] pieces = line.split("\\s+");
                    // Remove leading zeros directly
                    String lefthandSide = RemoveLeadingZeros.removeZeros(pieces[0]);
                    String Operator = pieces[1];
                    String rightHandSide = RemoveLeadingZeros.removeZeros(pieces[2]);

                    LinkedList L1 = new LinkedList(null, 0, null);
                    LinkedList L2 = new LinkedList(null, 0, null);
                    L1.AddStringToList(lefthandSide);
                    L2.AddStringToList(rightHandSide);

                    if (Operator.equals("+")) {
                        LinkedList L3 = AddNums.AddTwoLists(L1, L2);
                        System.out.println(lefthandSide + " " + Operator + " " + rightHandSide + " = " + L3.ReturnString());
                    }
                    if (Operator.equals("*")) {
                        LinkedList L3 = MultiplyLists.MultiplyNums(L1, L2);
                        System.out.println(lefthandSide + " " + Operator + " " + rightHandSide + " = " + L3.ReturnString());
                    }
                    if (Operator.equals("^")) {
                        LinkedList L3 = Exponents.power(L1, L2);
                        System.out.println(lefthandSide + " " + Operator + " " + rightHandSide + " = " + L3.ReturnString());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}