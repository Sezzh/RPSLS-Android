package com.sezzh.rpsls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sezzh.rpsls.R;
import com.sezzh.rpsls.ResultActivity;
import com.sezzh.rpsls.domain.Game;
import com.sezzh.rpsls.domain.GameKeys;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by sezzh on 14/03/2016.
 */
public class SelectionFragment extends Fragment {

  public static final String EXTRA_PLAYER_SELECTION =
    "com.sezzh.rpsls.PLAYERSELECTION";
  public static final  String EXTRA_ANDROID_SELECTION =
    "com.sezzh.rpsls.ANDROIDSELECTION";
  public static final String EXTRA_GAME_MESSAGE =
    "com.sezzh.rpsls.GAMEMESSAGE";
  private ArrayList<ImageView> buttonsArray = new ArrayList<>();
  private int[] idArray = {
    R.id.selection_button_scissors,
    R.id.selection_button_paper,
    R.id.selection_button_rock,
    R.id.selection_button_lizard,
    R.id.selection_button_spock
  };

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root =
        inflater.inflate(R.layout.fragment_selection, container, false);

    for (int i = 0; i < idArray.length; i++) {
      ImageView button = (ImageView) root.findViewById(idArray[i]);
      button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View item) {
          startGame(item);
        }
      });
      buttonsArray.add(button);
    }
    return root;

  }

  private void startGame(View item) {
    String result;
    Game game = new Game(this.getActivity());
    if (item.getId() == R.id.selection_button_scissors) {
      game.setPlayerChoice(GameKeys.SCISSORS_CHOICE);
    } else if (item.getId() == R.id.selection_button_paper) {
      game.setPlayerChoice(GameKeys.PAPER_CHOICE);
    } else if (item.getId() == R.id.selection_button_rock) {
      game.setPlayerChoice(GameKeys.ROCK_CHOICE);
    } else if (item.getId() == R.id.selection_button_lizard) {
      game.setPlayerChoice(GameKeys.LIZARD_CHOICE);
    } else if (item.getId() == R.id.selection_button_spock) {
      game.setPlayerChoice(GameKeys.SPOCK_CHOICE);
    }
    result = game.play();
    Intent intent = new Intent(this.getActivity(), ResultActivity.class);
    intent.putExtra(EXTRA_PLAYER_SELECTION, game.getPlayerChoice());
    intent.putExtra(EXTRA_ANDROID_SELECTION, game.getAndroidChoice());
    intent.putExtra(EXTRA_GAME_MESSAGE, result);
    String transitionName = this.getActivity()
      .getString(R.string.result_image);
    ActivityOptionsCompat transitionActivityOptions =
      ActivityOptionsCompat.makeSceneTransitionAnimation(
        this.getActivity(), item, transitionName
      );
    startActivity(intent, transitionActivityOptions.toBundle());
  }


}
