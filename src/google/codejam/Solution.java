package google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        int testCase = 0;
        String[] inputs = new String[testCases];
        while (testCase < testCases) {
            in = new Scanner(System.in);
            inputs[testCase] = in.nextLine();
            ++testCase;
        }

        testCase = 1;
        for (String arg :
                inputs) {
            System.out.print("Case #" + testCase + ": ");
            String[] input = arg.split(" ");
            int shieldPower = Integer.parseInt(input[0]);
            String codeStr = input[1];
            char[] codes = codeStr.toCharArray();
            int destructionCount = 0;
            int chargeCount = 1;
            int shootCount = 0;
            boolean gotOutput = false;
            for (char code : codes) {
                if (code == 'S') {
                    destructionCount += chargeCount;
                    shootCount++;
                    if (shootCount > shieldPower) {
                        System.out.println("IMPOSSIBLE");
                        gotOutput = true;
                        break;
                    }
                } else if (code == 'C') {
                    chargeCount *= 2;
                }
            }
            if (gotOutput) {
                continue;
            }
            if ((shootCount == 0) || (destructionCount < shieldPower)) {
                System.out.println("0");
                ++testCase;
                continue;
            } else {
                destructionCount = 0;
                chargeCount = 1;
                int hacks = 0;
                for (int i = 0; i < codes.length; i++) {
                    if (codes[i] == 'C' && ((i + 1) < codes.length) && codes[i + 1] == 'S') {
                        if (!(((chargeCount * 2)) + destructionCount == shieldPower && (i + 2 == codes.length))) {
                            codes[i + 1] = 'C';
                            codes[i] = 'S';
                            destructionCount += chargeCount;
                            hacks++;
                        }
                    } else if (codes[i] == 'S') {
                        destructionCount += chargeCount;
                    } else if (codes[i] == 'C') {
                        chargeCount *= 2;
                    }

                    if ((i + 1) == codes.length && destructionCount <= shieldPower) {
                        System.out.print(hacks);
                        break;
                    } else if ((i + 1) == codes.length) {
                        i = -1; //so that the next run will increment it to 0 that is from the beginning
                        destructionCount = 0;
                        chargeCount = 1;
                    }
                }
            }
            ++testCase;
            System.out.println();
        }
    }
}