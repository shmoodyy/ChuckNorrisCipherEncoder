package chucknorris;

import java.util.Scanner;

public class Encode {
    static String inputToEncode;
    static String encodedCount0;
    static String encodedCount1;
    static int count0, count1;

    public Encode() {
        encodedCount0 = encodedCount1 = "0";
        count0 = count1 = 0;
        System.out.println("Input string: ");
        Scanner scanner = new Scanner(System.in);
        inputToEncode = scanner.nextLine();
    }

    public void encodeAction() {
        System.out.println("Encoded string: ");
        chuckNorrisEncoder(convertStringToBinary());
        System.out.println();
        System.out.println();
    }

    public String convertStringToBinary() {
        StringBuilder result = new StringBuilder();
        char[] chars = inputToEncode.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%7s", Integer.toBinaryString(aChar))   // char -> int,
                            .replaceAll(" ", "0")       // 7-bit zero padding
            );
        }
        return result.toString();
    }

    public void chuckNorrisEncoder(String fBV) {                        //fBV = my formattedBinaryValue
        for (int i = 0; i < fBV.length(); i++) {
            boolean repeatBit = (i - 1) >= 0 && fBV.charAt(i) == fBV.charAt(i - 1);
            switch (fBV.charAt(i)) {
                case '0' -> {
                    count0++;
                    if (count1 > 0) {
                        System.out.print(encodedCount1.repeat(count1) + " ");
                    } else {
                        System.out.print(encodedCount1.repeat(count1));
                    }
                    count1 = 0;

                    if (!repeatBit) {
                        System.out.print("00 ");
                    }
                }
                case '1' -> {
                    count1++;
                    if (count0 > 0) {
                        System.out.print(encodedCount0.repeat(count0) + " ");
                    } else {
                        System.out.print(encodedCount0.repeat(count0));
                    }
                    count0 = 0;

                    if (!repeatBit) {
                        System.out.print("0 ");
                    }
                }
                default -> {
                }
            }
        }
        System.out.print(encodedCount0.repeat(count0) + encodedCount1.repeat(count1));
    }
}
