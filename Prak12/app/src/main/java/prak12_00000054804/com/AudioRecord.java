package prak12_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class AudioRecord extends AppCompatActivity {
    private static MediaRecorder mediaRecorder;
    private static MediaPlayer mediaPlayer;

    private static String audioFilePath;
    private static Button btnStop;
    private static Button btnRecord;
    private static Button btnPlay;

    private boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);

        btnRecord = (Button) findViewById(R.id.btnRecord);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        
        if(!hasMicrophone()){
            btnRecord.setEnabled(false);
            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);
        }
        else{
            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);
        }

        audioFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myaudio.3gp";
    }

    private boolean hasMicrophone() {
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)){
            return true;
        }
        else{
            return false;
        }
    }
    public void recordAudio(View view) throws IOException{
        isRecording = true;
        btnStop.setEnabled(true);
        btnPlay.setEnabled(false);
        btnRecord.setEnabled(false);

        try{
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(audioFilePath);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        mediaRecorder.start();
    }

    public void stopAudio(View view){
        btnStop.setEnabled(false);
        btnPlay.setEnabled(true);

        if(isRecording){
            btnRecord.setEnabled(false);
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
            isRecording = false;
        }
        else{
            mediaRecorder.release();
            mediaPlayer = null;
            btnRecord.setEnabled(true);
        }
    }
    public void playAudio( View view) throws IOException{
        btnPlay.setEnabled(false);
        btnRecord.setEnabled(false);
        btnStop.setEnabled(true);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(audioFilePath);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }
}