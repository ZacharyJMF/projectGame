package Zack;

import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class SceneClicking {
    private Rooms rooms;
    private int currentRoom;
    private long clickTime;

    // Puzzle state
    private int[] correctOrder = {3, 5, 2, 4, 1}; // Example correct order
    private ArrayList<Integer> playerOrder = new ArrayList<>(); // Track player's input

    public SceneClicking(Rooms rooms, int currentRoom) {
        this.rooms = rooms;
        this.currentRoom = currentRoom;
        this.clickTime = 0;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void handleMouseEvent(MouseEvent mouseEvent) {
        long currentTime = System.currentTimeMillis(); // Measuring the elapsed time
        if (currentTime - clickTime > 300) { // 300ms debounce time

            int mouseX = mouseEvent.getX();
            int mouseY = mouseEvent.getY();
            String output = rooms.getRoom(currentRoom).getClick(mouseX, mouseY);
            System.out.println("click " + output); // Outputting activity + what room

            // Switching between rooms
            if (output.equals("nextRoom")) { // Next room
                currentRoom = (currentRoom + 1) % rooms.roomNum();
                resetPuzzleState(); // Reset puzzle state when switching rooms
            } else if (output.equals("previousRoom")) { // Previous room
                currentRoom = (currentRoom - 1 + rooms.roomNum()) % rooms.roomNum();
                resetPuzzleState(); // Reset puzzle state when switching rooms
            } else if (output.equals("bookOne")) { // Puzzle hint
                rooms.getRoom(currentRoom).setViewingBookOne(true);
                rooms.getRoom(currentRoom).setViewingBookTwo(false);
            } else if (output.equals("bookTwo")) { // Puzzle solution
                rooms.getRoom(currentRoom).setViewingBookOne(false);
                rooms.getRoom(currentRoom).setViewingBookTwo(true);
            } else if (output.matches("[1-5]")) { // Numbered button clicked
                handlePuzzleInput(Integer.parseInt(output));
            }
            clickTime = currentTime; // Update clickTime
        }
    }

    // Handle puzzle input
    private void handlePuzzleInput(int number) {
        playerOrder.add(number); // Add the clicked number to the player's input sequence

        // Check if the player has entered 5 numbers
        if (playerOrder.size() == 5) {
            // Convert the player's input to an array
            int[] playerOrderArray = new int[5];
            for (int i = 0; i < 5; i++) {
                playerOrderArray[i] = playerOrder.get(i);
            }

            // Check if the player's order is correct
            if (Arrays.equals(playerOrderArray, correctOrder)) {
                SaxionApp.drawText("The pedestal book unlocks!", 50, 150, 24);
                rooms.getRoom(currentRoom).unlockBookTwo(); // Unlock bookTwo
                resetPuzzleState(); // Reset puzzle state

                // Transition to bagOne.png (Room 10)
                currentRoom = 10;
            } else {
                SaxionApp.drawText("Incorrect order. Try again.", 50, 150, 24);
                resetPuzzleState(); // Reset puzzle state
            }
        }
    }

    // Reset puzzle state
    private void resetPuzzleState() {
        playerOrder.clear(); // Clear the player's input sequence
        rooms.getRoom(currentRoom).setViewingBookOne(false); // Reset viewing states
        rooms.getRoom(currentRoom).setViewingBookTwo(false);
    }
}