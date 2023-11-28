import DataBase.DataBase;
import role.Admin;
import services.AdminService;
import services.GroupService;
import services.LessonService;
import services.StudentService;
import services.impl.Adminimpl;
import services.impl.Groupsimpl;
import services.impl.Lessonimpl;
import services.impl.Studentsimpl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("test1");



        innerLoop:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            time();
            System.out.println("""
                     1. SIGN UP 📝
                     2. CREATE ACCOUNT 🆕
                     3. EXIT ❌
                    """);
            switch (scanner.nextLine()) {
                case "1" -> {
                    if (adminService.login(admin) != null) {
                        boolean isTrue = true;
                        while (isTrue) {
                            method();
                            switch (scanner.nextLine()) {
                                case "0" -> {
                                    isTrue = false;
                                }
                                case "1" -> DataBase.groups = groupService.addGroup();
                                case "2" -> {
                                    groupService.getGroup();
                                }
                                case "3" -> {
                                    System.out.println("Result : " + groupService.updateGroup());
                                }
                                case "4" -> {
                                    System.out.println(Arrays.toString(groupService.getAllGroup()));
                                }
                                case "5" -> {
                                    studentService.addNewStudents();
                                }
                                case "6" -> {
                                    studentService.updateStudents();
                                }
                                case "7" -> studentService.findStudentsByName();
                                case "8" -> studentService.getAllStudentsGroupByName();
                                case "9" -> studentService.getAllStudentsLessonsName();
                                case "10" -> studentService.deleteStudentByEmail();
                                case "11" -> lessonService.addNewLessontoGroup();
                                case "12" -> lessonService.getLessonByName();
                                case "13" -> lessonService.getAllLessonGroupByName();
                                case "14" -> lessonService.deleteLessonById();
                                  case "15"->groupService.deleteGroupByName();

                            }
                        }
                    }
                }
                case "2" -> admin = adminService.addLogin(admin);
                case "3" -> {break innerLoop;}
            }
        }


    }

    public static void method() {
        System.out.println("""
                                
                   1. ADD GROUP 📚
                   2. GET GROUP 🧑‍🎓
                   3. UPDATE 🔄
                   4. GET ALL 🌐
                   5. ADD STUDENTS 👫
                   6. UPDATE STUDENTS ✏️
                   7. FIND STUDENTS BY NAME 🔍
                   8. GET ALL STUDENTS GROUP BY NAME 🧑‍🤝‍🧑
                   9. GET ALL STUDENTS LESSON 🎓
                   10. DELETE EMAIL 📭
                   11. ADD NEW LESSON TO GROUP ➕
                   12. GET LESSON BY NAME 📖
                   13. GET ALL LESSON BY GROUP NAME 🧑‍🏫
                   14. DELETE LESSON BY ID ❌f
                   15. DELETE GROUP BY NAME ❌
                                
                """);
    }

    public static void time(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter coorect = DateTimeFormatter.ofPattern("HH:mm");
        int timeday = zonedDateTime.getHour();

        if (timeday > 6 && timeday < 10){
            System.out.println("Good morning ! " + coorect.format(zonedDateTime));
        } else if (timeday > 10 && timeday < 17) {
            System.out.println("Good day !" + coorect.format(zonedDateTime));
        } else if (timeday >17 && timeday < 23) {
            System.out.println("Good evening !" + coorect.format(zonedDateTime));
        }else System.out.println("Good night ");
    }
}