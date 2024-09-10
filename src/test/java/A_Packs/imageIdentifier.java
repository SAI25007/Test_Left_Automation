package A_Packs;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class imageIdentifier {
        public static void main(String[] args) {
            try {
                Robot robot = new Robot();
                BufferedImage referenceImage = ImageIO.read(new File("C:\\Automation_Pictures\\pic1.PNG"));
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

                while (true) {
                    BufferedImage screenCapture = robot.createScreenCapture(screenRect);
                    Point matchPoint = findImage(screenCapture, referenceImage);

                    if (matchPoint != null) {
                        robot.mouseMove(matchPoint.x, matchPoint.y);
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        System.out.println("Image found and clicked!");
                        break;
                    }

                    Thread.sleep(1000); // Check every second
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static Point findImage(BufferedImage screen, BufferedImage image) {
            for (int x = 0; x < screen.getWidth() - image.getWidth(); x++) {
                for (int y = 0; y < screen.getHeight() - image.getHeight(); y++) {
                    if (isMatch(screen, image, x, y)) return new Point(x + image.getWidth() / 2, y + image.getHeight() / 2);
                }
            }
            return null;
        }

        public static boolean isMatch(BufferedImage screen, BufferedImage image, int x, int y) {
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    if (screen.getRGB(x + i, y + j) != image.getRGB(i, j)) return false;
                }
            }
            return true;
        }

}


