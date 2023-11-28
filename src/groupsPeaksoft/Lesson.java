package groupsPeaksoft;

public class Lesson {
    private int id;
    private String lessonName;
    private String taskDescription;

    public Lesson() {
    }

    public Lesson(int id, String lessonName, String taskDescription) {
        this.id = id;
        this.lessonName = lessonName;
        this.taskDescription = taskDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "📖 Lesson Information 📝\n" +
                "ID: " + id +
                "\nLesson Name: " + lessonName +
                "\nTask Description: " + taskDescription;
    }
}
