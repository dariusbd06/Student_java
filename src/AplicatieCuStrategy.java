import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {

    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22)
        );

        Exporter exporter = new Exporter();

        // a) Export in consola
        IStudentiExport strategyConsola = new StudentiInConsola();
        exporter.startExport(strategyConsola, studenti);

        // b) Export in fisier text
        String fileNameTxt = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);

        // c) Export in fisier xlsx
        String fileNameXlsx = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(fileNameXlsx);
        exporter.startExport(strategyFisierExcel, studenti);

        // d) Import din fisier text
        System.out.println("\n=== Import din txt ===");
        StudentiDinFisierText importTxt = new StudentiDinFisierText(fileNameTxt);
        List<Student> dinTxt = importTxt.doImport();
        dinTxt.forEach(System.out::println);

        // e) Import din fisier xlsx
        System.out.println("\n=== Import din xlsx ===");
        StudentiDinFisierXlsx importXlsx = new StudentiDinFisierXlsx(fileNameXlsx);
        List<Student> dinXlsx = importXlsx.doImport();
        dinXlsx.forEach(System.out::println);
    }
}