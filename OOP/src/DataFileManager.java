package familytree;

import java.io.*;
import java.util.List;

public class DataFileManager implements FamilyTreeFileManager {

    @Override
    public void saveFamilyTree(String filename, List<Human> family) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(family);
            System.out.println("Семейное дерево успешно сохранено в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Human> loadFamilyTree(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List && !((List<?>) obj).isEmpty() && ((List<?>) obj).get(0) instanceof Human) {
                return (List<Human>) obj;
            }
            System.err.println("Ошибка загрузки семейного дерева: неверный формат файла.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}