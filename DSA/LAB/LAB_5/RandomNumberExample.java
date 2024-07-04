import java.util.Random;

public class RandomNumberExample {
    public static void main(String[] args) {
        int n = 10; // replace with your upper limit
        Random random = new Random();
        int randomNumber = random.nextInt(n);
        // int n2= (int)Math.random();
        // System.out.println(n2);
        System.out.println("Random number between 0 and " + (n-1) + ": " + randomNumber);
    }
}
