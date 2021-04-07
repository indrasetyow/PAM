package com.example.constraint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edemail, edpassword;
    Button btnsignin, btnblmdaftar;
    String nama,password;

//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.mnDaftar)
//        {
//            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
//            startActivity(i);
//        }
//        return super.onOptionsItemSelected(item);
//    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnsignin=findViewById((R.id.signIn));
        edemail=findViewById(R.id.Email);
        edpassword=findViewById(R.id.Password);
        btnblmdaftar=findViewById(R.id.btndftr);

        btnblmdaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(intent);
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                String email = "indrasetyow";
                String pass = "123";

                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                if (nama.equals(email) && password.equals(pass))
                {
                    Toast a = Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG);
                    a.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel password dengan kunci "a"
                    // dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b"
                    //dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke activityhasil
                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                    //memasukkan bundle kedalam intent untuk dikrimkan ke ActivityHasil
                    i.putExtras(b);

                    //berpindah ke Home_Activity
                    startActivity(i);
                }
                else if (nama.equals(email) || pass.equals(password))
                {
                    if(nama.equals(email)) {
                        Toast ps = Toast.makeText(getApplicationContext(),"Password Salah", Toast.LENGTH_LONG);
                        ps.show();
                    }
                    else {
                        Toast es = Toast.makeText(getApplicationContext(), "Email salah", Toast.LENGTH_LONG);
                        es.show();
                    }
                }
                else {
                    Toast m = Toast.makeText(getApplicationContext(), "email dan password salah", Toast.LENGTH_LONG);
                    m.show();
                }
            }

        });


    }


}