package chucknorris;
import java.util.Scanner;

public class InputOperation {
    String inputOperator;
    boolean validOperation, isEncode, isDecode, exitProgram = false;

    public void chooseOperation() {
        while (!validOperation) {
            System.out.println("Please input operation (encode/decode/exit):");
            Scanner scanner = new Scanner(System.in);
            inputOperator = scanner.nextLine();
            if (inputOperator.equalsIgnoreCase("encode")
                    || inputOperator.equalsIgnoreCase("decode")
                    || inputOperator.equalsIgnoreCase("exit")) {
                validOperation = true;
                switch (inputOperator.toLowerCase()) {
                    case "encode" -> {
                        Encode encd = new Encode();
                        validOperation = false;
                    }
                    case "decode" -> {
                        Decode decd = new Decode();
                        validOperation = false;
                    }
                    case "exit" -> {
                        System.out.println("Bye!");
                        exitProgram = true;
                    }
                    default -> {
                    }
                }
            } else {
                System.out.println("There is no '" + inputOperator + "' operation\n");
                validOperation = false;
            }
        }
    }
}
