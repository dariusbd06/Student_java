import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        try {
            List<String> linii = Files.readAllLines(Paths.get(fileName));
            for (String linie : linii) {
                // Format: "Matricol: X | Nume: Y Z | Grupa: G | Nota: N"
                String[] parts = linie.split("\\|");
                if (parts.length == 4) {
                    String matricol = parts[0].replace("Matricol:", "").trim();
                    String[] numePrenume = parts[1].replace("Nume:", "").trim().split(" ");
                    String grupa = parts[2].replace("Grupa:", "").trim();
                    double nota = Double.parseDouble(parts[3].replace("Nota:", "").trim());

                    Student s = new Student(matricol, numePrenume[1], numePrenume[0], grupa);
                    s.setNota(nota);
                    studenti.add(s);
                }
            }
            System.out.println("=== Studenti cititi din " + fileName + " ===");
        } catch (IOException e) {
            System.out.println("Eroare la citire: " + e.getMessage());
        }
        return studenti;
    }
}
