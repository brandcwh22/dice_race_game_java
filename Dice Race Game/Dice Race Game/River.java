
import java.util.ArrayList;
import java.util.Random;

public class River {

    //River length
    int riverLength;
    Random random = new Random();
    ArrayList<Integer> path = new ArrayList<>();

    //setter getter
    public void createRiver(int r) {
        path.clear();
        riverLength = r;
        for(int i=0;i<r;i++) {
            addPath(i);
        }
    }

    public int getRiverLength() {
        return this.riverLength;
    }

    public void addPath(int i) {
        if (random.nextInt(10)>2||i<5) {
            this.path.add(0);
        } else if (random.nextInt(10)==1){
            this.path.add(random.nextInt(5)-6);
        } else {
            this.path.add(random.nextInt(5)+1);
        }
    }

    public String display(int p1, int p2) {
        String result = "|";
        for(int i=0;i<riverLength;i++) {
            if (p1== i && p2==i) {
                result += "!|";
            }
            else if (i == p1) {
                result += "1|";
            }else if (i == p2) {
                result += "2|";
            }else if (path.get(i)==0) {
                result += " |";
            }else if (path.get(i)<0) {
                result += "#|";
            }else {
                result += "C|";
            }
        }
        return result;
    }

    public int getPath(int pos) {
        return path.get(pos);
    }
}