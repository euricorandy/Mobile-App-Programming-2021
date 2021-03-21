package umn.ac.utsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin, btnProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.login_button);
        btnProfil = findViewById(R.id.profil_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent halamanLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(halamanLogin);
            }
        });

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent halamanProfil = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(halamanProfil);
            }
        });
    }
}