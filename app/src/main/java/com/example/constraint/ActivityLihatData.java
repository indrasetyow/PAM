package com.example.constraint;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylihatdata);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");
        String nomor = bundle.getString("b");

        nomor=tvnomor.getText().toString();




        switch (nama) {
            case "arip":
                tvnama.setText("ärip");
                tvnomor.setText("087788789679");
                break;
            case "fikri":
                tvnama.setText("fikri");
                tvnomor.setText("0877887876479");
                break;
            case "indro":
                tvnama.setText("indro");
                tvnomor.setText("087785689679");
                break;
            case "aan":
                tvnama.setText("aan");
                tvnomor.setText("087756565669");
                break;
            case "dika":
                tvnama.setText("dika");
                tvnomor.setText("0898772476546");
                break;
            case "riska":
                tvnama.setText("riska");
                tvnomor.setText("0877887874679");
                break;
            case "dita":
                tvnama.setText("dita");
                tvnomor.setText("087788789549");
                break;

        }
    }


}
