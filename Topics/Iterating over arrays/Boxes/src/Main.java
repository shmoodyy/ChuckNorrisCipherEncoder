import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String box1 = scanner.nextLine();
        String box2 = scanner.nextLine();
        String[] box1Array = box1.split(" ");
        String[] box2Array = box2.split(" ");

        int[] sortedBox1 = new int[3];
        int[] sortedBox2 = new int[3];
        for (int i = 0; i < 3; i++) {
            sortedBox1[i] = Integer.parseInt(box1Array[i]);
            sortedBox2[i] = Integer.parseInt(box2Array[i]);
        }

        Arrays.sort(sortedBox1);
        Arrays.sort(sortedBox2);

        boolean box1Fits = false;
        boolean box2Fits = false;
        for (int i = 0; i < 3; i++) {
            if (sortedBox1[i] == sortedBox2[i]) {
                box1Fits = box2Fits = false;
                break;
            }
            if (sortedBox1[i] < sortedBox2[i]) {
                box1Fits = true;
            } else {
                box2Fits = true;
            }
        }

        System.out.println(box1Fits == box2Fits ? "Incompatible"
                : box1Fits ? "Box 1 < Box 2" : "Box 1 > Box 2");
    }
}