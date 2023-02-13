package chucknorris;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        InputOperation userOperation = new InputOperation();

        do {
            userOperation.chooseOperation();
        } while (!userOperation.exitProgram);
        return;
    }
}