package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AdventOfCode\\day2.txt"));
        int safeReports = 0, safeReports2 = 0;
        while (sc.hasNextLine()) {
            String[] sr = sc.nextLine().split(" ");
            int arr[] = new int[sr.length];
            for (int i = 0; i < sr.length; i++) {
                arr[i] = Integer.parseInt(sr[i]);
            }
            if (safe(arr)) {
                safeReports++;
            }

            // Part 2
            else {
                for (int i = 0; i < arr.length; i++) {
                    int[] arr2 = new int[arr.length - 1];
                    for (int j = 0; j < arr.length - 1; j++) {
                        if (j < i) {
                            arr2[j] = arr[j];
                        } else {
                            arr2[j] = arr[j + 1];
                        }
                    }
                    if (safe(arr2)) {
                        safeReports2++;
                        break;
                    }
                }
            }
        }
        System.out.println(safeReports);
        System.out.println(safeReports + safeReports2);

    }

    public static boolean safe(int[] arr) {
        int prevDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) < 1 || Math.abs(arr[i] - arr[i - 1]) > 3
                    || Integer.signum(prevDiff) != Integer.signum(arr[i] - arr[i - 1])) {
                return false;
            } else {
                prevDiff = arr[i] - arr[i - 1];
            }
        }
        return true;
    }
}
