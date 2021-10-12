import model.Airport;
import model.Plane;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport(5);
        for (int i = 1; i < 11; i++){
            new Thread(new Plane(("Plane " + i), airport)).start();
        }
    }
}