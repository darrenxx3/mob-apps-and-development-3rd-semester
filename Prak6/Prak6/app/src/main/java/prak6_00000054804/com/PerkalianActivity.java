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

public class PerkalianActivity extends Fragment {
    EditText numkali, numkali2, hasilkalian;
    Button btnKali;
    Double num1,num2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_perkalian,container,false);

        numkali=view.findViewById(R.id.numkali);
        numkali2=view.findViewById(R.id.numkali2);
        btnKali=view.findViewById(R.id.btnKali);
        hasilkalian=view.findViewById(R.id.hasilkalian);

        //Melakukan hasil perhitungan
        Button btnMultiply = (Button) view.findViewById(R.id.btnKali);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=Double.parseDouble(numkali.getText().toString());
                num2=Double.parseDouble(numkali2.getText().toString());
                Double result = num1 * num2;
                hasilkalian.setText(String.valueOf(result));
            }
        });
        return view;
    }
}