import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucdilim", "guvec", "kokorec", "kusleme", "arabasi", "waffle", "kunefe", "guvec"));

        printSortedElements(menu);
        System.out.println();
        reverseOrderAccToLength(menu);
        System.out.println();
        naturalOrderAccToLength(menu);
        System.out.println();
        checkIfLengthSmallerThanSeven(menu);
        checkIfStartWithW(menu);
        checkIfEndsWithX(menu);
        printTheBiggestElHasCha(menu);
        sortedAccToLastElement(menu);


    }

    // Task-1: List elemanlarini alfabetik, buyuk harf ve tekrarsiz print ediniz.
    public static void printSortedElements(List<String> l){
        l.stream().map(String::toUpperCase).sorted().distinct().forEach(t -> System.out.print(t + " "));
    }

    // Task-2: List elemanlarinin character sayisini, ters sirali olarak tekrarsiz print ediniz.
    public static void reverseOrderAccToLength(List<String> l){
        l.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::print);
    }

    // Task-3: List elemanlarini character sayisina gore kucukten buyuge gore print ediniz.
    public static void naturalOrderAccToLength(List<String> l){
        l.stream().sorted(Comparator.comparing(String::length)).forEach(Lambda01::print); // Comparator.comparing(String::length).reversed() tersi
    }

    // Task-4: List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void checkIfLengthSmallerThanSeven(List<String> l){
        System.out.println(l.stream().allMatch(t -> t.length()<=7) ? "Hepsi 7 ve 7 den az" : "En az biri 7 den fazla");
    }

    // Task-5: List elemanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void checkIfStartWithW(List<String> l){
        System.out.println(l.stream().noneMatch(t -> t.startsWith("w")) ? "Hicbiri w ile baslamiyor" : "En az biri w ile basliyor");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mı kontrol ediniz.
    public static void checkIfEndsWithX(List<String> l){
        System.out.println(l.stream().anyMatch(t -> t.endsWith("x")) ? "En az bir eleman x ile bitiyor" : "Hicbiri x ile bitmiyor");
    }

    // Task-7: Karakter sayisi en buyuk elemani yazdiriniz.
    public static void printTheBiggestElHasCha(List<String> l){
        Stream<String> lastName = l.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(1); // limit(2) yazsaydık 2 eleman gelecekti.
                                                                                                                                   // limit() methodu Stream<String> dondurur.
                                                                                                                                   // dondurdugu sey akiştır o yuzden Array e cevirdik
        System.out.println(Arrays.toString(lastName.toArray()));
        // System.out.println(m.stream().max(Comparator.comparing(String::length)));
    }

    // Task-8: list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sortedAccToLastElement(List<String> l){
        l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length()-1))).skip(1).forEach(Lambda01::print);
    }

    // *******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    // *******************************************************************************************

    // anyMatch()  --> en az bir eleman sarti saglarsa true, aksi durumda false return eder
    // allMatch()  --> tum elemanlar sarti saglarsa true, en az bir eleman sarti saglamazsa false return eder.
    // noneMatch() --> hic bir eleman sarti SAGLAMAZSA true, en az bir eleman sarti SAGLARSA false return eder.



}
