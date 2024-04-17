package familytree;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Human father = new Human("Сергей", LocalDate.of(1975, 6, 20), Gender.Male, null, null);
        Human mother = new Human("Елена", LocalDate.of(1980, 9, 12), Gender.Female, null, null);
        Human child1 = new Human("Максим", LocalDate.of(2005, 1, 14), Gender.Male, mother, father);
        Human child2 = new Human("Егор", LocalDate.of(2008, 8, 10), Gender.Male, mother, father);
        Human child3 = new Human("София", LocalDate.of(2012, 11, 5), Gender.Female, mother, father);

        FamilyTree family = new FamilyTree();
        family.addMember(father);
        family.addMember(mother);
        family.addMember(child1);
        family.addMember(child2);
        family.addMember(child3);

        FamilyTreeFileManager fileManager = new DataFileManager();
        fileManager.saveFamilyTree("familytree.txt", family.getFamily());

        List<Human> loadedFamily = fileManager.loadFamilyTree("familytree.txt");
        if (loadedFamily != null) {
            System.out.println("Загруженное семейное дерево:");
            Collections.sort(loadedFamily, Comparator.comparing(Human::getName));
            for (Human member : loadedFamily) {
                System.out.println(member);
            }
        }
    }
}