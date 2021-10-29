public class Player {

    //players and totalmoves constructors
    String name;
    String Boatname;
    int currentPosition;

    public Player() {
        this.currentPosition = 0;
    }
    //setter getters
    public void setName(String n){
        name=n;
    }
    public String getName(){
        return name;
    }
    public void setBoatname(String b){
        Boatname = b;
    }
    public String getBoatname(){
        return Boatname;
    }
    public void setcurrentPosition(int c){
        currentPosition=c;
    }
    public int getcurrentPosition(){
        return this.currentPosition;
    }

    public void movePos(int i) {
        this.currentPosition+=i;
    }
}