package lambda_practice;

public class Apartment {

    private String front;
    private int floorNumber;
    private int rent;

    public Apartment() {

    }

    public Apartment(String front, int floorNumber, int rent) {
        this.front = front;
        this.floorNumber = floorNumber;
        this.rent = rent;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "front='" + front + '\'' +
                ", floorNumber=" + floorNumber +
                ", rent=" + rent +
                '}';
    }

}
