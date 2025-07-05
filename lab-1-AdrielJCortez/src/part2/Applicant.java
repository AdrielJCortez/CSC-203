package part2;

import part1.CourseGrade;

import java.util.List;


public class Applicant {
    private final String name;
    private  List<CourseGrade> grades;
    private int numOfInternships;
    private int numReferences;
    private boolean cleanRecord;

    public Applicant(String name, List<CourseGrade> grades, int numOfInternships, int numReferences, boolean cleanRecord) {
        this.name = name;
        this.grades = grades;
        this.numOfInternships = numOfInternships;
        this.numReferences = numReferences;
        this.cleanRecord = cleanRecord;
    }
    public String getName(){
        return name;
    }
    public List<CourseGrade> getGrades() {
        return grades;
    }
    public CourseGrade getGradeFor(String course) {
        for (CourseGrade grade : grades) {
            if (grade.getCourseName().equals(course)){
                return grade;
            }
        }
        return null;
    }
    public  int getNumOfInternships() {
        return numOfInternships;
    }
    public int getReferences() {
        return numReferences;
    }
    public boolean getRecord() {
        return cleanRecord;
    }
}
