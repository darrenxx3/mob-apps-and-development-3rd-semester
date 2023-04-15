/*
CHALLENGE
Jelaskan mengapa activity lifecycle diatas dapat mengalami perubahan
pada setiap action yang sudah dipraktikkan sebelumnya?

*Karena pada activity lifecycle diatas merupakan Android process state
dimana proses tersebut melewati 5 proses prioritas
dari Foreground process -> Visible process -> Service
process -> Background Process -> Empty Process. Contohnya ketika user membuka recent apps
maka sistem android akan mendeteksi adanya perubahan panggilan dari start menjadi onPause
kemudian beralih ke onStop, hal ini dilakukan melalui prioritas tertinggi maupuan prioritas
terendah.

button:
2022-08-30 15:17:46.909 9197-9197/prak2_00000054804.com I/aksi: Tombol 1 di klik
*/

package prak2_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log; //untuk mengimport log yang akan dimasukkan ke Android
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("posisi","onCreate");
        Button tombol1 = (Button) findViewById(R.id.button3);
        tombol1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("aksi","Tombol 1 di klik");
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("posisi","onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("posisi","onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("posisi","onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("posisi","onStop");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("posisi","onRestart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("posisi","onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i("posisi","onSaveInstanceState");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("posisi","onRestoreInstanceState");
    }
}

//Android Monitor berubah namanya menjadi Logcat yang terdapat pada bagian bawah Apps
//android studio//

/*skrg kita hanya perlu menampilkan log yang kita sudah buat saja bagaimana caranya?
yaitu dengan cara  mengclick bagian kanan "show only selected applications, kita menuju
bagian "edit filter configuration" -> disana kita perlu mengisi filter name nya sesuai
keinginan kita -> log tag nya juga perlu isi dengan 'posisi'. nanti dibagian bawah akan
menampilkan filter yang sudah kita buat dengan tag posisi. bila ingin melihat perubahan
maka bisa mengclick button 'recent apps' pada hape maka nanti lognya akan terupdate
sesuai kondisi hape yang sedang dijalankan. perubahan lainnya bisa kita lihat dengan cara
mengubah orientasi hape horizontal maupun vertikal sehingga bagian log mengalami
perubahan.*/