package A_Packs;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

   public class Robot_Function {

        public static void main(String[] args) {
            try {
                Robot robot = new Robot();

                // Move the cursor to the .exe file on the desktop (You may need to adjust coordinates)
                robot.mouseMove(37, 118); // Example coordinates

                // Simulate holding Shift key and right-clicking
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                robot.keyRelease(KeyEvent.VK_SHIFT);

                // Simulate pressing "Run as different user" (Arrow down then Enter)
                robot.delay(5000); // Delay for the context menu to appear
                for (int i = 0; i < 7; i++) {
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                    robot.delay(100); // Short delay between key presses
                }
                //Mouse Left click
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                //Click on Enter
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                // Wait for the "Run as different user" window
                robot.delay(10000); // Adjust the delay as necessary

                // Enter the username
                String username = "TP66719";
                for (char c : username.toCharArray()) {
                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                }

                robot.keyPress(KeyEvent.VK_TAB); // Move to the password field
                robot.keyRelease(KeyEvent.VK_TAB);

                // Enter the password
                String password = "Password";
                //No Caps in password use this below code.
//                for (char c : password.toCharArray()) {
//                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
//                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
//                }

                //Type First letter in capital
                typeCapitalLetter(robot, password.charAt(0));
                // Type the rest of the password in lowercase
                for (int i = 1; i < password.length(); i++) {
                    typeLowerCaseLetter(robot, password.charAt(i));
                }

                // Press Enter to confirm
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       private static void typeCapitalLetter(Robot robot, char letter) {
           int keyCode = KeyEvent.getExtendedKeyCodeForChar(letter);
           robot.keyPress(KeyEvent.VK_SHIFT); // Press Shift to capitalize the letter
           robot.keyPress(keyCode);
           robot.keyRelease(keyCode);
           robot.keyRelease(KeyEvent.VK_SHIFT); // Release Shift key
       }

       // Function to type a lowercase letter or number
       private static void typeLowerCaseLetter(Robot robot, char letter) {
           int keyCode = KeyEvent.getExtendedKeyCodeForChar(letter);
           robot.keyPress(keyCode);
           robot.keyRelease(keyCode);
       }
   }

