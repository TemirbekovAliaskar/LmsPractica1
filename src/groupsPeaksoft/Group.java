package groupsPeaksoft;

import java.util.Arrays;

public class Group {

    private int id;
    private String name;
    private String description;
    public Students[] students = new Students[0];
    public Lesson[] lessons = new Lesson[0];

    public Group() {
    }

    ;

    public Group(int id, String name, String description, Students[] students, Lesson[] lessons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = students;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Students[] getStudents() {
        return students;
    }

    public void setStudents(Students[] students) {
        this.students = students;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }





    @Override
    public String toString() {
        return "👥 Group Information\n" +
                "ID: " + id +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nStudents: " + Arrays.toString(students) +
                "\nLessons: " + Arrays.toString(lessons);
    }

}
