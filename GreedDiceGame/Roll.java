
package greed;

import java.util.*;

public class Roll {
    
    String[] validResults = {"1", "5", "222", "333", "444", "666", "123456"};
    
    static Hashtable<String, Integer> scoreVals;
    public static void initialize() {
        scoreVals = new Hashtable<String, Integer>();
        scoreVals.put("123456", 1200);
        scoreVals.put("666666", 4800);
        scoreVals.put("555555", 4000);
        scoreVals.put("444444", 3200);
        scoreVals.put("333333", 2400);
        scoreVals.put("222222", 1600);
        scoreVals.put("111111", 8000);
        scoreVals.put("66666", 2400);
        scoreVals.put("55555", 2000);
        scoreVals.put("44444", 1600);
        scoreVals.put("33333", 1200);
        scoreVals.put("22222", 800);
        scoreVals.put("11111", 4000);
        scoreVals.put("6666", 1200);
        scoreVals.put("5555", 1000);
        scoreVals.put("4444", 800);
        scoreVals.put("3333", 600);
        scoreVals.put("2222", 400);
        scoreVals.put("1111", 2000);
        scoreVals.put("666", 600);
        scoreVals.put("555", 500);
        scoreVals.put("444", 400);
        scoreVals.put("333", 300);
        scoreVals.put("222", 200);
        scoreVals.put("111", 1000);
        scoreVals.put("5", 50);
        scoreVals.put("1", 100);
    }
    
    int computeScore(int[] result) {
        int[] temp = result;
        Arrays.sort(temp);
        String s = "";
        for (int i : temp) {
            s += i;
        }
        int i = calculate(s);
        
        return 0;
    }
    
    int calculate(String s) {
        if (scoreVals.get(s) != null) {
            return Math.max(scoreVals.get(s), calculate(s));
        }
        return 0;
    }
}
