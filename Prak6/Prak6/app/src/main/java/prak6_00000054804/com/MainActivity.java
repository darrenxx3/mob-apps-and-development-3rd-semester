package prak6_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menjalankan agar activityfragment1 berjalan di main activity
        ActivityFragment1 frag1 = new ActivityFragment1();
        frag1.setArguments(getIntent().getExtras());

        ActivityFragment2 frag2 = new ActivityFragment2();
        frag2.setArguments(getIntent().getExtras());

        FragmentManager fragmanager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragmanager.beginTransaction();

        fragTransaction.add(R.id.frame1, frag1);
        fragTransaction.add(R.id.frame2, frag2);
        fragTransaction.commit();

    }
}