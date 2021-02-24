package id.ac.umn.week4b_28869;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button hal1, hal2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hal1 = findViewById(R.id.main_button_change_1);
        hal2 = findViewById(R.id.main_button_change_2);

        hal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent1,1);
            }
        });

        hal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,ThirdActivity.class);
                startActivityForResult(intent2,2);
            }
        });
    }
}
