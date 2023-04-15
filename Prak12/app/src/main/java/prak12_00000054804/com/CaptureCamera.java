package prak12_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class CaptureCamera extends AppCompatActivity {
    private static final int VIDEO_CAPTURE = 101;
    private static final int PHOTO_CAPTURE = 102;
    Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_camera);

        Button btnRecord = (Button) findViewById(R.id.btnRecord);
        Button btnCapture = (Button) findViewById(R.id.btnCapture);
        if (!hasCamera()) {
            btnRecord.setEnabled(false);
            btnCapture.setEnabled(false);
        }
    }
    private boolean hasCamera(){
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            return true;
        }
        else{
            return false;
        }
    }
    public void startCapture(View view){
        try{
            String random = String.valueOf(System.currentTimeMillis());
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File file = new File(Environment.getExternalStorageDirectory(),
                    "DCIM/Camera/img_" + random + ".jpg");

            fileUri= Uri.fromFile(file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

            startActivityForResult(intent, PHOTO_CAPTURE);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void startRecording(View view){
        try{
            String random = String.valueOf(System.currentTimeMillis());

            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            File file = new File(Environment.getExternalStorageDirectory(),
                    "DCIM/Video/vid_" + random + ".mp4");

            fileUri = Uri.fromFile(file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 100);

            startActivityForResult(intent, VIDEO_CAPTURE);
        }catch (Exception e){
            e.printStackTrace();

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

