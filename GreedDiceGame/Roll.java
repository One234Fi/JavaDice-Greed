/*
Ethan McCarthy
5/5/2022
Project: Greed
Description: Class that holds most of the scoring methods
*/

package greed;

import java.util.*;

public class Roll {
    //a list of the values for each set of three dice faces (111, 222 ... etc)
    final private static int[] SCORE_MULTI = {1000, 200, 300, 400, 500, 600};
    
    /* public static void main (String [] args) {
        int[] testRoll1 = {1, 2, 3, 4, 5, 6}; //1200
        int [] testRoll2 = {1, 1, 1, 1, 5, 5}; //2100
        int [] testRoll3 = {2, 2, 1, 2, 6, 3}; //300
        
        System.out.println(computeScore(testRoll1));
        System.out.println(computeScore(testRoll2));
        System.out.println(computeScore(testRoll3));
        
    } */
    
    //visible to other classes, takes an int[], sorts it, turns it into a string, then returns the result of calculate() on that string
    public static int computeScore(int[] result) {
        int[] temp = result;
        Arrays.sort(temp);
        String s = "";
        for (int i : temp) {
            s += i;
        }
        
        return calculate(s);
    }
    
    //takes a string, assuming it is sorted, then determines and returns the score value of the string
    private static int calculate(String s) {
        //System.out.println(s);
        if (s.equalsIgnoreCase("123456")) {
            return 1200;
        }
        
        int tempScore = 0;
        
        for (int i = 1; i <= 6; i++) {
            if (s.contains("" + i)) {
                String tStr = s.substring(s.indexOf("" + i), s.lastIndexOf("" + i) + 1);
                switch (tStr.length()) {
                    case 0: tempScore += 0;
                    case 1: if (i == 1 || i == 5) tempScore += SCORE_MULTI[i-1] / 10; break;
                    case 2: if (i == 1 || i == 5) tempScore += SCORE_MULTI[i-1] / 5; break;
                    case 3: tempScore += SCORE_MULTI[i-1]; break;
                    case 4: tempScore += SCORE_MULTI[i-1] * 2; break;
                    case 5: tempScore += SCORE_MULTI[i-1] * 4; break;
                    case 6: tempScore += SCORE_MULTI[i-1] * 8; break;
                    default: tempScore += -1;
                }
            }
        }
        
        return tempScore;
    }
}
