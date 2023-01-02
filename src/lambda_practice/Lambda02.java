package lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println(listTheList(list));
        System.out.println(listStartsWithEOrC(list));
        printNewList(list);
        System.out.println();
        System.out.println(createNewList(list));
        createNewListWithoutL(list);
        System.out.println();
        sortTheList(list);

    }

    // S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    public static List<String> listTheList(List<String> l){
        return l.stream().map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase()).collect(Collectors.toList());
    }

    // S2: ilk harfi e veya c olanlari listeleyelim
    public static List<String> listStartsWithEOrC(List<String> l){
        return l.stream().filter(t -> t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).collect(Collectors.toList());
    }

    // S3: Tum String lerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void printNewList(List<String> l){
        l.stream().map(t -> "*"+t+"*").forEach(Utils::printString);
    }

    // S4: Icinde e olanlardan yeni bir list olusturunuz
    public static List<String> createNewList(List<String> l){
        return l.stream().filter(t -> t.toLowerCase().contains("e")).collect(Collectors.toList());
    }

    // S5: Tum 'l' leri silelim yazdiralim
    public static void createNewListWithoutL(List<String> l){
        l.stream().map(t -> t.replace("l", "")).forEach(Utils::printString);
    }

    // S6: List elemanlarını 2.harfe gore sıralayıp ilk 5 elemandan char sayısı en buyuk elemanı print ediniz
    public static void sortTheList(List<String> l){
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(1))).limit(5).sorted(Comparator.comparing(String::length).reversed()).findFirst());
        // l.stream().sorted(Comparator.comparing(t -> t.charAt(1))).limit(5).sorted(Comparator.comparing(t -> t.toString().length()).reversed().findFirst()
        // findFirst() akistan gelen ilk elemani verir Optional[String] dondurur.
        // System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(1))).limit(5).max(Comparator.comparing(String::length)));
    }

}
