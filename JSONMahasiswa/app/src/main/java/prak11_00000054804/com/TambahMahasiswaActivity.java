package prak11_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TambahMahasiswaActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText edtNama;
    EditText edtAlamat;
    Button btnTambah;
    String nama, alamat;
    String url_tambah_anggota = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mahasiswa);

        edtNama= findViewById(R.id.edtNama);
        edtAlamat=findViewById(R.id.edtAlamat);
        btnTambah=findViewById(R.id.btnTambah);
        progressBar=findViewById(R.id.progressBar);

        btnTambah.setOnClickListener((view -> {
            nama= edtNama.getText().toString();
            alamat=edtAlamat.getText().toString();
            progressBar.setVisibility(View.VISIBLE);
            RequestQueue queue = Volley.newRequestQueue(TambahMahasiswaActivity.this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    url_tambah_anggota, new Response.Listener<String>(){

                @Override
                public void onResponse(String response){
                    try{
                        JSONObject jboj =new JSONObject(response);
                        int sukses = jboj.getInt("success");
                        if (sukses ==1){
                            Toast.makeText(TambahMahasiswaActivity.this, "Data Mahasiswa " + "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(TambahMahasiswaActivity.this, "Data Mahasiswa " + "Gagal Disimpan, Silahkan Coba Lagi", Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.GONE);

                }
            }

        }, new Response.ErrorListener(){
               @Override
               public void onErrorResponse(VolleyError error){
                   Log.e("Error", error.getMessage());
                   Toast.makeText(TambahMahasiswaActivity.this,"Silahkan cek koneksi " + "internet Anda!", Toast.LENGTH_SHORT).show();
                   progressBar.setVisibility(View.GONE);
               }
            }

            @Override
                    protected  Map<String, String>getParams(){
                Map<String, String> params=new HashMap<~>();
                params.put("nama", nama);
                params.put("alamat", alamat);

                return params;
            }

            @Override
                    public map<String, String> getHeaders() throws AuthFailureError{
                Map<String , String> params = new HashMap<~>();
                params.put("Contet-Type", "application/x-www-urlencoded");
                return params;
            }
    };
        queue.getCache().clear();
        queue.add(strinRequest);
}});