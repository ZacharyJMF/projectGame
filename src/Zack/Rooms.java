package Zack;

public class Rooms {
    private BackgroundScene[] rooms;

    public Rooms() {
        rooms = new BackgroundScene[24];

        // Room 0: Escalator
        rooms[0] = new BackgroundScene("resources/escalator.png");
        rooms[0].clickablePropLocation(420, 330, 240, 370, "nextRoom", null);

        // Room 1: Library Entry
        rooms[1] = new BackgroundScene("resources/libraryEntry.png");
        rooms[1].clickablePropLocation(358, 382, 259, 380, "nextRoom", null);

        // Room 2: Library Corridor
        rooms[2] = new BackgroundScene("resources/libraryCorridor.png");
        rooms[2].clickablePropLocation(500, 300, 225, 265, "nextRoom", null);

        // Room 3: Library Dude One
        rooms[3] = new BackgroundScene("resources/libraryDudeOne.png");
        rooms[3].clickablePropLocation(300, 381, 225, 210, "nextRoom", null);

        // Room 4: Library Dude Two
        rooms[4] = new BackgroundScene("resources/libraryDudeTwo.png");
        rooms[4].clickablePropLocation(235, 160, 454, 509, "nextRoom", null);

        // Room 5: Book Very Far
        rooms[5] = new BackgroundScene("resources/bookVeryFar.png");
        rooms[5].clickablePropLocation(470, 450, 280, 150, "nextRoom", null);

        // Room 6: Book Far
        rooms[6] = new BackgroundScene("resources/bookFar.png");
        rooms[6].clickablePropLocation(257, 470, 376, 217, "nextRoom", null);

        // Room 7: Book Close (contains bookOne and bookTwo)
        rooms[7] = new BackgroundScene("resources/bookClose.png");
        rooms[7].clickablePropLocation(235, 458, 196, 173, "bookOne", null); // Hint
        rooms[7].clickablePropLocation(611, 586, 275, 792, "bookTwo", null); // Solution

        // Add numbered buttons for puzzle input (only in the bookTwo room)
        rooms[7].clickablePropLocation(50, 200, 50, 50, "1", null); // Button for number 1
        rooms[7].clickablePropLocation(110, 200, 50, 50, "2", null); // Button for number 2
        rooms[7].clickablePropLocation(170, 200, 50, 50, "3", null); // Button for number 3
        rooms[7].clickablePropLocation(230, 200, 50, 50, "4", null); // Button for number 4
        rooms[7].clickablePropLocation(290, 200, 50, 50, "5", null); // Button for number 5

        // Room 10: Bag One
        rooms[10] = new BackgroundScene("resources/bagOne.png");
        rooms[10].clickablePropLocation(325,215,425,465, "nextRoom", null);

        // Room 11: Bag Two
        rooms[11] = new BackgroundScene("resources/bagTwo.png");
        rooms[11].clickablePropLocation(330,290,390,340, "nextRoom", null);

        // Room 12: Stupid
        rooms[12] = new BackgroundScene("resources/winPage.png");


    }

    public BackgroundScene getRoom(int index) {
        return rooms[index];
    }

    public int roomNum() {
        return rooms.length;
    }
}