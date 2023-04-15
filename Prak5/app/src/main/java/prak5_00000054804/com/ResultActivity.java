package prak5_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtHasil = (TextView) findViewById(R.id.txtHasil);
        Intent b = getIntent();
        String name = "Nama : "+b.getStringExtra("name");
        String jenisK = "Jenis Kelamin : "+b.getStringExtra("jenisK");
        String umur = "Umur : "+b.getStringExtra("umur");
        String alamat = "Alamat : "+b.getStringExtra("alamat");
        String telpon = "NoTelp : "+b.getStringExtra("telpon");
        txtHasil.setText(name+"\n"+jenisK+"\n"+umur+"\n"+alamat+"\n"+telpon);



    }
}