package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamSeating {
    private List<Classroom> classrooms;
    private Map<Classroom, List<Exam>> examSchedule;

    public void ExamSeating() {
        this.classrooms = new ArrayList<>();
        this.examSchedule = new HashMap<>();
    }

    public void scheduleExam(Classroom classroom, Exam exam) {
        if (!examSchedule.containsKey(classroom)) {
            examSchedule.put(classroom, new ArrayList<>());
        }
        examSchedule.get(classroom).add(exam);
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public void assignStudentsToClassrooms(List<Student> students) {
        int studentIndex = 0;
        for (Classroom classroom : classrooms) {
            while (studentIndex < students.size() && classroom.getStudents().size() < classroom.getCapacity()) {
                classroom.addStudent(students.get(studentIndex));
                studentIndex++;
            }
        }
    }

    public void printSeatingArrangement() {
        for (Classroom classroom : classrooms) {
            System.out.println("Classroom: " + classroom.getRoomName() + " (Capacity: " + classroom.getCapacity() + ")");
            System.out.println("Exams Schedule:");
            for (Exam exam : examSchedule.get(classroom)) {
                System.out.println("- " + exam.getExamName() + " (Start Time: " + exam.getStartTime() + "\t End Time: " + exam.getEndTime() + ") ");
            }
            int count = 0;
            for (Student student : classroom.getStudents()) {
                System.out.printf(" %10s (ID: %5s) \t", student.getName(), student.getStudentId());
                count++;
                if (count % 4 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
