package services;

import groupsPeaksoft.Students;

public interface StudentService {

    void addNewStudents();
    void updateStudents();
    void findStudentsByName();
    void getAllStudentsGroupByName();
    void getAllStudentsLessonsName();
    void deleteStudentByEmail();

}
