package scores;

public class BestPlayer2{

  private int score;
  private String player;

  /**
   * Creates a BestPlayer2 instance using the player's score and the player's name
   * @param score Score of the player
   * @param player Name of the player
   */
  public BestPlayer2(int score, String player) {
	super();
	this.score = score;
	this.player = player;
  }

/** Compare the player to a given player score
  * @return 0 if the score of the implicit player (this) is equal to that of the p player
  * @return -1 if the score of the implicit player is less than p
  * @return 1 otherwise
  */
  public int compareTo(BestPlayer2 p){
    if (this.score == p.score){
      return 0;
    }else if (this.score < p.score){
      return -1;
    }else{
      return 0;
    }
  }
  
  /**
   * @return the score of the player
   */
  public int getScore(){
	  return score;
  }
  
  /**
   * @return the name of the player
   */
  public String getPlayer(){
	  return player;
  }
  
  public String toString(){
	  return player+" : "+score;
  }

  // tenBestScores, ...
}
