import java.util.Scanner;

public class Race {
    int player1Pos = 1; //default starting point
    int player2Pos = 1;
    int trackLength;
    Scanner scan = new Scanner(System.in);
    Player p1 = new Player();
    Player p2 = new Player();
    River r = new River();

    //main game
    public void startRace() {
        //inputs for player 1 and 2 names
        System.out.println("For Player 1, please enter your name: ");
        String p1Name = scan.nextLine();
        p1.setName(p1Name);
        //p1.setName("Alice");

        System.out.println("For Player 2, please enter your name: ");
        String p2Name = scan.nextLine();
        p2.setName(p2Name);
        //p2.setName("Bob");

        //inputs for player 1 and 2 boat names
        System.out.println(p1.getName() + ", please provide the name of your boat.");
        String p1Boatname = scan.nextLine();
        p1.setBoatname(p1Boatname);
        //p1.setBoatname("BoatA");

        System.out.println(p2.getName() + ", please provide the name of your boat.");
        String p2Boatname = scan.nextLine();
        p2.setBoatname(p2Boatname);
        //p2.setBoatname("BoatB");

        //inputs for race track length
        System.out.println("Please provide the river race track length: ");
        trackLength = scan.nextInt();
        r.createRiver(trackLength);

        //for showing name and boat name
        System.out.println(p1.getName() + " has chosen the boat " + p1.getBoatname() + ", and " + p2.getName() + " has chosen the boat " + p2.getBoatname());
        System.out.println(r.display(p1.getcurrentPosition(), p2.getcurrentPosition()));
        while (!checkWin()) {
            //First player 1
            System.out.println(p1.getName() + " roll the dice, enter anything to roll");
            move(p1, Dice.diceRoll());
            System.out.println(r.display(p1.getcurrentPosition(), p2.getcurrentPosition()));
            if (checkWin()) {
                break;
            }
            System.out.println(p2.getName() + " roll the dice, enter anything to roll");
            move(p2, Dice.diceRoll());
            System.out.println(r.display(p1.getcurrentPosition(), p2.getcurrentPosition()));
        }
        System.out.println("Game Over");
    }

    public void move(Player p, int mov) {
        int currentPos = p.getcurrentPosition();
        if (checkBoundary(currentPos + mov)) {
            currentPos += mov;
            int path = r.getPath(currentPos);
            if (path==0) {
                System.out.println(p.getName() + " moves " + mov + " steps");
                p.setcurrentPosition(currentPos);
            } else if (path <0) {
                currentPos = bound(currentPos,r.getPath(currentPos));
                System.out.println(p.getName() + " has landed on a trap and will move back to position " + currentPos);
                p.setcurrentPosition(currentPos);
            } else {
                currentPos = bound(currentPos,r.getPath(currentPos));
                System.out.println(p.getName() + " has landed on a current and will move front to position " + currentPos);
                p.setcurrentPosition(currentPos);
            }
        }
    }

    public boolean checkBoundary(int pos) {
        return pos < r.getRiverLength() && pos >= 0;
    }

    public int bound(int pos,int mov) {
        if (pos+mov < 0) {
            return 0;
        } else if (pos+mov >= r.riverLength) {
            return trackLength-1;
        }
        return pos+mov;
    }

    public boolean checkWin() {
        if (p1.getcurrentPosition()==trackLength-1 || p2.getcurrentPosition()==trackLength-1) {
            return true;
        }
        return false;
    }
}