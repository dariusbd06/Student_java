package lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AplicatieText {
    public static void main(String[] args) {
        try {

            List<String> liniiOriginale = Files.readAllLines(Paths.get("in.txt")); // [cite: 33]
            List<String> liniiRezultat = new ArrayList<>();

            for (String linie : liniiOriginale) {

                String procesata = linie.replace(".", ".\n");


                procesata += "\n";

                liniiRezultat.add(procesata);
                System.out.print(procesata);
            }


            Files.write(Paths.get("out.txt"), liniiRezultat);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}