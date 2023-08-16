package Application;

import java.util.Random;

public class Randomclassroom {
    private static final String[] CLASS_NAMES = {
            "A101", "B202", "C303", "D404", "E505", "F606", "G707",
            "H101", "H202", "J505", "K303", "L404", "M707", "N202"
    };
    private Random ran;

    public Randomclassroom() {
        ran = new Random();
    }

    public String generateRandomClass() {
        String className = CLASS_NAMES[ran.nextInt(CLASS_NAMES.length)];
        return className;
    }
}
