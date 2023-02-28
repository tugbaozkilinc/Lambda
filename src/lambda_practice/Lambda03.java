package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {

    public static void main(String[] args) {

        Apartment flat1 = new Apartment("east",3,4000);
        Apartment flat2 = new Apartment("west",2,2500);
        Apartment flat3 = new Apartment("south",1,3500);
        Apartment flat4 = new Apartment("east",5,3000);

        List<Apartment> rentedFlats = new ArrayList<>(Arrays.asList(flat1, flat2, flat3, flat4));

        sortedAccToRent(rentedFlats);
        System.out.println(listWithFloorMoreThanTwo(rentedFlats));
    }

    //Example 1: Dogu cephesindeki kiralık daireleri kiralarına göre sıralayıniz.
    public static void sortedAccToRent(List<Apartment> c){
       c.stream().filter(t -> t.getFront().equalsIgnoreCase("east")).sorted(Comparator.comparing(Apartment::getRent)).forEach(System.out::println);
    }

    //Example 2: Kat sayısı 2den cok olan dairelerin kiralarını listeleyın
    public static List<Integer> listWithFloorMoreThanTwo(List<Apartment> c){
        return c.stream().filter(t -> t.getFloorNumber()>2).map(t -> t.getRent()).collect(Collectors.toList());
    }

}
