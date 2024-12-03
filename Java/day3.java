package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AdventOfCode\\day3.txt"));
        long res = 0;
        String fileText = "";
        while (sc.hasNextLine()) {
            fileText += sc.nextLine();
        }
        Pattern patt = Pattern.compile("mul\\((\\d*),(\\d*)\\)");
        Matcher match = patt.matcher(fileText);
        boolean doing = true;
        while (match.find()) {
            String s = match.group(), num1 = match.group(1), num2 = match.group(2);
            // System.out.printf("%s %s %s\n",s,num1,num2);
            res += Long.parseLong(num1) * Long.parseLong(num2);
        }
        System.out.println(res);

        res = 0;
        patt = Pattern.compile("(mul\\((\\d*),(\\d*)\\))|(do\\(\\))|(don't\\(\\))");
        match = patt.matcher(fileText);
        doing = true;
        while (match.find()) {
            String s2 = match.group();
            switch (s2) {
                case "do()":
                    doing = true;
                    break;
                case "don't()":
                    doing = false;
                    break;
                default:
                    if (doing) {
                        String num1 = match.group(2), num2 = match.group(3);
                        // System.out.printf("%s %s %s\n",s,num1,num2);
                        res += Long.parseLong(num1) * Long.parseLong(num2);
                    }
                    break;
            }
        }
        System.out.println(res);
    }
}
