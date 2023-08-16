package Application;

public class Exam {
    private int examId;
    private String examName;

    public Exam(int examId, String examName) {
        this.examId = examId;
        this.examName = examName;
    }

    public int getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public String getStartTime() {
        return null;
    }

    public String getEndTime() {
        return null;
    }
}

