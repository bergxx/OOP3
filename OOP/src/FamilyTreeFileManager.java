package familytree;

import java.util.*;

public interface FamilyTreeFileManager {
    void saveFamilyTree(String filename, List<Human> family);
    List<Human> loadFamilyTree(String filename);
}