package Packs;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class openTextDoc {
    public static void main(String[] args) {
        // Define the filename of the text document you want to open
        String fileName = "sample.txt";

        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Construct the path to the desktop
        Path desktopPath = Paths.get(userHome, "Desktop");

        // Create the full path to the text document
        Path filePath = Paths.get(desktopPath.toString(), fileName);

        // Convert the Path to a File object
        File fileToOpen = filePath.toFile();

        // Check if the file exists
        if (fileToOpen.exists()) {
            // Try to open the file with the default application
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(fileToOpen);
                System.out.println("The file " + fileToOpen.getName() + " has been opened.");
            } catch (IOException e) {
                System.err.println("An error occurred while trying to open the file.");
                e.printStackTrace();
            }
        } else {
            System.err.println("The file " + fileToOpen.getName() + " does not exist.");
        }
    }
}