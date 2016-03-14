package com.sezzh.rpsls.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sezzh.rpsls.R;
import com.sezzh.rpsls.domain.Game;

/**
 * Created by sezzh on 14/03/2016.
 */
public class SelectionFragment extends Fragment
    implements View.OnClickListener {

  public static final Integer CHOICE = 5;
  private ImageView spockButton;
  private ImageView scissorsButton;
  private ImageView rockButton;
  private ImageView paperButton;
  private ImageView lizardButton;
  private TextView resultTextView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root =
        inflater.inflate(R.layout.fragment_selection, container, false);
    return root;
  }

  @Override
  public void onStart() {
    super.onStart();
    this.spockButton = (ImageView) this.getActivity()
        .findViewById(R.id.selection_button_spock);
    this.lizardButton = (ImageView) this.getActivity()
        .findViewById(R.id.selection_button_lizard);
    this.scissorsButton = (ImageView) this.getActivity()
        .findViewById(R.id.selection_button_scissors);
    this.rockButton = (ImageView) this.getActivity()
        .findViewById(R.id.selection_button_rock);
    this.paperButton = (ImageView) this.getActivity()
        .findViewById(R.id.selection_button_paper);
    this.resultTextView = (TextView) this.getActivity()
        .findViewById(R.id.selection_result_text);
    this.spockButton.setOnClickListener(this);
    this.lizardButton.setOnClickListener(this);
    this.paperButton.setOnClickListener(this);
    this.rockButton.setOnClickListener(this);
    this.scissorsButton.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    if (v.getId() == this.scissorsButton.getId()) {
      this.startGame(0);
    }
  }

  private void startGame(Integer choice) {
    Game game = new Game(choice, this.getActivity());
    String result = game.play();
    this.resultTextView.setText(result);
  }


}
