package Zack;

import nl.saxion.app.interaction.MouseEvent;

public class SceneClicking {
    private Rooms rooms;
    private int currentRoom;
    private long clickTime;

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
            } else if (output.equals("previousRoom")) { // Previous room
                currentRoom = (currentRoom - 1 + rooms.roomNum()) % rooms.roomNum();
            }
            clickTime = currentTime; // Update clickTime
        }
    }
}