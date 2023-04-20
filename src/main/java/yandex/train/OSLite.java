import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class OSLite {

    public static void main(String[] args) throws Exception {
        ArrayList<OS> osList = new ArrayList<>();
        int workingOS = 0;
        int osQuantity;

        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        r.readLine();
        osQuantity = Integer.parseInt(r.readLine());
        if (osQuantity == 0) {
            System.out.println(0);
            return;
        }
        String[] osFirstString = r.readLine().split(" ");
        osList.add(new OS(Integer.parseInt(osFirstString[0]), Integer.parseInt(osFirstString[1])));
        for (int i = 1; i < osQuantity; i++) {
            String[] osString = r.readLine().split(" ");
            int start = Integer.parseInt(osString[0]);
            int end = Integer.parseInt(osString[1]);
            for (OS os : osList) {
                if (!os.isDamaged && start <= os.end && end >= os.start) {
                    os.isDamaged = true;
                }
            }
            osList.add( new OS(start, end));
        }
        for (OS os : osList) {
            if (!os.isDamaged){
                workingOS++;
            }
        }


        System.out.println(workingOS);
    }


}

class OS {
    int start;
    int end;
    boolean isDamaged;

    public OS(int start, int end) {
        this.start = start;
        this.end = end;
        this.isDamaged = false;
    }
}