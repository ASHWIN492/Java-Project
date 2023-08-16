package Application;

import java.util.Random;

public class RandomNameGenerator {
    private static final String[] NAMES = {
            "Alice", "Bob", "Charlie", "Diana", "Eva", "Frank",
            "Grace", "Henry", "Isabella", "Jack", "Jay", "Hannah",
            "Henry", "Hagrid", "Gandy", "Tellis", "Herppy", "Shannon",
            "Danny", "Remo", "Jenny", "Lily", "Iisa", "Nick", "Polly",
            "Cinthia", "Ethan", "Farhan", "John", "Kendall",
            "Liana", "Marie", "Nuthan", "Olive", "Peggy", "Quinoa", "Rustin",
            "Salie", "Tanya", "Amanda", "Kenny", "Barbarah", "Pierre", "Zyan",
            "Annabelle", "Valak", "Sherry", "Loslia", "Ronnie", "Hope", "Niklaus",
            "Elijah", "Rebecca", "Gloria", "Phillip", "Conrad", "Harry", "Alex",
            "Haley", "Michael", "Sheldon", "Annie", "Blake", "Claire", "Mike",
            "Dylan", "Allen", "Chris", "Prince", "Shelly", "Rubin", "Dolly",
            "Chandler", "Cassie", "Ross", "Joseph", "David", "Solomon"
    };
    private Random random;

    public RandomNameGenerator() {
        random = new Random();
    }

    public String generateRandomName() {
        String firstName = NAMES[random.nextInt(NAMES.length)];
        return firstName;
    }

    public static void main(String[] args) {
        RandomNameGenerator nameGenerator = new RandomNameGenerator();
        for (int i = 0; i < 10; i++) {
            String randomName = nameGenerator.generateRandomName();
            System.out.println(randomName);
        }
    }
}
