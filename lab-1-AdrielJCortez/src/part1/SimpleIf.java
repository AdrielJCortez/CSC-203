package part1;

import part2.Applicant;

import java.util.List;

public class SimpleIf {

  // I am making some changes in class.

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than 85.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    /*
     * TO DO: Write an if statement to determine if the avg is larger than the threshold and
     * return true if so, false otherwise
     */
    if (avg > threshold) {
      return true;
    }

    return false; // A bit pessimistic!

  }

  // This Applicant function checks multiple things to be considered, such as having a grade average over 79, takes in
  // account of internships, takes in account of References, and checks if the person has a clean record
  public static boolean analyzeApplicant2(Applicant applicant) {
    if (applicant.getRecord()) {
      List<CourseGrade> grades = applicant.getGrades();
      int total = 0;
      for (CourseGrade grade : grades) {
        total = total + grade.getScore();
      }
      double avg = (double)total /grades.size(); // after finding the average we check the average for the applicant
      if (avg > 79) {
        return true;
      }
      else if (applicant.getNumOfInternships() > 3) {  // check if the number of internships the applicant has is greater than 3 because work experience is important
        return true;
      }
      else return applicant.getReferences() > 5;  // check if the applicant has more than 5 references
    }
    else {
      return false;
    }
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    /*
     * TO DO: Write an if statement to determine which average is larger and return
     * that value.
     */
    // if avg1 is greater than avg2
    if (avg1 > avg2) {
      return avg1;
    }
    else { // otherwise avg2 is greater
      return avg2;
    }
  }
}
