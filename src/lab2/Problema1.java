package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Problema1 {
    public static void main(String[] args){
        List<Integer> x = new ArrayList<>();
        List<Integer> y=  new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11));
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x (ordonată): " + x);
        System.out.println("Lista y (ordonată): " + y);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);

        System.out.println("c) xMinusY (elemente din x care nu sunt în y): " + xMinusY);

        for (Integer element : x) {
            if (element <= p && !xPlusYLimitedByP.contains(element)) {
                xPlusYLimitedByP.add(element);
            }
        }
        for (Integer element : y) {
            if (element <= p && !xPlusYLimitedByP.contains(element)) {
                xPlusYLimitedByP.add(element);
            }
        }
        Collections.sort(xPlusYLimitedByP);

        System.out.println("d) xPlusYLimitedByP (elemente <= " + p + "): " + xPlusYLimitedByP);
    }
}