// Generated by view binder compiler. Do not edit!
package com.example.ridingbud.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button backBtn;

  @NonNull
  public final Button signupBtn;

  @NonNull
  public final ConstraintLayout signupEmail;

  @NonNull
  public final EditText signupEmailEditText;

  @NonNull
  public final LinearLayout signupEmailTitle;

  @NonNull
  public final ConstraintLayout signupId;

  @NonNull
  public final Button signupIdBtn;

  @NonNull
  public final EditText signupIdEditText;

  @NonNull
  public final ConstraintLayout signupIdInput;

  @NonNull
  public final LinearLayout signupIdTitle;

  @NonNull
  public final ConstraintLayout signupNickname;

  @NonNull
  public final EditText signupNicknameEditText;

  @NonNull
  public final LinearLayout signupNicknameTitle;

  @NonNull
  public final TextView signupNicknameWarn1;

  @NonNull
  public final TextView signupNicknameWarn2;

  @NonNull
  public final ConstraintLayout signupPassword;

  @NonNull
  public final EditText signupPasswordCheckEditText;

  @NonNull
  public final EditText signupPasswordEditText;

  @NonNull
  public final LinearLayout signupPasswordTitle;

  @NonNull
  public final ConstraintLayout signupState;

  @NonNull
  public final EditText signupStateEditText;

  @NonNull
  public final TextView signupStateTitle;

  @NonNull
  public final TextView signupTitle;

  private ActivitySignupBinding(@NonNull ConstraintLayout rootView, @NonNull Button backBtn,
      @NonNull Button signupBtn, @NonNull ConstraintLayout signupEmail,
      @NonNull EditText signupEmailEditText, @NonNull LinearLayout signupEmailTitle,
      @NonNull ConstraintLayout signupId, @NonNull Button signupIdBtn,
      @NonNull EditText signupIdEditText, @NonNull ConstraintLayout signupIdInput,
      @NonNull LinearLayout signupIdTitle, @NonNull ConstraintLayout signupNickname,
      @NonNull EditText signupNicknameEditText, @NonNull LinearLayout signupNicknameTitle,
      @NonNull TextView signupNicknameWarn1, @NonNull TextView signupNicknameWarn2,
      @NonNull ConstraintLayout signupPassword, @NonNull EditText signupPasswordCheckEditText,
      @NonNull EditText signupPasswordEditText, @NonNull LinearLayout signupPasswordTitle,
      @NonNull ConstraintLayout signupState, @NonNull EditText signupStateEditText,
      @NonNull TextView signupStateTitle, @NonNull TextView signupTitle) {
    this.rootView = rootView;
    this.backBtn = backBtn;
    this.signupBtn = signupBtn;
    this.signupEmail = signupEmail;
    this.signupEmailEditText = signupEmailEditText;
    this.signupEmailTitle = signupEmailTitle;
    this.signupId = signupId;
    this.signupIdBtn = signupIdBtn;
    this.signupIdEditText = signupIdEditText;
    this.signupIdInput = signupIdInput;
    this.signupIdTitle = signupIdTitle;
    this.signupNickname = signupNickname;
    this.signupNicknameEditText = signupNicknameEditText;
    this.signupNicknameTitle = signupNicknameTitle;
    this.signupNicknameWarn1 = signupNicknameWarn1;
    this.signupNicknameWarn2 = signupNicknameWarn2;
    this.signupPassword = signupPassword;
    this.signupPasswordCheckEditText = signupPasswordCheckEditText;
    this.signupPasswordEditText = signupPasswordEditText;
    this.signupPasswordTitle = signupPasswordTitle;
    this.signupState = signupState;
    this.signupStateEditText = signupStateEditText;
    this.signupStateTitle = signupStateTitle;
    this.signupTitle = signupTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back_btn;
      Button backBtn = ViewBindings.findChildViewById(rootView, id);
      if (backBtn == null) {
        break missingId;
      }

      id = R.id.signup_btn;
      Button signupBtn = ViewBindings.findChildViewById(rootView, id);
      if (signupBtn == null) {
        break missingId;
      }

      id = R.id.signup_email;
      ConstraintLayout signupEmail = ViewBindings.findChildViewById(rootView, id);
      if (signupEmail == null) {
        break missingId;
      }

      id = R.id.signup_email_editText;
      EditText signupEmailEditText = ViewBindings.findChildViewById(rootView, id);
      if (signupEmailEditText == null) {
        break missingId;
      }

      id = R.id.signup_email_title;
      LinearLayout signupEmailTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupEmailTitle == null) {
        break missingId;
      }

      id = R.id.signup_id;
      ConstraintLayout signupId = ViewBindings.findChildViewById(rootView, id);
      if (signupId == null) {
        break missingId;
      }

      id = R.id.signup_id_btn;
      Button signupIdBtn = ViewBindings.findChildViewById(rootView, id);
      if (signupIdBtn == null) {
        break missingId;
      }

      id = R.id.signup_id_editText;
      EditText signupIdEditText = ViewBindings.findChildViewById(rootView, id);
      if (signupIdEditText == null) {
        break missingId;
      }

      id = R.id.signup_id_input;
      ConstraintLayout signupIdInput = ViewBindings.findChildViewById(rootView, id);
      if (signupIdInput == null) {
        break missingId;
      }

      id = R.id.signup_id_title;
      LinearLayout signupIdTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupIdTitle == null) {
        break missingId;
      }

      id = R.id.signup_nickname;
      ConstraintLayout signupNickname = ViewBindings.findChildViewById(rootView, id);
      if (signupNickname == null) {
        break missingId;
      }

      id = R.id.signup_nickname_editText;
      EditText signupNicknameEditText = ViewBindings.findChildViewById(rootView, id);
      if (signupNicknameEditText == null) {
        break missingId;
      }

      id = R.id.signup_nickname_title;
      LinearLayout signupNicknameTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupNicknameTitle == null) {
        break missingId;
      }

      id = R.id.signup_nickname_warn_1;
      TextView signupNicknameWarn1 = ViewBindings.findChildViewById(rootView, id);
      if (signupNicknameWarn1 == null) {
        break missingId;
      }

      id = R.id.signup_nickname_warn_2;
      TextView signupNicknameWarn2 = ViewBindings.findChildViewById(rootView, id);
      if (signupNicknameWarn2 == null) {
        break missingId;
      }

      id = R.id.signup_password;
      ConstraintLayout signupPassword = ViewBindings.findChildViewById(rootView, id);
      if (signupPassword == null) {
        break missingId;
      }

      id = R.id.signup_password_check_editText;
      EditText signupPasswordCheckEditText = ViewBindings.findChildViewById(rootView, id);
      if (signupPasswordCheckEditText == null) {
        break missingId;
      }

      id = R.id.signup_password_editText;
      EditText signupPasswordEditText = ViewBindings.findChildViewById(rootView, id);
      if (signupPasswordEditText == null) {
        break missingId;
      }

      id = R.id.signup_password_title;
      LinearLayout signupPasswordTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupPasswordTitle == null) {
        break missingId;
      }

      id = R.id.signup_state;
      ConstraintLayout signupState = ViewBindings.findChildViewById(rootView, id);
      if (signupState == null) {
        break missingId;
      }

      id = R.id.signup_state_editText;
      EditText signupStateEditText = ViewBindings.findChildViewById(rootView, id);
      if (signupStateEditText == null) {
        break missingId;
      }

      id = R.id.signup_state_title;
      TextView signupStateTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupStateTitle == null) {
        break missingId;
      }

      id = R.id.signup_title;
      TextView signupTitle = ViewBindings.findChildViewById(rootView, id);
      if (signupTitle == null) {
        break missingId;
      }

      return new ActivitySignupBinding((ConstraintLayout) rootView, backBtn, signupBtn, signupEmail,
          signupEmailEditText, signupEmailTitle, signupId, signupIdBtn, signupIdEditText,
          signupIdInput, signupIdTitle, signupNickname, signupNicknameEditText, signupNicknameTitle,
          signupNicknameWarn1, signupNicknameWarn2, signupPassword, signupPasswordCheckEditText,
          signupPasswordEditText, signupPasswordTitle, signupState, signupStateEditText,
          signupStateTitle, signupTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
