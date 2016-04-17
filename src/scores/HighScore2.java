package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



/**
*   HighScore class interacting with distant data
*   @author: AFONSO Benjamin and CABOURG Max
*   @see: scores#TestHighSCore
*/
public class HighScore2 {

  /*
  *  Calls the API server and returns the scores
  *  @return: ArrayList<String>
  */
  public ArrayList<String> getScores(){

    String res = "";
    // Starting a connexion to the API
    HttpURLConnection conn = GET("https://api.thingspeak.com/channels/108875/feeds.json");
    // Reading the distant ressource
    res = readBuffer(conn);
    // Printing the JSON.
    ArrayList<String> result = new ArrayList<String>();
    System.out.println("\nRecieved JSON from distant server: ");
    System.out.println(res);
    System.out.println("\n");

    try {
      JSONParser parser = new JSONParser();
      // Parse the JSON
      Object obj = parser.parse(res);
      // Cast the parsed stuff to JSONObject
      JSONObject jsonObject = (JSONObject) obj;
      // Make an array out of 'feeds'
      JSONArray scores = (JSONArray) jsonObject.get("feeds");
      Iterator<JSONObject> i = scores.iterator();

      // Get all players and scores and store it in an ArrayList
      while (i.hasNext()){
        JSONObject cur = i.next();
        result.add(cur.get("field2").toString());
        result.add(cur.get("field1").toString());

      }
      System.out.println(result);


    } catch (ParseException e) {
      e.printStackTrace();
    }


    return result;
  }


  public BestPlayer[] tenBestScores(String[] readScores){
    // Creating the array to recieve the 10 best players
      BestPlayer[] allBest = new BestPlayer[10];
      return allBest;
  }


  /**
  *  Send score to the distant API Server
  *
  */
  public void sendScore(String[] score){

  }

  // Read the buffer contained in the given HttpURLConnection
  private String readBuffer(HttpURLConnection conn){
    String output = null;
    String res = "";
    try {

      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      while ((output = br.readLine()) != null){
        res = res+output;
      }
      conn.disconnect();
    } catch (IOException e) {
      e.printStackTrace();
    }
      return res;

  }

  // Open a HttpURLConnection to read the result.
  private HttpURLConnection GET(String target){

    HttpURLConnection conn = null;
    try {
      URL url = new URL(target);
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
    } catch (IOException e) {
        e.printStackTrace();
    }
      return conn;
  }

}
