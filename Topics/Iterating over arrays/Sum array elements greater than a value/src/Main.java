import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int numberThreshold;
        int sum = 0;
        int size = scanner.nextInt();
        int[] numArray = new int[size];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = scanner.nextInt();
        }

        numberThreshold = scanner.nextInt();
        for (int num : numArray) {
            if (num > numberThreshold) {
                sum += num;
            }
        }
        System.out.println(sum);
    }
}