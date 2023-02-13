import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int numToFind;
        int count = 0;
        int size = scanner.nextInt();
        int[] numArray = new int[size];
        
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = scanner.nextInt();
        }

        numToFind = scanner.nextInt();
        for (int num : numArray) {
            if (num == numToFind) {
                count++;
            }
        }

        System.out.println(count);
    }
}