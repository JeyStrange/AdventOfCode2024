package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day4 {
    static ArrayList<char[]> crossword;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AdventOfCode\\day4.txt"));
        crossword = new ArrayList<>();
        while (sc.hasNextLine()) {
            crossword.add(sc.nextLine().toCharArray());
        }
        int count = 0;
        for (int i = 0; i < crossword.size(); i++) {
            for (int j = 0; j < crossword.get(i).length; j++) {
                if (crossword.get(i)[j] == 'X') {
                    count += countXmas(i, j);
                }
            }
        }
        System.out.println(count);

        // Part 2
        count = 0;
        for (int i = 0; i < crossword.size() - 2; i++) {
            for (int j = 0; j < crossword.get(i).length - 2; j++) {
                if(isMasBox(i,j)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int countXmas(int r, int c) {
        // N NE E SE S SW W NW
        int[][] offsets = { { -1, 0 }, { -1, +1 }, { 0, +1 }, { +1, +1 }, { +1, 0 }, { +1, -1 }, { 0, -1 },
                { -1, -1 } };
        String[] dirStrings = new String[8];
        Arrays.fill(dirStrings, "");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < dirStrings.length; j++) {
                try {
                    dirStrings[j] += crossword.get(r + offsets[j][0] * i)[c + offsets[j][1] * i];
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
        int count = 0;
        for (String s : dirStrings) {
            if (s.equals("XMAS")) {
                count++;
            }
        }
        return count;
    }

    //This function assumes (r,c) is the row-column position of the top left corner of the X-MAS box
    public static boolean isMasBox(int r, int c) {
        String NWSE = "", SWNE = "";
        for(int i = 0; i < 3; i++){
            NWSE += crossword.get(r+i)[c+i];
            SWNE += crossword.get(r+2-i)[c+i];
        }
        return (NWSE.equals("MAS") || NWSE.equals("SAM")) && (SWNE.equals("MAS") || SWNE.equals("SAM"));
    }
}
