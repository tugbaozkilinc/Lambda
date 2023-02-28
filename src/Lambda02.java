import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> number = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        evenSquarePrint(number);
        System.out.println();
        oddCubePrint(number);
        System.out.println();
        evenSquareRootPrint(number);
        System.out.println();
        findMaxEl(number);
        findMaxElWithStructured(number);
        evenSquareMax(number);
        sumEvenElements(number);
        multiplyEvenElements(number);
        findMinEl(number);
        printMinBiggerThanFive(number);
        printEvenSquareSort(number);
    }

    //Task 1: Functional Programming ile listin cift elemanlarinin karelerini ayni satirda aralarina bosluk bırakarak print ediniz.
    public static void evenSquarePrint(List<Integer> n){
        n.stream().filter(Lambda01::findEven).map(t -> t*t).forEach(Lambda01::print); //map() Stream icerisindeki akisi degistirir.
    }

    //Task 2: Functional Programming ile listin tek elemanlarinin kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void oddCubePrint(List<Integer> n){
        n.stream().filter(Lambda02::findOdd).map(t -> (t*t*t)+1).forEach(Lambda01::print);
    }

    public static boolean findOdd(int a){
        return a%2!=0;
    }

    //Task 3: Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void evenSquareRootPrint(List<Integer> n){
        n.stream().filter(Lambda01::findEven).map(Math::sqrt).map(t -> String.format("%.2f", t)).forEach(t -> System.out.print(t + " ")); //map(Math::sqrt) double dondurdugu icin print methodumu kullanamam.
    }

    //Task 4: List'in en buyuk elemanini yazdiriniz.
    public static void findMaxEl(List<Integer> n){
        Optional<Integer> max = n.stream().reduce(Math::max); //reduce() terminal operation dir, akistan tek bir deger gelecekse kullanilir.
                                                              //int variable tanimlama durumunda value nun null olma ihtimaline karsi code un NullPointerException
                                                              //atma durumunu data type i Optional<Integer> yazarak onleriz.
        System.out.println(max); //Optional[15]
    }

    public static void findMaxElWithStructured(List<Integer> n){
        int max = Integer.MIN_VALUE;
        for(Integer w : n){
            if(w>max){
                max = w;
            }
        }
        System.out.println("Max value is: " + max);
    }

    //Task 5: List'in cift elemanlarinin karelerinin en buyugunu print ediniz.
    public static void evenSquareMax(List<Integer> n){
        System.out.println(n.stream().filter(Lambda01::findEven).map(t -> t*t).reduce(Integer::max)); //Optional[36] code u direk sout un icine yazmadan variable a atamak istersem yukaridaki
                                                                                                      //gibi data type imi Optional<Integer> secmeliyim.
                                                                                                      //Math::max yerine Integer::max yazarsan daha hizli calisir.
    }

    //Task 6: List'teki tum elemanlarin toplamini yazdiriniz.
    public static void sumEvenElements(List<Integer> n){
        int sum = n.stream().reduce(0, (a, b) -> a+b);
        System.out.println(sum);
    }
    /*
    * a ilk degerini her zaman atanan degerden(ilk parametreden) alır, bu örnekte 0 oluyor.
    * b degerini her zaman stream()'den akısdan alır.
    * a ilk degerinden sonraki her degeri action(islem) dan alır.
    */

    //Task 7: List'teki cift elemanlarin carpimini yazdiriniz.
    public static void multiplyEvenElements(List<Integer> n){
        Optional<Integer> multiply = n.stream().filter(Lambda01::findEven).reduce(Math::multiplyExact);
        System.out.println(multiply); //Optional[48]
    }

    //Task 8: List'teki elemanlardan en kucugunu print ediniz.
    public static void findMinEl(List<Integer> n){
        System.out.println(n.stream().reduce(Integer::min));
    }

    //Task 9: List'teki 5 ten buyuk en kucuk tek sayiyi print ediniz.
    public static void printMinBiggerThanFive(List<Integer> n){
        System.out.println(n.stream().filter(t -> t>5).filter(Lambda02::findOdd).reduce(Integer::min));
    }

    //Task 10: List'teki cift elemanlarinin karelerini kucuk ten buyuge print ediniz.
    public static void printEvenSquareSort(List<Integer> n){
        n.stream().filter(Lambda01::findEven).map(t -> t*t).sorted().forEach(Lambda01::print);
    }

}
