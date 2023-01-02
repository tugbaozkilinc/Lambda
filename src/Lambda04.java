import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
      TASK :
      fields --> Universite (String)
                 bolum (String)
                 ogrenciSayisi (int)
                 notOrt (int)
                 olan POJO(Plain Old Java Object) clas create edip main method içinde 5 farklı obj'den List create ediniz.
    */

    public static void main(String[] args) {

        University university1 = new University("Bogazici", "Math", 571, 93);
        University university2 = new University("Istanbul", "Math", 600, 81);
        University university3 = new University("Istanbul", "Law", 1400, 71);
        University university4 = new University("Marmara", "Computer Engineer", 1080, 77);
        University university5 = new University("ODTU", "Ship Engineer", 333, 74);

        List<University> university = new ArrayList<>(Arrays.asList(university1, university2, university3, university4, university5));

        System.out.println(printAverageOfGrade(university));
        System.out.println(checkIfIsTheMath(university));
        System.out.println(sortAccToNumOfStd(university));
        System.out.println(printTheNumberOfTheMath(university));
        System.out.println(findTheBiggestAveGrade(university));
        System.out.println(printTheSmallestAverageGrade(university));


    }

    // Task 01: Universitelerin not ortalamalarinin 74'den buyuk oldugunu kontrol eden method create ediniz.
    public static boolean printAverageOfGrade(List<University> u){
        return u.stream().allMatch(t -> t.getAverageOfGrade()>74);
    }

    // Task 02: Universitelerin herhangi birinin bolumunde "matematik" olup olmadigini  kontrol eden method create ediniz.
    public static boolean checkIfIsTheMath(List<University> u){
        return u.stream().anyMatch(t -> t.getDepartment().toLowerCase().contains("math"));
    }

    // Task 03: Universiteleri ogrenci sayilarina gore buyukten kucuge siralayiniz.
    public static List<University> sortAccToNumOfStd(List<University> u){
        return u.stream().sorted(Comparator.comparing(University::getNumOfStd).reversed()).collect(Collectors.toList());
        // u.stream().sorted(Comparator.comparing(University::getNumOfStd).reversed()).forEach(System.out::println);

    }

    // Task 04: "matematik" bolumlerinin sayisini print ediniz.
    public static int printTheNumberOfTheMath(List<University> u){
        return (int) u.stream().filter(t -> t.getDepartment().contains("Math")).count(); // count() terminal operation
    }

    // Task 05: Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt findTheBiggestAveGrade(List<University> u){
        return u.stream().filter(t -> t.getNumOfStd()>550).mapToInt(University::getAverageOfGrade).max();
        // Tum Wrapper Class larin default degerleri null dir.
        // u.stream().filter(t -> t.getNumOfStd() > 550).sorted(Comparator.comparing(University::getAverageOfGrade).reversed()).limit(1).forEach(t -> System.out.println(t.getAverageOfGrade()));
    }

    // Task 06: Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt printTheSmallestAverageGrade(List<University> u){
        return u.stream().filter(t -> t.getNumOfStd()<1050).mapToInt(University::getAverageOfGrade).min();
        // u.stream().filter(t -> t.getNumOfStd()<1050).sorted(Comparator.comparing(University::getAverageOfGrade)).limit(1).forEach(t -> System.out.println(t.getAverageOfGrade()));
    }

}
