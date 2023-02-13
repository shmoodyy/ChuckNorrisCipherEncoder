package chucknorris;
import java.util.Scanner;

public class InputOperation {
    String inputOperator;
    boolean validOperation, exitProgram;

    public void chooseOperation() {
        while (!validOperation) {
            System.out.println("Please input operation (encode/decode/exit):");
            Scanner scanner = new Scanner(System.in);
            inputOperator = scanner.nextLine();
            switch (inputOperator.toLowerCase()) {
                case "encode" -> {
                    Encode encodeInput = new Encode();
                    encodeInput.encodeAction();
                }
                case "decode" -> {
                    Decode decodeInput = new Decode();
                    decodeInput.decodeAction();
                }
                case "exit" -> {
                    System.out.println("Bye!");
                    exitProgram = true;
                    validOperation = true;
                }
                default -> {
                    System.out.println("There is no '" + inputOperator + "' operation\n");
                }
            }
        }
    }
}
