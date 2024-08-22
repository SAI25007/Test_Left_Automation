package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class docAutomateSteps {

    public Path filePath;
    public String content;
    public String savedContent;

    @Given("Open the text document")
    public void openTextDocument() {
        String fileName = "sample.txt";
        content = "Hello World. How are You";

        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Construct the path to the desktop
        Path desktopPath = Paths.get(userHome, "Desktop");

        // Create the full path to the text document
        filePath = Paths.get(desktopPath.toString(), fileName);
    }
    @When("Enter the data")
    public void enterData() {
        try {
            // Write the content to the file
            Files.writeString(filePath, content);
            System.out.println("Text successfully written to " + filePath);
            //save the content
            savedContent = Files.readString(filePath);

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    @Then("Save the text document")
    public void saveTextDocument() {
        System.out.println("Saved content:\n" + savedContent);
    }
}
