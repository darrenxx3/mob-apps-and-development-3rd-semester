package prak12_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        Button btnVideo = (Button) findViewById(R.id.btnVideoPlay);
        Button btnAudioPlay = (Button) findViewById(R.id.btnAudioPlay);
        Button btnAudioRecord = (Button) findViewById(R.id.btnAudioRecord);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CaptureCamera.class);
                startActivity(intent);
            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayback.class);
                startActivity(intent);
            }
        });
        btnAudioPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AudioPlay.class);
                startActivity(intent);
            }
        });
        btnAudioRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AudioRecord.class);
            }
        });
    }
}