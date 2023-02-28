import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        /*
          Note: Lambda, Java 8 ile hayatimiza giren ve java programlama diline "functional" programming yapisini kazandiran bir ozelliktir.
          Stream Operation -> Intermediate Operation & Terminal Operation
          1) Lambda method create etme değil mevcut method'ları(library) secip kullanmaktır...
             Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
          2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
             "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur.
          3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
             ve hatasiz code yazma acilarindan cok faydalidir.
          4) Lambda sadece Collections'larda(List, Queue ve Set) ve Array'lerde kullanilabilir ancak Map'lerde kullanılmaz.
        */

        List<Integer> number = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(number);
        System.out.println();
        printElFunctional(number);
        System.out.println();
        printElFunctional1(number);
        System.out.println();
        printElFunctional2(number);
        System.out.println();
        printEvenElFunctional(number);
        System.out.println();
        printEvenElStructured(number);
        System.out.println();
        printEvenSmallFunctional(number);
        System.out.println();
        printEvenBigFunctional(number);
        System.out.println();
        printEvenElFunctionalWithMethodReference(number);
    }

    //TASK 1: "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured(List<Integer> n){
        for(Integer w : n){
            System.out.print(w + " ");
        }
    }

    //TASK 2: "Functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> n){
        n.stream().forEach(t -> System.out.print(t + " ")); //t -> System.out.print(t + " ") --> lambda expression / (t) or t
    }

    public static void printElFunctional1(List<Integer> n){
        n.
                stream().
                forEach(System.out::print); //System.out::print --> method reference
                                            //:: ilgili sınıftaki methodu çağırmamizi sağlıyor. "." ile çağırdığınız zaman o method çalışır ve kod durur ama
                                            //:: ile çağırılında stream.API bunu akışa alır ve kod çalışmaya devam eder. Method chain yapabilirsin.
                                            //Fakat "." ile method chain yapamazsin akis durur.
    }

    //Note: Lambda da lambda expression cok tercih edilmez, mumkun oldugu kadar method reference kullaniriz.

    //Kendimiz bir method olusturalım ve bunu cagıralim
    public static void print(int a) { System.out.print(a + " "); }
    public static void print(String a){
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> n){
        n.
                stream().
                forEach(Lambda01::print); //:: ile ilgili class taki methodu Stream API uzerinden cagirmis oluyorsun. Lambda fonksiyonlari class tan bagimsizdir,
                                          //class tan bagimsiz sekilde kullanmak istiyorsan :: ile cagirmalisin
                                          //Zaten "." ile cagirmak istersen senden parametre isteyecektir, fakat parametre akistan gelecegi icin parametreye yazacagimiz
                                          //bir deger elimizde olmayacagindan dolayi bu sekilde kod calismayacaktir.
    }

    //TASK 3: Functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printEvenElFunctional(List<Integer> n){
        n.stream().filter(t -> t%2==0).forEach(Lambda01::print);
    }

    //Yukaridaki task in filter() kismini method reference ile yapalim.
    public static boolean findEven(int a){
        return a%2==0;
    }

    public static void printEvenElFunctionalWithMethodReference(List<Integer> n){
        n.stream().filter(Lambda01::findEven).forEach(Lambda01::print);
    }

    //TASK 4: Structured Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printEvenElStructured(List<Integer> n){
        for(Integer w : n){
            if(w%2==0){
                System.out.print(w + " ");
            }
        }
    }

    //TASK 5: Functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printEvenSmallFunctional(List<Integer> n){
        n.stream().filter(t -> t%2==0 && t<34).forEach(Lambda01::print);
    }

    //Task 6: Functional Programming ile list elemanlarinin 34 den buyuk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printEvenBigFunctional(List<Integer> n){
        n.stream().filter(t -> t%2==0 || t>34).forEach(Lambda01::print);
    }

}
