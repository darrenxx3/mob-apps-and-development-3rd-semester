package prak11_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button lihatAnggota, tambahAnggota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lihatAnggota=(Button) findViewById(R.id.btnMahasiswa);
        tambahAnggota=(Button) findViewById(R.id.btnTambah);

        tambahAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TambahMahasiswaActivity.class));
            }
        });

        lihatAnggota.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SemuaMahasiswaActivity.class));
        });
    }
}