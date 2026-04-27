package ro.ulbs.proiectare.lab7;

import java.util.ArrayList;
import java.util.List;

public class AplicatieStudenti {


    public static List<List<StudentImutabil>> imparteInFormatii(List<StudentImutabil> lista) {
        List<StudentImutabil> formatie1 = new ArrayList<>();
        List<StudentImutabil> formatie2 = new ArrayList<>();

        int jumatate = (lista.size() + 1) / 2;

        for (int i = 0; i < lista.size(); i++) {
            if (i < jumatate) {
                formatie1.add(lista.get(i));
            } else {
                formatie2.add(lista.get(i));
            }
        }

        List<List<StudentImutabil>> rezultat = new ArrayList<>();
        rezultat.add(formatie1);
        rezultat.add(formatie2);
        return rezultat;
    }


    public static StudentImutabil mutaStudent(StudentImutabil student, String nouaFormatie) {
        return student.mutaInFormatie(nouaFormatie);
    }

    public static void main(String[] args) {
        List<StudentImutabil> lista = new ArrayList<>();
        lista.add(new StudentImutabil("1001", "Ion", "Popescu", "ISM141/1", 9.5));
        lista.add(new StudentImutabil("1002", "Maria", "Ionescu", "ISM141/1", 8.0));
        lista.add(new StudentImutabil("1003", "Andrei", "Popa", "ISM141/1", 7.5));
        lista.add(new StudentImutabil("1004", "Elena", "Stan", "ISM141/1", 9.0));
        lista.add(new StudentImutabil("1005", "Mihai", "Dumitrescu", "ISM141/1", 6.5));


        List<List<StudentImutabil>> formatii = imparteInFormatii(lista);

        System.out.println("=== Formatia 1 ===");
        for (StudentImutabil s : formatii.get(0)) {
            System.out.println(s);
        }

        System.out.println("\n=== Formatia 2 ===");
        for (StudentImutabil s : formatii.get(1)) {
            System.out.println(s);
        }


        System.out.println("\n=== Mutam primul student din Formatia 1 in Formatia 2 ===");
        StudentImutabil studentMutat = mutaStudent(formatii.get(0).get(0), "ISM141/2");
        System.out.println("Student mutat: " + studentMutat);
        System.out.println("Studentul original (nemodificat): " + formatii.get(0).get(0));
    }
}
