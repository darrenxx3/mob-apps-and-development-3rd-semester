package prak3_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*Apa yang berbeda antara design Linear Layout Horizontal dengan
Vertical? Jawab dengan memberikan komentar pada
MainActivity.java!
- linear layout horizontal = mengubah semua elemen ke arah horizontal 1 arah dengan parent
- linear layout vertical = mengubah semua elemen ke arah vertikal 1 arah dengan parent, diatur lewat
layout height atau width*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}