package services.impl;

import DataBase.DataBase;
import groupsPeaksoft.Generator;
import groupsPeaksoft.Group;
import services.GroupService;

import java.util.Arrays;
import java.util.Scanner;

public class Groupsimpl implements GroupService {

    @Override
    public Group[] addGroup() {
        Scanner sc = new Scanner(System.in);
        Group group = new Group();

        while (true) {
            System.out.print("Жаны группа: ");
            String newGroup = sc.nextLine();
            if (unik(newGroup) == 0){
                group.setName(newGroup);
                break;
            }
        }
        System.out.print("Описание: ");
        String newDescreption = sc.nextLine();

        group.setDescription(newDescreption);

        group.setId(Generator.generateId());
        DataBase.groups = Arrays.copyOf(DataBase.groups, DataBase.groups.length +1);
        DataBase.groups[DataBase.groups.length -1] = group;

        return DataBase.groups;
    }

    @Override
    public void getGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write group name :");
        String nameGroup = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equals(nameGroup)){
                System.out.println(DataBase.groups[i]);
            }

        }
    }

    @Override
    public String updateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Update name : ");
        String name = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equals(name)){
                System.out.println(" New group name :");
                DataBase.groups[i].setName((scanner.nextLine()));
                return DataBase.groups[i].getName();
            }
           else System.out.println("Not found !");
        }
        return null;
    }

    @Override
    public Group[] getAllGroup() {
        Group[] groups = DataBase.groups;
        return groups;
    }

    @Override
    public void deleteGroupByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("write your group name :");
        String soz = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equalsIgnoreCase(soz)){
                for (int j = i; j < DataBase.groups.length - 1; j++) {
                    DataBase.groups[i] = DataBase.groups[i+1];
                }
            }
           DataBase.groups = Arrays.copyOf(DataBase.groups,DataBase.groups.length - 1);
        }
    }


    private static int unik (String name){
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getName().equalsIgnoreCase(name)){
                return 1;
            }

        }
        return 0;
    }
}
