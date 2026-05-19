import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        List<String> linii = new ArrayList<>();
        for (Student s : studenti) {
            linii.add(s.toString());
        }
        try {
            Files.write(Paths.get(fileName), linii);
            System.out.println("=== Studenti exportati in " + fileName + " ===");
        } catch (IOException e) {
            System.out.println("Eroare la scriere: " + e.getMessage());
        }
    }
}
