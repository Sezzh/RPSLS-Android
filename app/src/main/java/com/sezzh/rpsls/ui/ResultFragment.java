package com.sezzh.rpsls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sezzh.rpsls.R;
import com.sezzh.rpsls.domain.GameKeys;

/**
 * Created by sezzh on 14/03/2016.
 */
public class ResultFragment extends Fragment {
  private ImageView mImageViewResult;
  private ImageView mImageViewAndroid;
  private String message;
  private Integer playerChoice;
  private Integer androidChoice;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = this.getActivity().getIntent();
    message = (String) intent.getExtras()
      .get(SelectionFragment.EXTRA_GAME_MESSAGE);
    playerChoice = (Integer) intent.getExtras()
      .get(SelectionFragment.EXTRA_PLAYER_SELECTION);
    androidChoice = (Integer) intent.getExtras()
      .get(SelectionFragment.EXTRA_ANDROID_SELECTION);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_result, container, false);
    this.mImageViewResult = (ImageView) root.findViewById(R.id.img_result);
    this.mImageViewAndroid =
      (ImageView) root.findViewById(R.id.result_image_android);
    this.setupDrawableChoice(this.mImageViewResult, this.playerChoice);
    this.setupDrawableChoice(this.mImageViewAndroid, this.androidChoice);
    return root;
  }

  private void setupDrawableChoice(ImageView imageView, Integer choice) {
    if (choice == GameKeys.SCISSORS_CHOICE)
      imageView.setImageResource(R.drawable.ic_scissors);
    else if (choice == GameKeys.PAPER_CHOICE)
      imageView.setImageResource(R.drawable.ic_paper);
    else if (choice == GameKeys.ROCK_CHOICE)
      imageView.setImageResource(R.drawable.ic_rock);
    else if (choice == GameKeys.LIZARD_CHOICE)
      imageView.setImageResource(R.drawable.ic_lizard);
    else if (choice == GameKeys.SPOCK_CHOICE)
      imageView.setImageResource(R.drawable.ic_spock);
  }

}
