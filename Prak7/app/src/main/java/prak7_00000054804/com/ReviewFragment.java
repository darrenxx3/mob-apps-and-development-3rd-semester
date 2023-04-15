package prak7_00000054804.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReviewFragment extends Fragment {

    EditText edt_name, edt_phone, edt_review;
    public ReviewFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_review_fragment, container, false);

        //btn_submit=view.findViewById(R.id.btn_submit);
        //edt_name nama =view.findViewById(R.id.edt_name);
        //edt_phone=view.findViewById(R.id.edt_phone);
       // EditText nama = view.findViewById()

        edt_name =view.findViewById(R.id.edt_name);
        edt_phone =view.findViewById(R.id.edt_phone);
        edt_review=view.findViewById(R.id.edt_review);

         Button submitreview = (Button) view.findViewById(R.id.btn_submit);
         submitreview.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                 dialog.setTitle("Review");
                 dialog.setMessage("Nama         : "+edt_name.getText().toString()+"\n"+
                                   "Phone Number : "+edt_phone.getText().toString()+"\n"+
                                   "Review:\n"+edt_review.getText().toString());
                 dialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Toast.makeText(getContext(),"Thank you for review the book", Toast.LENGTH_SHORT).show();
                     }
                 });
                 dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });
                 dialog.show();
             }
         });
         return view;
    }

}