package scores;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
*
*
*
*/
public class TestHighScore2 {

    private static String nickname = null;

    // Prompt the user for a Nickname
    public static void main (String [] args){
      // Ask for player's name
      System.out.print("What's your nickname ? ");
      Scanner in = new Scanner(System.in);
      nickname = in.nextLine();
      in.close();

      // Simulate score
      Integer score = chooseScore();
      // Display score
      System.out.println("Good job "+nickname+", you've done "+score+" !");
      
      // Create an instance of BestPlayer
      BestPlayer2 player = new BestPlayer2(score,nickname);
      
      HighScore2 h = new HighScore2();
      
      ArrayList<String> s = h.getScores();
      String[][] array = new String[s.size()/2][2];
      for(int i = 0; i<s.size(); i+=2){
    	  array[i/2][0] = s.get(i); //Get name
    	  array[i/2][1] = s.get(i+1); //Get score
      }
      
      ArrayList<BestPlayer2> tenBest = h.tenBestScores(array);
      System.out.println("The ten best players are : ");
      for(BestPlayer2 bp : tenBest)
    	  System.out.println(bp);
      
    }


    // Automatically choose a random score
    private static int chooseScore() {

      ArrayList<String> t = new ArrayList<String>();

      // Opens the score file
      FileInputStream fstream = null;

      try {
        fstream = new FileInputStream("assets/scoreSample.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String cur;
        while ((cur = br.readLine()) != null){
          t.add(cur);
        }
        br.close();

      // Exception: File not found
      } catch (FileNotFoundException e){
        System.out.println("BUSTED ! File not found...");
        e.printStackTrace();
      // Exception: IO
      } catch (IOException e) {
        System.out.println("Uhh. An error occured reading the file...");
        e.printStackTrace();
      }

      // Return a random index of the Arraylist
      return Integer.parseInt(t.get((int)(Math.random()*t.size())));
    }
 }
