package prak6_00000054804.com;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PenjumlahanActivity extends Fragment {

    EditText numtambah, numtambah2, hasiljumlahan;
    Button btnJumlah;
    Double num1, num2;


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_penjumlahan, container, false);

        numtambah=view.findViewById(R.id.numtambah);
        numtambah2=view.findViewById(R.id.numtambah2);
        btnJumlah=view.findViewById(R.id.btnJumlah);
        hasiljumlahan=view.findViewById(R.id.hasiljumlahan);

        //Melakukan hasil perhitungan
        Button btnaddition = (Button) view.findViewById(R.id.btnJumlah);
        btnaddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=Double.parseDouble(numtambah.getText().toString());
                num2=Double.parseDouble(numtambah2.getText().toString());
                Double result = num1+num2;
                hasiljumlahan.setText(String.valueOf(result));

            }
        });
        return view;
    }
}