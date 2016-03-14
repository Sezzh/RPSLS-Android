package com.sezzh.rpsls.domain;

import java.util.Random;

import android.support.v4.app.FragmentActivity;
import com.sezzh.rpsls.R;
/**
 * Created by sezzh on 14/03/2016.
 */
public class Game {

  /**
   * 0 = scissors
   * 1 = paper
   * 2 = rock
   * 3 = lizard
   * 4 = spock
   */

  public static final Integer LAST_CHOICE = 4;
  public static final Integer SCISSORS_CHOICE = 0;
  public static final Integer PAPER_CHOICE = 1;
  public static final Integer ROCK_CHOICE = 2;
  public static final Integer LIZARD_CHOICE = 3;
  public static final Integer SPOCK_CHOICE = 4;
  private Integer playerChoice;
  private Integer androidChoice;
  private FragmentActivity context;

  public Game(Integer playerChoice, FragmentActivity context) {
    this.context = context;
    this.playerChoice = playerChoice;
    Random rand = new Random();
    this.androidChoice = rand.nextInt(LAST_CHOICE);
  }

  public String play() {
    String result = null;
    String playerString = this.context.getString(R.string.game_player);
    String androidString = this.context.getString(R.string.game_android);
    String message = null;
    if (this.playerChoice == this.androidChoice) {
      result = this.context.getString(R.string.game_draw);
      message = result;
    } else if (this.playerChoice == SCISSORS_CHOICE) {
      if (this.androidChoice == PAPER_CHOICE) {
        result = this.context.getString(R.string.game_win);
        message = playerString + " " + result;
      } else if (this.androidChoice == ROCK_CHOICE) {
        result = this.context.getString(R.string.game_lost);
        message = playerString + " " + result;
      } else if (this.androidChoice == LIZARD_CHOICE) {
        result = this.context.getString(R.string.game_win);
        message = playerString + " " + result;
      } else if (this.androidChoice == SPOCK_CHOICE) {
        result = this.context.getString(R.string.game_lost);
        message = playerString + " " + result;
      }
    }
    return message;
  }
}
