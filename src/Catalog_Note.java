import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Catalog_Note {

    public static float gasesteNota(String prenume, String nume, Map<String, Student> harta) {
        String cheie = prenume + " " + nume;
        Student s = harta.get(cheie);
        if (s != null) {
            return (float) s.getNota();
        }
        return 0.0f;
    }

    public static void main(String[] args) {

        Map<String, Student> mapMatricol = new HashMap<>();

        Map<String, Student> mapNumeComplet = new HashMap<>();

        try {

            List<String> liniiS = Files.readAllLines(Paths.get("studenti_in.txt"));
            for (String linie : liniiS) {
                String[] c = linie.split(",");
                if (c.length == 4) {
                    Student s = new Student(c[0].trim(), c[1].trim(), c[2].trim(), c[3].trim());
                    mapMatricol.put(s.getNumărMatricol(), s);
                    mapNumeComplet.put(s.getPrenume() + " " + s.nume, s);
                }
            }


            List<String> liniiN = Files.readAllLines(Paths.get("note_anon.txt"));
            for (String linie : liniiN) {
                String[] c = linie.split(",");
                if (c.length == 2) {
                    Student s = mapMatricol.get(c[0].trim());
                    if (s != null) {
                        s.setNota(Double.parseDouble(c[1].trim()));
                    }
                }
            }


            System.out.println(" Rezultat Tema ");
            float notaM = gasesteNota("Bianca", "Popescu", mapNumeComplet);
            float notaN = gasesteNota("Ioan", "Popa", mapNumeComplet);

            System.out.println("Nota Bianca Popescu: " + notaM);
            System.out.println("Nota Ioan Popa: " + notaN);

        } catch (IOException e) {
            System.out.println("Eroare: Nu s-a găsit fișierul!");
        }
    }
}