package com.sezzh.rpsls.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sezzh.rpsls.R;

/**
 * Created by sezzh on 14/03/2016.
 */
public class SelectionFragment extends Fragment
    implements View.OnClickListener {

  private ImageView spockButton;
  private TextView testText;

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
    this.testText = (TextView) this.getActivity()
        .findViewById(R.id.selection_text_test);
    this.spockButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == this.spockButton.getId()) {
      this.spockAction();
    }
  }

  private void spockAction() {
    testText.setText("works!");
  }
}
