package id.ac.umn.week02_28869;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    TextView hasil;
    Button btnTambah, btnKurang, btnKali, btnBagi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = this.findViewById(R.id.angka1);
        angka2 = this.findViewById(R.id.angka2);
        hasil = this.findViewById(R.id.hasil);
        btnTambah = this.findViewById(R.id.btnTambah);
        btnKurang = this.findViewById(R.id.btnKurang);
        btnKali = this.findViewById(R.id.btnKali);
        btnBagi = this.findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

    protected void hitung(char operator){
        {
            if (angka1.getText().toString().isEmpty() || angka2.getText().toString().isEmpty()) {
                hasil.setText("Mohon mengisi semua angka dengan benar");
                return;
            }
        }
        double operand1 = Double.parseDouble(angka1.getText().toString());
        double operand2 = Double.parseDouble(angka2.getText().toString());
        double result = 0.0;
        switch (operator){
            case ('+'): result = operand1 + operand2; break;
            case ('-'): result = operand1 - operand2; break;
            case ('*'): result = operand1 * operand2; break;
            case ('/'): result = operand1 / operand2;
        }
        hasil.setText(String.valueOf(result));
    }
}
