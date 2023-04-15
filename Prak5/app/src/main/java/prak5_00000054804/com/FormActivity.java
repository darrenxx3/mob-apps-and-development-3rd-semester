package prak5_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinnerkelamin;
    private String[] jk = {"-Pilih Jenis Kelamin-","Laki-laki","Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        TextView txtHello = (TextView) findViewById(R.id.txtHello);
        Intent i = getIntent();
        //String nama = "Hello "+i.getStringExtra("nama")+"!";
        String nama = i.getStringExtra("nama")+"!";
        txtHello.setText(nama);

        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtHello = (TextView)findViewById(R.id.txtHello);
                EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
                EditText editTextTextMultiLine = (EditText)findViewById(R.id.editTextTextMultiLine);
                EditText editTextPhone = (EditText)findViewById(R.id.editTextPhone);
                Spinner spinnerkelamin = (Spinner)findViewById(R.id.spinnerkelamin);
                Intent a = new Intent(getApplicationContext(),ResultActivity.class);
                a.putExtra("name", txtHello.getText().toString());
                a.putExtra("jenisK", spinnerkelamin.getSelectedItem().toString());
                a.putExtra("umur",editTextNumber.getText().toString());
                a.putExtra("alamat", editTextTextMultiLine.getText().toString());
                a.putExtra("telpon",editTextPhone.getText().toString());
                startActivity(a);
            }
        });
        spinnerkelamin =(Spinner) findViewById(R.id.spinnerkelamin);
        spinnerkelamin.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,jk);
        spinnerkelamin.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}