package equality;

import java.util.List;
import java.util.Objects;

public class Student
{
   private String name;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String name, final int age,
      final List<CourseSection> currentCourses)
   {
      this.name = name;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   // TODO: equals and hashCode methods for Student
   public boolean equals(Student otherStudent) {
      if (otherStudent == null) {
         return false;
      }
      return this.name.equals(otherStudent.name) &&
              this.age == otherStudent.age &&
              this.currentCourses.equals(otherStudent.currentCourses);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, age, currentCourses);
   }
}
