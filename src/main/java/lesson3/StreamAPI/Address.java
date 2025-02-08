package lesson3.StreamAPI;

import static lesson3.StreamAPI.Main.randomValueLong;

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

    public static Address getRandomAddress() {
        int i= (int) randomValueLong(1, 4, 0);
        return switch (i) {
            case 1 -> new Address("London", "Highway 359");
            case 2 -> new Address("New York", "838 Broadway");
            case 3 -> new Address("Kyiv", "Olimpiiska St.2");
            default -> new Address("Kharkiv", "Nauki Avenue 3");
        };
    }
}
