package Zack;

import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BackgroundScene {

    String background;
    ArrayList<ClickableObjects> roomSwitching; // Room-switching buttons
    ArrayList<ClickableObjects> props; // Props
    int width, height;

    // State variables
    private boolean viewingBookOne = false;
    private boolean viewingBookTwo = false;
    private boolean bookTwoUnlocked = false;

    // Player's input sequence for the puzzle
    private ArrayList<Integer> playerOrder = new ArrayList<>();

    public BackgroundScene(String background) {
        this.background = background;
        width = 1000;
        height = 1000;

        // Props array
        props = new ArrayList<>();
        // Room switching array (only previousRoom button)
        roomSwitching = new ArrayList<>();
        roomSwitching.add(new ClickableObjects(0, 500, 65, 65, "previousRoom", "resources/left.jpeg")); // Use image for previousRoom
    }

    // Method to add props from Template
    public void clickablePropLocation(int x, int y, int width, int height, String message, Object o) {
        props.add(new ClickableObjects(x, y, width, height, message, null)); // Pass null for imagePath if no image
    }

    // Drawing everything
    public void draw() {
        SaxionApp.drawImage(background, 0, 0, width, height); // Drawing the background

        // Always draw the previousRoom button
        for (ClickableObjects clickableObject : roomSwitching) {
            clickableObject.drawSwitches();
        }

        if (viewingBookOne) {
            // Display bookOne.png and hint text
            SaxionApp.drawImage("resources/bookOne.png", 0, 0, width, height);
            SaxionApp.setFill(Color.white);
            SaxionApp.drawText("Only the brightest stars align.", 50, 50, 24);
            SaxionApp.drawText("Look to the stars for the order.", 50, 100, 24);
        } else if (viewingBookTwo) {
            // Display bookTwo.png and puzzle
            SaxionApp.drawImage("resources/bookTwo.png", 0, 0, width, height);
            SaxionApp.setFill(Color.white);
            SaxionApp.drawText("Click the numbers in the correct order (1-5):", 50, 50, 24);

            // Display the player's current input sequence
            SaxionApp.drawText("Your input: " + playerOrder.toString(), 50, 100, 24);

            // Display numbered buttons
            for (ClickableObjects clickableObject : props) {
                if (clickableObject.toString().matches("[1-5]")) {
                    clickableObject.drawProps();
                }
            }
        } else {
            // Draw props (excluding numbered buttons)
            for (ClickableObjects clickableObject : props) {
                if (!clickableObject.toString().matches("[1-5]")) { // Exclude numbered buttons
                    clickableObject.drawProps();
                }
            }
        }
    }

    // User input clicks
    public String getClick(int x, int y) {
        // Check room-switching buttons first
        for (ClickableObjects clickableObject : roomSwitching) {
            if (clickableObject.isMe(x, y)) {
                return clickableObject.toString();
            }
        }

        // Check props
        for (ClickableObjects clickableObject : props) {
            if (clickableObject.isMe(x, y)) {
                return clickableObject.toString();
            }
        }
        return "";
    }

    // Handle puzzle input
    public void handlePuzzleInput(int number) {
        playerOrder.add(number); // Add the clicked number to the player's input sequence

        // Check if the player has entered 5 numbers
        if (playerOrder.size() == 5) {
            int[] correctOrder = {3, 5, 2, 4, 1}; // Example correct order
            int[] playerOrderArray = new int[5];
            for (int i = 0; i < 5; i++) {
                playerOrderArray[i] = playerOrder.get(i);
            }

            // Check if the player's order is correct
            if (Arrays.equals(playerOrderArray, correctOrder)) {
                SaxionApp.drawText("The pedestal book unlocks!", 50, 150, 24);
                unlockBookTwo(); // Unlock bookTwo
                viewingBookTwo = false; // Go back to the room
            } else {
                SaxionApp.drawText("Incorrect order. Try again.", 50, 150, 24);
            }

            // Reset the player's input sequence
            playerOrder.clear();
        }
    }

    // Unlock bookTwo
    public void unlockBookTwo() {
        this.bookTwoUnlocked = true;
    }

    // Check if bookTwo is unlocked
    public boolean isBookTwoUnlocked() {
        return this.bookTwoUnlocked;
    }

    // Set viewingBookOne state
    public void setViewingBookOne(boolean viewingBookOne) {
        this.viewingBookOne = viewingBookOne;
    }

    // Set viewingBookTwo state
    public void setViewingBookTwo(boolean viewingBookTwo) {
        this.viewingBookTwo = viewingBookTwo;
    }

    // Check if viewingBookOne
    public boolean isViewingBookOne() {
        return viewingBookOne;
    }

    // Check if viewingBookTwo
    public boolean isViewingBookTwo() {
        return viewingBookTwo;
    }
}