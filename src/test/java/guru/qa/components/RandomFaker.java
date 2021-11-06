package guru.qa.components;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomFaker {

        Faker faker = new Faker(new Locale("ru"));
        public String address = faker.address().streetAddress();
        public String firstName = faker.name().firstName();
        public String lastName = faker.name().lastName();
        int randomDay = faker.number().numberBetween(1, 30);
        public String day = Integer.toString(randomDay);

}
