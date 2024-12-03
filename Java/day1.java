package AdventOfCode;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class day1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AdventOfCode\\day1.txt"));
        ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split("   ");
            left.add(Integer.parseInt(s[0]));
            right.add(Integer.parseInt(s[1]));
        }
        left.sort(null);
        right.sort(null);
        long totalDist = 0;
        for(int i = 0; i < left.size(); i++){
            totalDist += Math.abs(left.get(i)-right.get(i));
        }
        System.out.println(totalDist);
        long simScore = 0;
        for(int i: left){
            if(right.contains(i)){
                int count = right.lastIndexOf(i) - right.indexOf(i) + 1;
                simScore += i * count;
            }
        }
        System.out.println(simScore);
    }
}
