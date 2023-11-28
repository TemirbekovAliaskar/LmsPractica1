package groupsPeaksoft;

public class Generator {

    public static int id = 0;
    public static int studentsId = 0;
    public static int lessonId = 0;



    public static int generateId(){
        return (++id);
    }
    public static int generateIdStudents(){
        return (++studentsId);
    }
    public static int generateLessonId(){
        return (++lessonId);
    }
}
