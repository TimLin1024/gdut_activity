package com.rdc.gdut_activity.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.rdc.gdut_activity.R;
import com.rdc.gdut_activity.presenter.LoginPresenter;
import com.rdc.gdut_activity.ui.viewinterface.ILoginView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {


    @InjectView(R.id.et_login_username)
    EditText etUsername;
    @InjectView(R.id.et_login_password)
    EditText etPassword;
    @InjectView(R.id.btn_login_login)
    Button btnLoginLogin;
    @InjectView(R.id.login_progress)
    ProgressBar mLoginProgress;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        initEvent();
    }

    private void initEvent() {
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void showProgress(int visibility) {
        mLoginProgress.setVisibility(visibility);
    }

    @Override
    public String getUserPhone() {
        return etUsername.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return etPassword.getText().toString();
    }

    @OnClick(R.id.btn_login_login)
    public void onViewClicked() {
        mLoginPresenter.login();
    }
}

