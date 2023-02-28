import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(sumWithStructured(5));
        System.out.println(sumWithFunctional(5));
        System.out.println(sumEvenElements(4));
        System.out.println(firstPositiveNumSum(4));
        System.out.println(firstOddSum(3));
        findSquareOfTheNumber(3);
        System.out.println();
        printWantedNumber(3, 2);
        System.out.println();
        System.out.println(calculateFactorial(5));
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.
    public static int sumWithStructured(int x){
        int sum = 0;
        for(int i = 1; i<=x; i++){
            sum += i;
        }
        return sum;
    }

    public static int sumWithFunctional(int x){
        return IntStream.range(1, x+1).sum(); //range(a, b) -> a dan b ye kadar(b dahil degil) int degerleri akisa alir. IntStream sana int akıs saglar, yukarıda List<Integer> x varmıs gibi.
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int sumEvenElements(int x){
        return IntStream.rangeClosed(1, x).filter(Lambda01::findEven).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan programi create ediniz.
    public static int firstPositiveNumSum(int x){
        return IntStream.
                iterate(2, t -> t+2). //2 den sonsuza kadar elemanlari 2 arttirarak akisa alir -> 2,4...
                limit(x). //x ile sinirliyorum
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi create ediniz.
    public static int firstOddSum(int x){
        return IntStream.iterate(1, t -> t+2).filter(t -> t%2!=0).limit(x).sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi create ediniz..
    public static void findSquareOfTheNumber(int x){
        IntStream.iterate(2, t -> t*2).limit(x).forEach(Lambda01::print);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi create ediniz.
    public static void printWantedNumber(int wantedNum, int x){
        IntStream.iterate(wantedNum, t -> t*wantedNum).limit(x).forEach(Lambda01::print);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi create ediniz.
    public static int calculateFactorial(int x){
        return IntStream.rangeClosed(1, x).reduce(1, (a, b) -> a*b);
    }

}
