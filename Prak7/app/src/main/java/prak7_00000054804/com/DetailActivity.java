package prak7_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        price = (TextView)findViewById(R.id.price);

        //
        Button btn_buy = findViewById(R.id.btn_buy);
        Button btn_review =findViewById(R.id.btn_review);

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new BuyFragment());
            }
        });
        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ReviewFragment());
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }

    private void sendData() {
        Bundle bundle = new Bundle();
        bundle.putString("KEY", price.getText().toString());

        //passing data
        BuyFragment buyFragment = new BuyFragment();
         buyFragment.setArguments(bundle);

        price.setText("");

        //show
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, buyFragment).commit();
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmanager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragmanager.beginTransaction();
        fragTransaction.replace(R.id.frame, fragment);
        fragTransaction.commit();
    }
}