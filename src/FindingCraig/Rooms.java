package FindingCraig;

public class Rooms {
    private BackgroundScene[] rooms;

    public Rooms() {
        // Initialize the rooms array with the correct number of rooms
        rooms = new BackgroundScene[4]; // Change the 4 to however many more rooms there are

        // Initialize each room with its background and props
        rooms[0] = new BackgroundScene("resources/1.png"); // Room 1 image
        rooms[0].clickablePropLocation(100, 100, 50, 50, "prop 1 in room 1"); // Prop location
        rooms[0].clickablePropLocation(200, 200, 50, 50, "prop 2 in room 1");

        rooms[1] = new BackgroundScene("resources/2.png"); // Room 2 image
        rooms[1].clickablePropLocation(150, 150, 50, 50, "prop 1 in room 2"); // Prop location
        rooms[1].clickablePropLocation(250, 250, 50, 50, "prop 2 in room 2");

        rooms[2] = new BackgroundScene("resources/3.png"); // Room 3 image
        rooms[2].clickablePropLocation(300, 300, 50, 50, "prop 1 in room 3"); // Prop location
        rooms[2].clickablePropLocation(400, 400, 50, 50, "prop 2 in room 3");

        rooms[3] = new BackgroundScene("resources/bat.jpeg"); // Room 4 image
        rooms[3].clickablePropLocation(350, 350, 50, 50, "prop 1 in room 4"); // Prop location
        rooms[3].clickablePropLocation(450, 450, 50, 50, "prop 2 in room 4");
    }

    public BackgroundScene getRoom(int index) {
        return rooms[index];
    }

    public int roomNum() {
        return rooms.length;
    }

    public String getPuzzleType(int roomIndex, int x, int y) {
        BackgroundScene room = rooms[roomIndex];
        for (ClickableObjects prop : room.props) {
            if (prop.isMe(x, y)) {
                return prop.message;
            }
        }
        return null;
    }
}