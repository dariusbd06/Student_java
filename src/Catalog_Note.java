import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog_Note {
    public static void main(String[] args) {

        Map<String, Student> catalogMap = new HashMap<>();

        try {

            List<String> liniiStudenti = Files.readAllLines(Paths.get("studenti_in.txt"));
            for (String linie : liniiStudenti) {
                String[] c = linie.split(",");
                if (c.length == 4) {
                    Student s = new Student(c[0].trim(), c[1].trim(), c[2].trim(), c[3].trim());

                    catalogMap.put(s.getNumărMatricol(), s);
                }
            }


            List<String> liniiNote = Files.readAllLines(Paths.get("note_anon.txt"));
            for (String linie : liniiNote) {
                String[] c = linie.split(",");
                if (c.length == 2) {
                    String matricolCăutat = c[0].trim();
                    double notaGăsită = Double.parseDouble(c[1].trim());


                    Student studentGăsit = catalogMap.get(matricolCăutat);

                    if (studentGăsit != null) {
                        studentGăsit.setNota(notaGăsită);
                    }
                }
            }


            System.out.println("--- Catalogul final al studenților ---");
            for (Student student : catalogMap.values()) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierelor: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Eroare: O notă din fișier nu este un număr valid.");
        }
    }
}