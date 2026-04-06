
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GestiuneBursieri {

    public static void writeToFile(String filename, Collection<? extends Student> lista) {
        List<String> linii = new ArrayList<>();
        for (Student s : lista) {
            linii.add(s.toString());
        }
        try {
            Files.write(Paths.get(filename), linii);
            System.out.println("Fișierul " + filename + " a fost salvat.");
        } catch (IOException e) {
            System.out.println("Eroare la scriere: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier("1025", "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier("1024", "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier("1026", "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier("1029", "Bianca", "Popescu", "TI131/1", 9.10, 780.80));

        writeToFile("bursieri_out.txt", bursieri);
    }
}