import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Pentru O(1) folosim HashSet in loc de List
        Set<Student> setStudenti = new HashSet<>();

        setStudenti.add(new Student("573", "Darius", "Blanaru", "C"));
        setStudenti.add(new Student("100", "Ion", "Ionescu", "TI21/1"));

        // b) Cautare O(1)
        Student s1 = new Student("120", "Alis", "Popa", "TI21/2");
        System.out.println("Alis Popa prezent (O(1)): " + setStudenti.contains(s1));

        // c) Cautare O(1)
        Student s2 = new Student("112", "Maria", "Popa", "TI21/1");
        System.out.println("Maria Popa prezent (O(1)): " + setStudenti.contains(s2));
    }
}