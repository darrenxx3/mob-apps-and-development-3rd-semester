package prak11_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.HashMap;

public class SemuaMahasiswaActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ListView lv;
    ArrayList<HashMap<String , String>> list_anggota;
    String url_get_mahasiswa = "";
    private static final String TAG_MAHASISWA = "mahasiswa";
    private static final String TAG_ID = "id";
    private static final String TAG_NAMA ="nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semua_mahasiswa);

        list_anggota = new ArrayList<>();
        lv =findViewById(R.id.listview);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        RequestQueue queue = Volley.newRequestQueue(SemuaMahasiswaActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_get_mahasiswa,
                new Response.Listener<String>(){
            @Override
                    public void onResponse(String response){
                try{
                    JSONObject jboj = new JSONObject(response);
                    JSONArray member = jboj.optJSONArray(TAG_MAHASISWA);
                    for (int i = 0; i < member.length(); i++{
                        JSONObject a = member.getJSONObject(i);
                        String id = a.getString(TAG_ID);
                        String nama = a.getString(TAG_NAMA);

                        HashMap<String, String> map = new Hashmap<>();
                        map.put("id", id);
                        map.put("nama", nama);
                        list_anggota.add(map);
                    }
                    progressBar.setVisibility(View.GONE););

                    ListAdapter adapter = new SimpleAdapter(
                            SemuaMahasiswaActivity.this, R.layout.list_item, new String[]{
                                    TAG_ID, TAG_NAMA}, new int[]{R.id.edtIDdarilayout, R.id.edtNamadarilayout});
                    lv.setAdapter(adapter);

                    } catch (Exception ex){
                    Log.e("Error", ex.toString());
                    progressBar.setVisibility(View.GONE);
                    )
                }
            }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.e("Error", error.getMessage());
                Toast.makeText(SemuaMahasiswaActivity.this, "Silahkan cek koneksi internet " + "Anda!", Toast.LENGTH_SHORT).show();
                finish();
            }
                });
    }
}
queue.add(stringRequest);