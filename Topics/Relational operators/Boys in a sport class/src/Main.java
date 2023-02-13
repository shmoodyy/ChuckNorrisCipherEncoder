import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        int[] boysHeights = {h1, h2, h3};
        System.out.println(boysHeights[0] >= boysHeights[1] && boysHeights[1] >= boysHeights[2]
                || boysHeights[0] <= boysHeights[1] && boysHeights[1] <= boysHeights[2]);
    }
}