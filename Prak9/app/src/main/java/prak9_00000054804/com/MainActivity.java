package prak9_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements AdapterView.OnItemLongClickListener{

    private MyDBHandler dbHandler;
    private ArrayList<Barang> values;
    private Button btnEdit;
    private Button btnDelete;
    private ListView list;
    Context context= MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        //buat objek untuk class MyDBhandler
        dbHandler = new MyDBHandler(MainActivity.this);

        //membuka koneksi database
        try{
            dbHandler.open();
        }catch (SQLException e){
            e.printStackTrace();
        }
        values = dbHandler.getAllBarang();

        ArrayAdapter<Barang> adapter = new ArrayAdapter<Barang>(MainActivity.this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        list = (ListView) findViewById(android.R.id.list);
        list.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) MainActivity.this);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), tambah.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
        //menampilkan dialog dan mengambil layout dari dialog.xml
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Pilih Aksi");
        dialog.show();

        final Barang barang = (Barang) getListAdapter().getItem(i);
        final long id = barang.getID();

        btnEdit = dialog.findViewById(R.id.btnEdit);
        btnDelete = dialog.findViewById(R.id.btnHapus);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Barang barang = dbHandler.getBarang(id);
                Intent i = new Intent(getApplicationContext(),edit.class);
                Bundle bundle = new Bundle();
                bundle.putLong("id", barang.getID());
                bundle.putString("nama", barang.getNamaBarang());
                bundle.putString("kategori", barang.getKategoriBarang());
                bundle.putLong("harga", barang.getHargaBarang());
                i.putExtras(bundle);
                startActivity(i);
                dialog.dismiss();
            }
        });
        // Method yang digunakan apabila button delete pada dialog xml ditekan
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder konfirm = new AlertDialog.Builder(context);
                konfirm.setTitle("Hapus Barang");
                konfirm.setMessage("Anda yakin akan menghapus barang ini?");
                konfirm.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dbHandler.deleteBarang(id);

                        //menutup mainactivity dan membuka kembalil untuk refresh konten
                        finish();
                        startActivity(getIntent());
                        Toast.makeText(MainActivity.this,"Barang berhasil dihapus", Toast.LENGTH_SHORT).show();
                    }
                });
                konfirm.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                konfirm.show();
                dialog.dismiss();
            }
        });
        return true;
    }

}