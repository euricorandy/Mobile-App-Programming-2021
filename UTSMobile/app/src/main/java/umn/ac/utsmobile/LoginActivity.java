package umn.ac.utsmobile;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password;
    private Button login;
    Dialog popupLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.etusername);
        password = (EditText) findViewById(R.id.etpassword);
        login = (Button) findViewById(R.id.etlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void Validate(String userName, String passWord){
        if(userName.equals("uasmobile") && passWord.equals("uasmobilegenap")){
            Intent intent = new Intent(LoginActivity.this, LaguActivity.class);
            startActivity(intent);
        }else {
            popupLogin = new Dialog(this);
            ShowPopup();
        }
    }

    public void ShowPopup(){
        Button cls_popup;
        popupLogin.setContentView(R.layout.login_popup);
        cls_popup = (Button) popupLogin.findViewById(R.id.cls_poplogin);

        cls_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupLogin.dismiss();
            }
        });
        popupLogin.show();
    }
}
