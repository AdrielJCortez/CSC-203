package equality;
import java.time.LocalTime;

public class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   // TODO: equals and hashCode methods for CourseSection
   public boolean equals(Object other) {
      if (other instanceof CourseSection otherCourse){

          return this.prefix.equals(otherCourse.prefix) &&
              this.number.equals(otherCourse.number) &&
              this.enrollment == otherCourse.enrollment &&
              this.startTime.getHour() == otherCourse.startTime.getHour() &&
              this.startTime.getMinute() == otherCourse.startTime.getMinute() &&
              this.endTime.getHour() == otherCourse.endTime.getHour() &&
              this.endTime.getMinute() == otherCourse.endTime.getMinute();

   }
       return false;
   }
   @Override
   public int hashCode() {
      int result = 17;
      if (prefix == null) {
         result = 3 * result; // + 0
      }
      if (prefix != null) {
         result = 3 * result + prefix.hashCode();
      }
      if (number == null) {
         result = 3 * result;
      }
      if (number != null) {
         result = 3 * result + number.hashCode();
      }
      if (startTime == null) {
         result = 3 * result;
      }
      if (startTime != null) {
         result = 3 * result + startTime.getHour() + startTime.getMinute();
      }
      if (endTime == null) {
         result = 3 * result;
      }
      if (endTime != null) {
         result = 3 * result + endTime.getHour() + endTime.getMinute();
      }
      result = 3 * result + enrollment;

      return result;
}
}
