package services.impl;

import DataBase.DataBase;
import groupsPeaksoft.Generator;
import groupsPeaksoft.Students;
import services.StudentService;

import java.util.Arrays;
import java.util.Scanner;

public class Studentsimpl implements StudentService {





    @Override
    public void addNewStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("group wrte: ");
        String name = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equalsIgnoreCase(name)){
                Students students = new Students();
                System.out.println("Name : ");
                String name1 = (scanner.nextLine());
                System.out.println("LastName : ");
                String lastName = (scanner.nextLine());
                while (true){
                    System.out.println("Email :");
                    String email = (scanner.nextLine());
                    if (emthod(email) == 0 && email.endsWith("@gmail.com")){
                        students.setEmail(email);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Password :");
                    String pass = (scanner.nextLine());
                    if (pass.length() > 7){
                        students.setPassword(pass);
                        break;
                    }
                }

                System.out.println("Gender :");
                String gender = (scanner.nextLine());

                students.setFirstName(name1);
                students.setLastName(lastName);

                students.setGender(gender);
                students.setId(Generator.generateIdStudents());
                DataBase.groups[i].students = Arrays.copyOf(DataBase.groups[i].getStudents(), DataBase.groups[i].getStudents().length +1);
                DataBase.groups[i].students[DataBase.groups[i].students.length -1] = students;

            }
        }
    }

    @Override
    public void updateStudents() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Email write : ");
            String word = scanner.nextLine();

            for (int i = 0; i < DataBase.groups.length; i++) {
                for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                    if (DataBase.groups[i].students[j].getEmail().equalsIgnoreCase(word)) {
                        System.out.println("Write new name : ");
                        DataBase.groups[i].students[j].setFirstName(scanner.nextLine());
                        System.out.println("successful !");
                    }
                }

            }
        }


    @Override
    public void findStudentsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name :");
        String name = scanner.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (DataBase.groups[i].students[j].getFirstName().equalsIgnoreCase(name)){
                    System.out.println(DataBase.groups[i].students[j]);
                }
            }
        }

    }

    @Override
    public void getAllStudentsGroupByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write group name : ");
        String groupName = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equalsIgnoreCase(groupName)){
                System.out.println(Arrays.toString(DataBase.groups[i].getStudents()));
            }
        }

    }

    @Override
    public void getAllStudentsLessonsName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name Lesson");
        String lessonName = scanner.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int l = 0; l < DataBase.groups[i].lessons.length; l++) {
                if (DataBase.groups[i].lessons[l].getLessonName().equals(lessonName)){
                    for (int k = 0; k < DataBase.groups[i].students.length; k++) {
                        System.out.println(DataBase.groups[i].students[k]);
                    }

                    }
                }
            }
        }



    @Override
    public void deleteStudentByEmail() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write email  :" );
        String word = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = i; j < DataBase.groups[i].students.length - 1; j++) {
                if (DataBase.groups[i].students[j].getEmail().equalsIgnoreCase(word)){
                    DataBase.groups[i].students[j] = DataBase.groups[i].students[j+1];
                }
            }
            DataBase.groups[i].setStudents(Arrays.copyOf(DataBase.groups[i].students, DataBase.groups[i].students.length - 1 ));
        }
    }


    private static int emthod(String email){
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (DataBase.groups[i].students[j].getEmail().equals(email)){
                    return 1;
                }
            }
        }
        return 0;
    }
}
