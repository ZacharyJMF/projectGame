package SafeBox;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.MouseEvent;
import java.util.concurrent.TimeUnit;

import java.awt.*;
import java.util.ArrayList;

public class SafeBoxApp implements GameLoop {

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new SafeBoxApp(), 1000, 1000, 40);
    }

    // Path to the safe box image
    String safeboxImg = "resources/safe-box.png";

    // Store the numbers clicked by the user
    ArrayList<String> enteredNumbers = new ArrayList<>();

    // Define the bounds for each number on the numpad
    // Each entry is {x, y, width, height, number_as_string}
    int[][] numpadBounds = {
            {567, 453, 50, 50, 1}, // 1
            {636, 453, 50, 50, 2}, // 2
            {705, 453, 50, 50, 3}, // 3
            {567, 530, 50, 50, 4}, // 4
            {636, 530, 50, 50, 5}, // 5
            {705, 530, 50, 50, 6}, // 6
            {567, 610, 50, 50, 7}, // 7
            {636, 610, 50, 50, 8}, // 8
            {705, 610, 50, 50, 9}, // 9
            {633, 696, 50, 50, 0}  // 0
    };

    @Override
    public void init() {
        //Draw the safe box image
        SaxionApp.drawImage(safeboxImg, 0, 0, 100, 100);
    }

    @Override
    public void loop() {
        SaxionApp.clear();
        // Draw the safe box image only once per frame
        SaxionApp.drawImage(safeboxImg,0,0,1000,1000);

        // Draw static text for entered numbers
        SaxionApp.setFill(Color.WHITE);
        SaxionApp.drawText("Entered Numbers:", 400, 100, 30);

        // Display the entered numbers
        String displayText = String.join("", enteredNumbers);
        SaxionApp.drawText(displayText, 400, 150, 40);
    }



    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        // Only handle left clicks and avoid multiple handling of the same click
        if (mouseEvent.isLeftMouseButton()) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();

            // Check for clicks on each number button (bounds checking)
            for (int[] bound : numpadBounds) {
                int x = bound[0];
                int y = bound[1];
                int width = bound[2];
                int height = bound[3];
                String number = String.valueOf(bound[4]);

                // If the mouse click is inside the button's bounds
                if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                    // Add the clicked number to the list
                    enteredNumbers.add(number);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;  // Exit after adding the number
                }
            }

        }
    }


    @Override
    public void keyboardEvent(nl.saxion.app.interaction.KeyboardEvent keyboardEvent) {

    }
}
