import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab9main {

    public static void main(String[] args) {


        System.out.println("=== 9.3.1 Lista de 10 numere aleatoare in [5..25] ===");
        Random random = new Random();
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Lista: " + numere);

        // a) Suma
        int suma = numere.stream().reduce(0, Integer::sum);
        System.out.println("a) Suma: " + suma);

        // b) Max si min
        Optional<Integer> max = numere.stream().max(Comparator.naturalOrder());
        Optional<Integer> min = numere.stream().min(Comparator.naturalOrder());
        System.out.println("b) Max: " + max.get() + ", Min: " + min.get());

        // c) Filtrare [10..20]
        List<Integer> filtrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Elemente in [10..20]: " + filtrate);

        // d) Conversie la Double
        List<Double> doubles = numere.stream()
                .map(n -> (double) n)
                .collect(Collectors.toList());
        System.out.println("d) Lista Double: " + doubles);

        // e) Contine valoarea 12?
        boolean contine12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("e) Contine 12: " + contine12);

        // ============ 9.3.2 ============
        System.out.println("\n=== 9.3.2 Cuvinte din text ===");
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        // a) Cuvinte cu lungime >= 5
        List<String> cuvinteLungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("a) Cuvinte cu lungime >= 5: " + cuvinteLungi);
        System.out.println("   Numar: " + cuvinteLungi.size());

        // b) Sortare
        List<String> sortate = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("b) Lista sortata: " + sortate);


        Optional<String> cuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();
        System.out.println("c) Primul cuvant cu 'p': " + cuP.orElse("Nu s-a gasit"));
    }
}