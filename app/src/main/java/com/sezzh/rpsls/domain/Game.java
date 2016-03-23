package com.sezzh.rpsls.domain;

import android.content.Context;

import java.util.HashMap;
import java.util.Random;


import com.sezzh.rpsls.R;
/**
 * Created by sezzh on 14/03/2016.
 */
public class Game {


  private Integer playerChoice;
  private Integer androidChoice;
  private Context context;
  private HashMap<String, String> conclusions = new HashMap<>();
  private int[] choiceString = {
    R.string.game_choice_scissors,
    R.string.game_choice_paper,
    R.string.game_choice_rock,
    R.string.game_choice_lizard,
    R.string.game_choice_spock
  };

  public Game(Context context) {
    this.context = context;
    Random rand = new Random();
    this.androidChoice = rand.nextInt(GameKeys.LAST_CHOICE);
  }

  public void setPlayerChoice(Integer playerChoice) {
    this.playerChoice = playerChoice;
  }

  public HashMap play() {
    String result = null;
    String playerString = this.context.getString(R.string.game_player);
    String androidString = this.context.getString(R.string.game_android);
    String message = null;
    String androidChoice = context.getString(choiceString[this.androidChoice]);
    if (this.playerChoice == this.androidChoice) {
      result = this.context.getString(R.string.game_draw);
      message = result;
    } else if (this.playerChoice == GameKeys.SCISSORS_CHOICE) {
      if (this.androidChoice == GameKeys.PAPER_CHOICE) {
        result = this.context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.ROCK_CHOICE) {
        result = this.context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.LIZARD_CHOICE) {
        result = this.context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.SPOCK_CHOICE) {
        result = this.context.getString(R.string.game_lost);
      }
    } else if (this.playerChoice == GameKeys.PAPER_CHOICE) {
      if (this.androidChoice == GameKeys.SCISSORS_CHOICE) {
        result = this.context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.ROCK_CHOICE) {
        result = this.context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.LIZARD_CHOICE) {
        result = this.context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.SPOCK_CHOICE) {
        result = this.context.getString(R.string.game_win);
      }
    } else if (this.playerChoice == GameKeys.ROCK_CHOICE) {
      if (this.androidChoice == GameKeys.SCISSORS_CHOICE) {
        result = this.context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.PAPER_CHOICE) {
        result = this.context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.LIZARD_CHOICE) {
        result = this.context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.SPOCK_CHOICE) {
        result = this.context.getString(R.string.game_lost);
      }
    } else if (this.playerChoice == GameKeys.LIZARD_CHOICE) {
      if (this.androidChoice == GameKeys.SCISSORS_CHOICE) {
        result = context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.PAPER_CHOICE) {
        result = context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.ROCK_CHOICE) {
        result = context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.SPOCK_CHOICE) {
        result = context.getString(R.string.game_win);
      }
    } else if (this.playerChoice == GameKeys.SPOCK_CHOICE) {
      if (this.androidChoice == GameKeys.SCISSORS_CHOICE) {
        result = context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.PAPER_CHOICE) {
        result = context.getString(R.string.game_lost);
      } else if (this.androidChoice == GameKeys.ROCK_CHOICE) {
        result = context.getString(R.string.game_win);
      } else if (this.androidChoice == GameKeys.LIZARD_CHOICE) {
        result = context.getString(R.string.game_lost);
      }
    }
    message = playerString + " " + result;
    conclusions.put("message", message);
    conclusions.put("androidChoice", androidChoice);
    return conclusions;
  }
}
