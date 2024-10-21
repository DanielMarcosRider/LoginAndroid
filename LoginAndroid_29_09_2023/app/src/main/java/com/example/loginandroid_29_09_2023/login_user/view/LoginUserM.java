package com.example.loginandroid_29_09_2023.login_user.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.MainActivity;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;

public class LoginUserM extends AppCompatActivity implements ContractLoginUser.View{

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    private LoginUserPresenter presenter =
            new LoginUserPresenter(this);

    /* PATRÓN SINGLETON*/
    private static LoginUserM mainActivity = null;
    public static LoginUserM getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);
        mainActivity = this;
        initComponents();
    }
    private void initComponents(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(mainActivity, "Por favor escriba su usuario y contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
                //sPeliculas.getDatosPeliculas();
                User user = new User("", "", "");
                user.setUsername(username);
                user.setPassword(password);
                presenter.login(user);
            }
        });
    }


    @Override
    public void successLogin(User user) {
        // Toast.makeText(mainActivity, user.getPassword(), Toast.LENGTH_SHORT).show();
        if (user != null && user.getUsername() != null){
            Toast.makeText(mainActivity, "Login Exitoso " + user.getUsername(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mainActivity, "Login Exitoso", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failureLogin(String err) {

    }
}