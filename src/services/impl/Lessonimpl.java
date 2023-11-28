package services.impl;

import DataBase.DataBase;
import groupsPeaksoft.Generator;
import groupsPeaksoft.Lesson;
import services.LessonService;

import java.util.Arrays;
import java.util.Scanner;

public class Lessonimpl  implements LessonService {
    @Override
    public void addNewLessontoGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Group name :");
        String nameGroup = scanner.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equalsIgnoreCase(nameGroup)){
                Lesson lesson = new Lesson();
                System.out.println("Write lesson name : ");
                lesson.setLessonName(scanner.nextLine());
                System.out.println("Write description : ");
                lesson.setTaskDescription(scanner.nextLine());

                lesson.setId(Generator.generateLessonId());
                DataBase.groups[i].lessons = Arrays.copyOf(DataBase.groups[i].getLessons(),DataBase.groups[i].getLessons().length + 1);
                DataBase.groups[i].lessons[DataBase.groups[i].lessons.length - 1] = lesson;
            }
        }
    }

    @Override
    public void getLessonByName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name lesson : ");
        String lesson = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].lessons.length; j++) {
                if (DataBase.groups[i].lessons[j].getLessonName().equalsIgnoreCase(lesson)){
                    System.out.println(DataBase.groups[i].lessons[j]);
                }
            }
        }
    }

    @Override
    public void getAllLessonGroupByName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write group name : ");
        String groupName = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
                if (DataBase.groups[i].getName().equals(groupName)){
                    System.out.println(Arrays.toString(DataBase.groups[i].getLessons()));
                }
        }
    }

    @Override
    public void deleteLessonById() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your id :");
        int san = scanner.nextInt();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = i; j < DataBase.groups[i].lessons.length - 1; j++) {
                if (DataBase.groups[i].lessons[j].getId() == san){
                    DataBase.groups[i].lessons[j] = DataBase.groups[i].lessons[j+1];
                }
            }

            DataBase.groups[i].lessons = Arrays.copyOf(DataBase.groups[i].lessons,DataBase.groups[i].lessons.length - 1);
        }

    }

//    @Override
//    public void deleteLessonByName() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write your name : ");
//        String name = scanner.nextLine();
//
//        for (int i = 0; i < DataBase.groups.length; i++) {
//            for (int l = i; l < DataBase.groups[i].lessons.length - 1; l++) {
//                if (DataBase.groups[i].lessons[i].getLessonName().equalsIgnoreCase(name)){
//                    DataBase.groups[i].lessons[l] = DataBase.groups[i].lessons[l+1];
//                }
//            }
//            DataBase.groups[i].lessons = Arrays.copyOf(DataBase.groups[i].lessons,DataBase.groups[i].lessons.length - 1);
//        }
//    }
}
