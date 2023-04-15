package prak6_00000054804.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PenguranganActivity extends Fragment {

    EditText numkurang, numkurang2, hasilkurangan;
    Button btnKurang;
    Double num1, num2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pengurangan, container,false);

        numkurang=view.findViewById(R.id.numkurang);
        numkurang2=view.findViewById(R.id.numkurang2);
        btnKurang=view.findViewById(R.id.btnKurang);
        hasilkurangan=view.findViewById(R.id.hasilkurangan);

        //Melakukan hasil perhitungan
        Button btnSubstract = (Button) view.findViewById(R.id.btnKurang);
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=Double.parseDouble(numkurang.getText().toString());
                num2=Double.parseDouble(numkurang2.getText().toString());
                Double result = num1-num2;
                hasilkurangan.setText(String.valueOf(result));

            }
        });
        return view;
    }
}