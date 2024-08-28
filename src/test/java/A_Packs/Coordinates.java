package A_Packs;

import java.awt.MouseInfo;
import java.awt.Point;

public class Coordinates {

        public static void main(String[] args) {
            while (true) {
                // Get the current mouse position
                Point point = MouseInfo.getPointerInfo().getLocation();

                // Print the coordinates
                System.out.println("Current Mouse Coordinates: X = " + point.x + ", Y = " + point.y);

                try {
                    // Wait for 1 second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


}
