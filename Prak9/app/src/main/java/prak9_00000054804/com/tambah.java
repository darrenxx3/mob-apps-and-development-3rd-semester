package prak9_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tambah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        final EditText edtNama = (EditText) findViewById(R.id.edtNama);
        final EditText edtKategori = (EditText) findViewById(R.id.edtKategori);
        final EditText edtHarga = (EditText) findViewById(R.id.edtHarga);

        Button btnReset = (Button) findViewById(R.id.btnReset);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        //buat objeck untuk class MyDBHandler
        final MyDBHandler dbHandler = new MyDBHandler(this);

        //membuka koneksi database
        try {
            dbHandler.open();
        }catch (SQLException e){
            e.printStackTrace();
        }
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Barang barang = new Barang();
                String nama = edtNama.getText().toString();
                String kategori = edtKategori.getText().toString();
                long harga = Long.parseLong(edtHarga.getText().toString());
                dbHandler.createBarang(nama, kategori, harga);

                Toast.makeText(tambah.this, "Barang berhasil ditambahkan", Toast.LENGTH_LONG).show();
                edtNama.setText("");
                edtKategori.setText("");
                edtHarga.setText("");
                edtNama.requestFocus();

                Intent i =  new Intent(tambah.this, MainActivity.class);
                startActivity(i);
                tambah.this.finish();
                dbHandler.close();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNama.setText("");
                edtKategori.setText("");
                edtHarga.setText("");
                edtNama.requestFocus();

                Intent i = new Intent(tambah.this, MainActivity.class);
                startActivity(i);
                tambah.this.finish();
                dbHandler.close();
            }
        });
    }
}