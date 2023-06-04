public class LocationManager {
    private int x;
    private int y;

    public LocationManager() {
        x = 0;
        y = 0;
    }

    public String nextLocation(char direction) {
        switch (direction) {
            case '>' -> x++;
            case '^' -> y++;
            case '<' -> x--;
            case 'v' -> y--;
        }
        /* Solves the problem of different objects representing the same coordinate */
        return currentLocation();
    }

    public String currentLocation() {
        return String.format("(%d, %d)", x, y).intern();
    }

    public void resetLocation() {
        x = 0;
        y = 0;
    }
}
