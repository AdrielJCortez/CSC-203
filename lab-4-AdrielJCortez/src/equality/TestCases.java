package equality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalTime;

import org.junit.Test;

public class TestCases
{
   @Test
   public void testExercise1()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertTrue(one.equals(two));
      assertTrue(two.equals(one));
   }

   @Test
   public void testExercise2()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(1, 10), LocalTime.of(2, 0));

      assertFalse(one.equals(two));
      assertFalse(two.equals(one));
   }

   @Test
   public void testExercise3()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      assertEquals(one.hashCode(), two.hashCode());
   }

   @Test
   public void testExercise4()
   {
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
         LocalTime.of(9, 10), LocalTime.of(10, 0));

      assertNotEquals(one.hashCode(), two.hashCode());
   }

   // TODO: Write test cases for equals and hashCode in Student.
   //    What would convince you that those methods are working as expected?

   @Test
   public void testStudent1() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      ArrayList<CourseSection> courseSections = new ArrayList<>();
      courseSections.add(one);
      courseSections.add(two);

      final Student student1 = new Student("Adriel", 19, courseSections);
      final Student student2 = new Student("Adriel", 19, courseSections);

      assertTrue(student1.equals(student2));
      assertTrue(student2.equals(student1));
   }

   @Test
   public void testStudent2() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      ArrayList<CourseSection> courseSections = new ArrayList<>();
      courseSections.add(one);
      courseSections.add(two);
      final Student student1 = new Student("Joe", 22, courseSections);
      final Student student2 = new Student("Adriel", 19, courseSections);

      assertFalse(student1.equals(student2));
      assertFalse(student2.equals(student1));

   }

   @Test
   public void testStudent3() {
      final CourseSection one = new CourseSection("CSC", "203", 35,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      final CourseSection two = new CourseSection("CSC", "203", 34,
              LocalTime.of(9, 10), LocalTime.of(10, 0));
      ArrayList<CourseSection> courseSections = new ArrayList<>();
      courseSections.add(one);
      courseSections.add(two);
      final Student student1 = new Student("Adriel", 19, courseSections);
      final Student student2 = new Student("Adriel", 19, courseSections);

      assertEquals(student1.hashCode(), student2.hashCode());

   }
}
