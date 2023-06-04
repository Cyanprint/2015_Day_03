import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        try {
            /* Santa, Year 1 */
            int direction;
            FileReader text = new FileReader("src/input.txt");
            LocationManager santa = new LocationManager();
            Delivery.deliver(santa.currentLocation());
            direction = text.read();
            while (direction != -1) {
                Delivery.deliver(santa.nextLocation((char) direction));
                direction = text.read();
                /* Debugging code: */
                /* System.out.printf("%s", (char) direction); */
            }
            text.close();
            System.out.printf("Number of houses delivered to in Year 1: %d%n", Delivery.numHouses());

            /* Santa and Robo-Santa, Year 2 */
            Delivery.clear();
            santa.resetLocation();
            LocationManager roboSanta = new LocationManager();
            boolean roboSantaTurn = false;
            text = new FileReader("src/input.txt");
            Delivery.deliver(santa.currentLocation()); // Santa
            Delivery.deliver(roboSanta.currentLocation()); // Robo-Santa
            direction = text.read();
            while (direction != -1) {
                if (roboSantaTurn) {
                    Delivery.deliver(roboSanta.nextLocation((char) direction));
                } else {
                    Delivery.deliver(santa.nextLocation((char) direction));
                }
                roboSantaTurn ^= true;
                direction = text.read();
                /* Debugging code: */
                /* System.out.printf("%s", (char) direction); */
            }
            text.close();
            System.out.printf("Number of houses delivered to in Year 2: %d%n", Delivery.numHouses());

        } catch (IOException exception) {
            System.out.printf("Error: %s%n", exception);
        }
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.printf("Runtime: %f ms%n", duration.toNanos() / 1000000.0);
    }
}
