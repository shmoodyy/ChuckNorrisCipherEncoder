package chucknorris;
import java.util.Scanner;

public class Decode {
    String inputToDecode;
    StringBuilder decryption;
    StringBuilder decodedBit;
    StringBuilder result;
    static int spaceCount;
    static int repeatCount;
    static boolean isZero;
    static boolean validCode;

    Decode () {
        decryption = new StringBuilder();
        decodedBit = new StringBuilder();
        result = new StringBuilder();
        spaceCount = 0;
        repeatCount = 0;
        validCode = false;
        isZero = false;
        System.out.println("Input encoded string: ");
        Scanner scanner = new Scanner(System.in);
        inputToDecode = scanner.nextLine();
    }

    public void decodeAction () throws StringIndexOutOfBoundsException {
        try {
            System.out.println(convertBinaryToString(chuckNorrisDecoder()));
            System.out.println();
        } catch (Exception e) {
            System.out.println("Encoded string is not valid.");
        }
    }

    public String chuckNorrisDecoder() throws StringIndexOutOfBoundsException {
        for (int i = 0; i < inputToDecode.length(); i++) {
            if ((inputToDecode.substring(0, 3).contains("00 ") || inputToDecode.substring(0, 2).contains("0 "))
                    && inputToDecode.matches("^[0 ]+$")) {
                validCode = true;
                if (inputToDecode.charAt(i) == ' ') {                           // if a space
                    spaceCount++;
                    if (spaceCount % 2 == 0) {                              // if repeat count is over append bits
                            decodedBit.append(isZero ? "0".repeat(repeatCount)
                            : "1".repeat(repeatCount));
                            isZero = false;
                    }
                } else if (spaceCount % 2 != 0) { // count # of bit repetitions
                    repeatCount++;
                } else {                                                   // if spaceCount is even, check if bit is 0 or 1
                    if (inputToDecode.substring(i , i + 3).contains(" ")) {
                        if (inputToDecode.substring(i, i + 2).contains("00")) {
                            isZero = true;
                        }
                    } else {                                            // BAD BIT
                        validCode = false;
                        break;
                    }
                    repeatCount = 0;
                }
            } else {
                validCode = false;
                System.out.println("Encoded string is not valid.");
                break;
            }
        }

        decodedBit.append(validCode ? inputToDecode.charAt(inputToDecode.length() - 1) == ' ' ? "" // append last bit series if necessary
                : isZero ? "0".repeat(repeatCount)
                : "1".repeat(repeatCount) : "");

        decryption.append(decodedBit);
        return decryption.toString();
    }

    public String convertBinaryToString (String input) throws StringIndexOutOfBoundsException {
        try {
            for (int i = 0; i < input.length(); i += 7) {
                result.append((char) (Integer.parseInt(input.substring(i, i + 7), 2)));
            }
            if (validCode) System.out.println("Decoded String:");
            return result.toString();
        } catch (Exception e) {
            return "Encoded string is not valid.";
        }
    }
}
