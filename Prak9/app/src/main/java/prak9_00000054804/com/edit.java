package prak9_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    private long id;
    private String nama;
    private String kategori;
    private long harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final EditText edtNama = (EditText) findViewById(R.id.edtNama);
        final EditText edtKategori = (EditText) findViewById(R.id.edtKategori);
        final EditText edtHarga = (EditText) findViewById(R.id.edtHarga);
        Button btnReset = (Button) findViewById(R.id.btnReset);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        //buat objek untuk class MyDBHandler
        final MyDBHandler dbHandler = new MyDBHandler(this);

        //membuka koneksi database
        try {
            dbHandler.open();
        }catch (SQLException e){
            e.printStackTrace();
        }
        Bundle bundle = this.getIntent().getExtras();
        id = bundle.getLong("id");
        nama = bundle.getString("nama");
        kategori = bundle.getString("kategori");
        harga = bundle.getLong("harga");

        this.setTitle("Edit Barang ID: "+id);
        edtNama.setText(nama);
        edtKategori.setText(kategori);
        edtHarga.setText(Long.toString(harga));

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Barang barang = new Barang();
                barang.setID(id);
                barang.setNamaBarang(edtNama.getText().toString());
                barang.setKategoriBarang(edtKategori.getText().toString());

                dbHandler.updateBarang(barang);
                Toast.makeText(edit.this, "Barang berhasil diedit", Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(edit.this, MainActivity.class);
                startActivity(i);
                edit.this.finish();
                dbHandler.close();
            }
        });
    }
}