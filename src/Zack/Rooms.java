package Zack;

public class Rooms {
    private BackgroundScene[] rooms;

    public Rooms() {
        // Declaring how many rooms, add more when we get more rooms
        rooms = new BackgroundScene[24]; // Change the 4 to however many more rooms there are

        // Keep adding the amount of rooms needed and amount of props, in the order of the rooms pls <3
        rooms[0] = new BackgroundScene("resources/escalator.png"); // Room 1 image
        rooms[0].clickablePropLocation(100, 100, 50, 50, "prop 1 in room 1"); // Prop location
        rooms[0].clickablePropLocation(200, 200, 50, 50, "prop 2 in room 1");

        rooms[1] = new BackgroundScene("resources/escalatorSide.png"); // Room 2 image
        rooms[1].clickablePropLocation(150, 150, 50, 50, "prop 1 in room 2"); // Prop location
        rooms[1].clickablePropLocation(250, 250, 50, 50, "prop 2 in room 2");

        rooms[2] = new BackgroundScene("resources/corridor.png"); // Room 3 image
        rooms[2].clickablePropLocation(300, 300, 50, 50, "prop 1 in room 3"); // Prop location
        rooms[2].clickablePropLocation(400, 400, 50, 50, "prop 2 in room 3");

        rooms[3] = new BackgroundScene("resources/hallwayTwo.png"); // Room 4 image
        rooms[3].clickablePropLocation(350, 350, 50, 50, "prop 1 in room 4"); // Prop location
        rooms[3].clickablePropLocation(450, 450, 50, 50, "prop 2 in room 4");

        rooms[4] = new BackgroundScene("resources/hallwayOne.png");
        rooms[5] = new BackgroundScene("resources/map.png");
        rooms[6] = new BackgroundScene("resources/roomOne.png");
        rooms[7] = new BackgroundScene("resources/roomMiddle.png");
        rooms[8] = new BackgroundScene("resources/roomBackWall.png");
        rooms[9] = new BackgroundScene("resources/roomLeft.png");
        rooms[10] = new BackgroundScene("resources/roomBackRight.png");
        rooms[11] = new BackgroundScene("resources/roomWhiteboard.png");
        rooms[12] = new BackgroundScene("resources/libraryEntry.png");
        rooms[13] = new BackgroundScene("resources/libraryCorridor.png");
        rooms[14] = new BackgroundScene("resources/libraryDudeOne.png");
        rooms[15] = new BackgroundScene("resources/libraryDudeTwo.png");
        rooms[16] = new BackgroundScene("resources/bookVeryFar.png");
        rooms[17] = new BackgroundScene("resources/bookFar.png");
        rooms[18] = new BackgroundScene("resources/bookClose.png");
        rooms[19] = new BackgroundScene("resources/bookOne.png");
        rooms[20] = new BackgroundScene("resources/bookTwo.png");
        rooms[21] = new BackgroundScene("resources/bagOne.png");
        rooms[22] = new BackgroundScene("resources/bagTwo.png");
        rooms[23] = new BackgroundScene("resources/stupid.png");



    }

    public BackgroundScene getRoom(int index) {
        return rooms[index];
    }

    public int roomNum() {
        return rooms.length;
    }
}