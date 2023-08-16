package Application;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int roomId;
    private String roomName;
    private int capacity;
    private List<Student> students;

    public Classroom(int roomId, String roomName, int capacity) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            return true;
        }
        return false;
    }
}
