// Generated by view binder compiler. Do not edit!
package com.example.ridingbud.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ridingbud.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView findIdBtn;

  @NonNull
  public final TextView findPasswordBtn;

  @NonNull
  public final EditText idEt;

  @NonNull
  public final ImageButton kakaoLoginBtn;

  @NonNull
  public final Button loginBtn;

  @NonNull
  public final LinearLayout loginOption;

  @NonNull
  public final TextView loginTitle;

  @NonNull
  public final EditText passwordEt;

  @NonNull
  public final TextView signupBtn;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull TextView findIdBtn,
      @NonNull TextView findPasswordBtn, @NonNull EditText idEt, @NonNull ImageButton kakaoLoginBtn,
      @NonNull Button loginBtn, @NonNull LinearLayout loginOption, @NonNull TextView loginTitle,
      @NonNull EditText passwordEt, @NonNull TextView signupBtn) {
    this.rootView = rootView;
    this.findIdBtn = findIdBtn;
    this.findPasswordBtn = findPasswordBtn;
    this.idEt = idEt;
    this.kakaoLoginBtn = kakaoLoginBtn;
    this.loginBtn = loginBtn;
    this.loginOption = loginOption;
    this.loginTitle = loginTitle;
    this.passwordEt = passwordEt;
    this.signupBtn = signupBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.find_id_btn;
      TextView findIdBtn = ViewBindings.findChildViewById(rootView, id);
      if (findIdBtn == null) {
        break missingId;
      }

      id = R.id.find_password_btn;
      TextView findPasswordBtn = ViewBindings.findChildViewById(rootView, id);
      if (findPasswordBtn == null) {
        break missingId;
      }

      id = R.id.id_et;
      EditText idEt = ViewBindings.findChildViewById(rootView, id);
      if (idEt == null) {
        break missingId;
      }

      id = R.id.kakao_login_btn;
      ImageButton kakaoLoginBtn = ViewBindings.findChildViewById(rootView, id);
      if (kakaoLoginBtn == null) {
        break missingId;
      }

      id = R.id.login_btn;
      Button loginBtn = ViewBindings.findChildViewById(rootView, id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.login_option;
      LinearLayout loginOption = ViewBindings.findChildViewById(rootView, id);
      if (loginOption == null) {
        break missingId;
      }

      id = R.id.login_title;
      TextView loginTitle = ViewBindings.findChildViewById(rootView, id);
      if (loginTitle == null) {
        break missingId;
      }

      id = R.id.password_et;
      EditText passwordEt = ViewBindings.findChildViewById(rootView, id);
      if (passwordEt == null) {
        break missingId;
      }

      id = R.id.signup_btn;
      TextView signupBtn = ViewBindings.findChildViewById(rootView, id);
      if (signupBtn == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, findIdBtn, findPasswordBtn, idEt,
          kakaoLoginBtn, loginBtn, loginOption, loginTitle, passwordEt, signupBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
