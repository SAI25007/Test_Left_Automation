package Packs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class docAutomation {
    public static void main(String[] args) {
        // Define the filename and content to write
        String fileName = "sample.txt";
        String content = "This is the text that will be written into the document.";

        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Construct the path to the desktop
        Path desktopPath = Paths.get(userHome, "Desktop");

        // Create the full path to the text document
        Path filePath = Paths.get(desktopPath.toString(), fileName);

        try {
            // Write the content to the file
            Files.writeString(filePath, content);
            System.out.println("Text successfully written to " + filePath);
            //save the content
            String savedContent = Files.readString(filePath);
            System.out.println("Saved content:\n" + savedContent);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}