  // Uncomment this file by selecting all the text (Cmd/Ctrl A) and
  // uncommenting all the selected text (Cmd/Ctrl /).
  package part2;

  import org.junit.jupiter.api.Test;
  import part1.CourseGrade;
  import part1.SimpleIf;

  import java.lang.reflect.Method;
  import java.lang.reflect.Modifier;
  import java.util.stream.Collectors;
  import java.util.Arrays;
  import java.util.List;

  import static org.junit.jupiter.api.Assertions.*;

  public class TestCases
  {
     /*
      * This test is just to get you started.
      */
     @Test
     public void testGetName()
     {
        // This will not compile until you implement the Applicant class
        List<CourseGrade> grades = Arrays.asList(
           new CourseGrade("Intro to CS", 100),
           new CourseGrade("Data Structures", 95),
           new CourseGrade("Algorithms", 91),
           new CourseGrade("Computer Organization", 91),
           new CourseGrade("Operating Systems", 75),
           new CourseGrade("Non-CS", 83)
        );

        Applicant testApplicant = new Applicant("Aakash", grades, 6, 3, true);
        assertEquals("Aakash", testApplicant.getName());

     }
     @Test
     public void testAnalyzeApplicant2avg()
     {
         List<CourseGrade> grades =  Arrays.asList(
                 new CourseGrade("Intro to CS", 100),
                 new CourseGrade("Data Structures", 95),
                 new CourseGrade("Algorithms", 91),
                 new CourseGrade("Computer Organization", 91),
                 new CourseGrade("Operating Systems", 75),
                 new CourseGrade("Non-CS", 83)
         );
         Applicant testApplicant = new Applicant("Aakash", grades, 0, 0, true);
         assertEquals("Aakash", testApplicant.getName());
         assertTrue(SimpleIf.analyzeApplicant2(testApplicant));
     }

      @Test
      public void testAnalyzeApplicant2Internships() {
          List<CourseGrade> grades = Arrays.asList(
                  new CourseGrade("Intro to CS", 79),
                  new CourseGrade("Data Structures", 76),
                  new CourseGrade("Algorithms", 70),
                  new CourseGrade("Computer Organization", 71),
                  new CourseGrade("Operating Systems", 75),
                  new CourseGrade("Non-CS", 78)
          );
          Applicant testApplicant = new Applicant("Aakash", grades, 6, 0, true);
          assertEquals("Aakash", testApplicant.getName());
          assertTrue(SimpleIf.analyzeApplicant2(testApplicant));
      }

      @Test
      public void testAnalyzeApplicant2References() {
          List<CourseGrade> grades = Arrays.asList(
                  new CourseGrade("Intro to CS", 79),
                  new CourseGrade("Data Structures", 76),
                  new CourseGrade("Algorithms", 70),
                  new CourseGrade("Computer Organization", 71),
                  new CourseGrade("Operating Systems", 75),
                  new CourseGrade("Non-CS", 78)
          );
          Applicant testApplicant = new Applicant("Aakash", grades, 0, 6, true);
          assertEquals("Aakash", testApplicant.getName());
          assertTrue(SimpleIf.analyzeApplicant2(testApplicant));
      }
      @Test
      public void testAnalyzeApplicant2notClean() {
          List<CourseGrade> grades = Arrays.asList(
                  new CourseGrade("Intro to CS", 79),
                  new CourseGrade("Data Structures", 76),
                  new CourseGrade("Algorithms", 70),
                  new CourseGrade("Computer Organization", 71),
                  new CourseGrade("Operating Systems", 75),
                  new CourseGrade("Non-CS", 78)
          );
          Applicant testApplicant = new Applicant("Aakash", grades, 0, 0, false);
          assertEquals("Aakash", testApplicant.getName());
          assertFalse(SimpleIf.analyzeApplicant2(testApplicant));
      }
      @Test
      public void testAnalyzeApplicant2InternshipsGoodStatsButNotClean() {
          List<CourseGrade> grades = Arrays.asList(
                  new CourseGrade("Intro to CS", 99),
                  new CourseGrade("Data Structures", 96),
                  new CourseGrade("Algorithms", 90),
                  new CourseGrade("Computer Organization", 91),
                  new CourseGrade("Operating Systems", 95),
                  new CourseGrade("Non-CS", 98)
          );
          Applicant testApplicant = new Applicant("Aakash", grades, 6, 6, false);
          assertEquals("Aakash", testApplicant.getName());
          assertFalse(SimpleIf.analyzeApplicant2(testApplicant));
      }

     /*
      * The tests below here are to verify the basic requirements regarding
      * the "design" of your class.  These are to remain unchanged.
      */
     @Test
     public void testImplSpecifics()
        throws NoSuchMethodException
     {
        final List<String> expectedMethodNames = Arrays.asList(
           "getName",
           "getGrades",
           "getGradeFor"
        );

        final List<Class> expectedMethodReturns = Arrays.asList(
           String.class,
           List.class,
           CourseGrade.class
        );

        final List<Class[]> expectedMethodParameters = Arrays.asList(
           new Class[0],
           new Class[0],
           new Class[] { String.class }
           );

        verifyImplSpecifics(Applicant.class, expectedMethodNames,
           expectedMethodReturns, expectedMethodParameters);
     }

     private static void verifyImplSpecifics(
        final Class<?> clazz,
        final List<String> expectedMethodNames,
        final List<Class> expectedMethodReturns,
        final List<Class[]> expectedMethodParameters)
        throws NoSuchMethodException
     {
        assertEquals(0, Applicant.class.getFields().length,
                "Unexpected number of public fields");

        final List<Method> publicMethods = Arrays.stream(
           clazz.getDeclaredMethods())
              .filter(m -> Modifier.isPublic(m.getModifiers()))
              .collect(Collectors.toList());

        assertTrue(expectedMethodNames.size() <= publicMethods.size(),
                "Unexpected number of public methods");

        assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
                "Invalid test configuration");
        assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
                "Invalid test configuration");

        for (int i = 0; i < expectedMethodNames.size(); i++)
        {
           Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
              expectedMethodParameters.get(i));
           assertEquals(expectedMethodReturns.get(i), method.getReturnType());
        }
     }

  }


