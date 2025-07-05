package comparators;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{
   private static final Applicant[] applicants = new Applicant[] {
           new Applicant("Aakash", Arrays.asList(
                   new CourseGrade("Intro to CS", 89),
                   new CourseGrade("Data Structures", 86),
                   new CourseGrade("Operating Systems", 89),
                   new CourseGrade("Non-CS", 92)
           ), 5),
           new Applicant("Sarah", Arrays.asList(
                   new CourseGrade("Intro to CS", 96),
                   new CourseGrade("Data Structures", 94),
                   new CourseGrade("Operating Systems", 86),
                   new CourseGrade("Non-CS", 90)
           ), 5),
           new Applicant("Moe", Arrays.asList(
                   new CourseGrade("Intro to CS", 86),
                   new CourseGrade("Data Structures", 92),
                   new CourseGrade("Operating Systems", 93),
                   new CourseGrade("Non-CS", 89)
           ), 10),
           new Applicant("Sue", Arrays.asList(
                   new CourseGrade("Intro to CS", 82),
                   new CourseGrade("Data Structures", 97),
                   new CourseGrade("Operating Systems", 83),
                   new CourseGrade("Non-CS", 89)
           ), 6),
           new Applicant("Moe", Arrays.asList(
                   new CourseGrade("Intro to CS", 94),
                   new CourseGrade("Data Structures", 87),
                   new CourseGrade("Operating Systems", 73),
                   new CourseGrade("Non-CS", 84)
           ), 5)
   };

   @Test
   public void testNameComparator() {
   }

   @Test
   public void testLambdaAverageComparator()
   {
   }

   @Test
   public void testYearsOfExperienceExtractorComparator()
   {
   }

   @Test
   public void testComposedComparator()
   {
   }

   @Test
   public void testThenComparing()
   {
   }


   @Test
   public void runSort()
   {
      List<Applicant> applicantList = new ArrayList<>(Arrays.asList(applicants));
      List<Applicant> expectedList = Arrays.asList(
              new Applicant("Aakash", Arrays.asList(
                      new CourseGrade("Intro to CS", 89),
                      new CourseGrade("Data Structures", 86),
                      new CourseGrade("Operating Systems", 89),
                      new CourseGrade("Non-CS", 92)
              ), 5),
              new Applicant("Moe", Arrays.asList(
                      new CourseGrade("Intro to CS", 94),
                      new CourseGrade("Data Structures", 87),
                      new CourseGrade("Operating Systems", 73),
                      new CourseGrade("Non-CS", 84)
              ), 5),
              new Applicant("Moe", Arrays.asList(
                      new CourseGrade("Intro to CS", 86),
                      new CourseGrade("Data Structures", 92),
                      new CourseGrade("Operating Systems", 93),
                      new CourseGrade("Non-CS", 89)
              ), 10),
              new Applicant("Sarah", Arrays.asList(
                      new CourseGrade("Intro to CS", 96),
                      new CourseGrade("Data Structures", 94),
                      new CourseGrade("Operating Systems", 86),
                      new CourseGrade("Non-CS", 90)
              ), 5),
              new Applicant("Sue", Arrays.asList(
                      new CourseGrade("Intro to CS", 82),
                      new CourseGrade("Data Structures", 97),
                      new CourseGrade("Operating Systems", 83),
                      new CourseGrade("Non-CS", 89)
              ), 6)
      );

      applicantList.sort(
              null // TODO: Comparator goes here
      );

      assertEquals(expectedList, applicantList);
   }
}
