package lambda_practice;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        printList(list);
        System.out.println();
        printOddElements(list);
        System.out.println();
        System.out.println(printEvenElements(list));
        printPositiveAndEven(list);
        System.out.println();
        printPositiveOrEven(list);
        System.out.println();
        printSquareOfElements(list);
        System.out.println();
        printCubeOfElements(list);
        System.out.println();
        printSquare(list);
        System.out.println();
        sortTheList(list);
        System.out.println();
        reverseTheList(list);
        System.out.println();
        System.out.println(newList(list));
        System.out.println(newPrintList(list));
        System.out.println(findSumOfTheList(list));
        findSumOfThePositiveElement(list);
    }

    //S1: List i aralarinda bosluk birakarak yazdiriniz.
    public static void printList(List<Integer> l){
        l.forEach(t -> System.out.print(t + " "));
    }

    //S2: Sadece negatif olanlari yazdiriniz.
    public static void printOddElements(List<Integer> l){
        l.stream().filter(t -> t<0).forEach(t -> System.out.print(t + " "));
    }

    //S3: Cift olanlardan yeni bir list olusturunuz.
    public static List<Integer> printEvenElements(List<Integer> l) {
        return l.stream().filter(t -> t%2==0).collect(Collectors.toList());
    }

    //S4: Pozitif ve cift olanlari yazdiriniz.
    public static void printPositiveAndEven(List<Integer> l){
        l.stream().filter(t -> t>0 && t%2==0).forEach(t -> System.out.print(t + " "));
    }

    //S5: Pozitif veya cift olanlari yazdiriniz.
    public static void printPositiveOrEven(List<Integer> l){
        l.stream().filter(t -> t>0 || t%2==0).forEach(t -> System.out.print(t + " "));
    }

    //S6: List in elemanlarinin karelerini aynı satırda bir boslukla yazdıriniz.
    public static void printSquareOfElements(List<Integer> l){
        l.stream().map(t -> t*t).forEach(t -> System.out.print(t + " "));
    }

    //S7: Listin cift elemanlarinin kuplerini aynı satirda yazdiriniz.
    public static void printCubeOfElements(List<Integer> l){
        l.stream().filter(t -> t%2==0).map(t -> t*t*t).forEach(t -> System.out.print(t + " "));
    }

    //S8 : List in elemanlarinin karelerini tekrarsiz olarak yazdiriniz.
    public static void printSquare(List<Integer> l){
        l.stream().map(t -> t*t).distinct().forEach(t -> System.out.print(t + " "));
    }

    //S9: List in elemanlarini kucukten buyuge sıralayınız.
    public static void sortTheList(List<Integer> l){
        l.stream().sorted().forEach(t -> System.out.print(t + " "));
    }

    // S10: Listin elemanlarini buyukten kucuge siralayalim.
    public static void reverseTheList(List<Integer> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }

    //S11: list pozitif elemanlari icin kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> newList(List<Integer> l){
        return l.stream().filter(t -> t>0).map(t -> t*t*t).filter(t -> t%10==5).collect(Collectors.toList());
    }

    //S12: list pozitif elemanlarinin karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> newPrintList(List<Integer> l){
        return l.stream().filter(t -> t>0).map(t -> t*t).filter(t -> t%10!=5).collect(Collectors.toList());
    }

    //S13: list elemanlarini toplamini bulalim
    public static Optional<Integer> findSumOfTheList(List<Integer> l){
        Optional<Integer> sum = l.stream().reduce(Math::addExact); //Math::addExact Optional verir reduce(0, Math::addExact) yazarsan Optional dan kurtulursun.
        return sum;
    }

    //S14: Listin pozitif elemanlarının toplamını bulalım.
    public static void findSumOfThePositiveElement(List<Integer> l){
        System.out.println(l.stream().filter(t -> t>0).reduce(0, Integer::sum));
    }

}
