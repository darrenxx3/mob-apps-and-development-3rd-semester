package prak4_00000054804.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //private Spinner spinAsal;
    String[] spinAsal = {"-Pilih Negara Asal-","Australia","Belanda","Brunei Darussalam","Filipina","Indonesia","Jepang",
            "Malaysia","Singapore","Taiwan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
            Button btnRegister = (Button) findViewById(R.id.btnRegister);
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText txtnama =(EditText) findViewById(R.id.txtnama);
                    String nama = txtnama.getText().toString();
                    //
                    EditText txtEmail =(EditText) findViewById(R.id.txtEmail);
                    String email = txtEmail.getText().toString();
                    //
                    EditText txtPhone =(EditText) findViewById(R.id.txtPhone);
                    String phonenum = txtPhone.getText().toString();
                    //

                    Spinner spin =(Spinner) findViewById(R.id.spinAsal);
                    spin.setOnItemSelectedListener(RegisterActivity.this);

                    ArrayAdapter adapter = new ArrayAdapter(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item,spinAsal);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin.setAdapter(adapter);



                    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                    dialog.setTitle("Data Register");
                    dialog.setMessage("Apakah data yang Anda masukkan sudah benar?\n"+
                                      "Nama  : "+nama+"\n"+
                                      "Email : "+email+"\n"+
                                      "Telp  : "+phonenum+"\n"+
                                      "Asal  : "+spin);
                    dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"Data Registrasi Anda berhasil disimpan",Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }
            });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}



