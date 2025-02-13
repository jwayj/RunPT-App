// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignup3Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextView signupCompleteMessage;

  @NonNull
  public final TextView signupCompleteTitle;

  private ActivitySignup3Binding(@NonNull LinearLayout rootView, @NonNull Button loginButton,
      @NonNull TextView signupCompleteMessage, @NonNull TextView signupCompleteTitle) {
    this.rootView = rootView;
    this.loginButton = loginButton;
    this.signupCompleteMessage = signupCompleteMessage;
    this.signupCompleteTitle = signupCompleteTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignup3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignup3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignup3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.login_button;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.signup_complete_message;
      TextView signupCompleteMessage = ViewBindings.findChildViewById(rootView, id);
      if (signupCompleteMessage == null) {
        break missingId;
      }

      id = R.id.signup_complete_title;
      TextView signupCompleteTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupCompleteTitle == null) {
        break missingId;
      }

      return new ActivitySignup3Binding((LinearLayout) rootView, loginButton, signupCompleteMessage,
          signupCompleteTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
