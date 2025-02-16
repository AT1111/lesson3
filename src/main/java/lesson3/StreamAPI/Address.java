package lesson3.StreamAPI;

public class Address {
    String city; // City name
    String street; // Street name

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return city + ", " + street;
    }
}
