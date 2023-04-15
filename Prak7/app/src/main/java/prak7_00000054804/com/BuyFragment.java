package prak7_00000054804.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BuyFragment extends Fragment {
    private TextView text_price;

    public BuyFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.activity_buy_fragment, container, false);


       text_price= (TextView) view.findViewById(R.id.text_price);

       String harga =this.getArguments().getString("KEY").toString();
       text_price.setText(harga);

       return view;




    }

}