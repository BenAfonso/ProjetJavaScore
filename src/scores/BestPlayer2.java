package scores;

public class BestPlayer2{

  private int score;
  private String player;

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

  // tenBestScores, ...
}
