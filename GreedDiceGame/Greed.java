/*
Ethan McCarthy
4/26/2022
Project: Greed
Description: Class to hold the main method, will probably handle some Menuing and I/O
*/

import java.util.*;

public class Greed {
    static Object[] players;
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many humans are going to play?...");
        int numPlayers = sc.nextInt();
        System.out.println("How many computer players are going to play?...");
        int numCPUs = sc.nextInt();
        
        players = initializePlayers(numPlayers, numCPUs);
        
        
    }
    
    //initialize the player array with a specified number of human and computer players
    static Object[] initializePlayers(int numPlayers, int numCPUs) {
        //create a temp array and make it at least 2 long or as long as the total number of players
        Object[] temp;
        int totalPlayers = numPlayers + numCPUs;
        
        if (totalPlayers < 2) {
            temp = new Object[2];
        }
        else {
            temp = new Object[totalPlayers];
        }
        
        //fill the first portion of the array with human players, then fill the rest with computers
        
        //humans
        int progress = 0;
        for (int i = 0; i < numPlayers; i++) {
            temp[i] = new Player(6);
            progress ++;
        }
        
        //computers
        for (int i = progress; i < temp.length; i++) {
            temp[i] = new ComputerPlayer(6);
        }
        
        return temp;
    }
}