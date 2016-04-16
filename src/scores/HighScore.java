package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
*   HighScore class interacting with distant data
*   @author: AFONSO Benjamin and CABOURG Max
*   @see: scores#TestHighSCore
*/
public class HighScore {

  /*
  *  Calls the API server and returns the scores
  *  @return: String[]
  */
  public String[] getScores(){

    String res = "";
    // Starting a connexion to the API
    HttpURLConnection conn = GET("https://api.thingspeak.com/channels/108875/feeds.json?results=2");
    // Reading the distant ressource
    res = readBuffer(conn);
    // Printing the JSON.
    System.out.println(res);

    return null;
  }



  /**
  * Simulate a player playing.
  *
  */
  public void play(){

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
