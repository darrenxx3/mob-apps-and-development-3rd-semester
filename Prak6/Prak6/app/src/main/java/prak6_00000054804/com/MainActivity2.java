package prak6_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //
        Button buttontambah = findViewById(R.id.buttontambah);
        Button buttonkurang = findViewById(R.id.buttonkurang);
        Button buttonperkalian = findViewById(R.id.buttonperkalian);

        //ketika diklik maka akan memunculkan activity tambah ke menuju fragment3 di mainactivity2.
        buttontambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PenjumlahanActivity());
            }
        });
        //ketika diklik maka akan memunculkan activity kurang ke menuju fragment3 di mainactivity2.
        buttonkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PenguranganActivity());
            }
        });
        //ketika diklik maka akan memunculkan activity kalian ke menuju fragment3 di mainactivity2.
        buttonperkalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PerkalianActivity());
            }
        });

    }

    //panggilan supaya fragmentnya bisa berubah ubah pada 1 activity ketika diklik tombol lain.
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmanager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragmanager.beginTransaction();
        fragTransaction.replace(R.id.frame3, fragment);
        fragTransaction.commit();

    }
}