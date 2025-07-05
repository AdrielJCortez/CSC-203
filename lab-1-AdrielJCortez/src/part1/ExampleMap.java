package part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> highScoringStudents = new LinkedList<>(); // This is the list that we are returning

    /*
     * Build a list of the names of applicants who have scores strictly greater than
     * the given threshold.
     */
    for (Map.Entry<String, List<CourseGrade>> currentStudent : scoresByApplicantName.entrySet()) {
      List<CourseGrade> scores = currentStudent.getValue(); // This is the current students list of scores
      boolean scoresAboveThreshHold = true; // This will change if a course score falls below the thresh hold
      for (CourseGrade Course : scores) { // for each course grade in a students scores list
        int CurrentcourseScore = Course.getScore(); // iterate every score and make sure each score passes the thresh hold
        if (CurrentcourseScore < scoreThreshold) {
          scoresAboveThreshHold = false; //  a score was detected to be below the thresh Hold
          break;
        }
      }
      if (scoresAboveThreshHold) { // if all scores were seemed to be above the thresh hold
        highScoringStudents.add(currentStudent.getKey());
      }
    }
    return highScoringStudents;
  }
}

