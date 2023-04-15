package prak5_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity1 = (Button) findViewById(R.id.btnActivity1);
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActivityOne.class);
                startActivity(i);
            }
        });

        Button btnActivity2 = (Button) findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(),ActivityTwo.class);
                startActivity(j);
            }
        });

        Button btnActivity3 = (Button) findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(getApplicationContext(),ActivityThree.class);
                startActivity(k);
            }
        });

        Button btnActivity4 = (Button) findViewById(R.id.btnActivity4);
        btnActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(getApplicationContext(),ActivityFour.class);
                startActivity(l);
            }
        });
        Button btnForm = (Button) findViewById(R.id.btnForm);
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtName = (EditText) findViewById(R.id.edtName);
                Intent m = new Intent(getApplicationContext(),FormActivity.class);
                m.putExtra("nama",edtName.getText().toString());
                startActivity(m);
            }
        });
        //buka form ke-2

    }

}