package com.sezzh.rpsls.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sezzh.rpsls.R;
import com.sezzh.rpsls.domain.Game;
import com.sezzh.rpsls.domain.GameKeys;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by sezzh on 14/03/2016.
 */
public class SelectionFragment extends Fragment {

  ArrayList<ImageView> buttonsArray = new ArrayList<>();
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
        public void onClick(View v) {
          startGame(v);
        }
      });
      buttonsArray.add(button);
    }
    return root;

  }

  private void startGame(View item) {
    HashMap<String, String> conclusions;
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
    conclusions = game.play();

  }


}
