public class Lab00
{
   public static void main(String[] args) {
      // declaring and initializing some variables
      int x = 5;
      String y = "hello";
      double z = 9.8;

      // printing the variables
      System.out.println("x: " + x + ", " + "y: " + y + ", " + "z: " + z);

      // an array

      int[] nums = {3, 6, -1, 2};
      for (int num : nums) { // for each num of nums list
         System.out.println(num);
      }

      // calling a function
      int numFound = char_count(y, 'l'); // this will call to the function below
      System.out.println("Found: " + numFound);

      // a counting for loop starting at 1 and ending before 11
      for (int i = 1; i < 11; i++) {
         System.out.print(i + " ");
      }

      System.out.println();
      // clarify that println will print on a new line and print will continue to print on the same line

   }

    public static int char_count(String s, char c) {
      int count = 0; // initial count of characters found
      for (char ch : s.toCharArray()) { // makes the string into an Array of chars so it could be iterated through
         if (c == ch) {
            count++;
         }
      }
      return count;
    }
}

