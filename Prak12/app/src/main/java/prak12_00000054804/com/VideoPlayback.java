package prak12_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_playback);

        VideoView videoView = (VideoView) findViewById(R.id.videoView1);
        videoView.setVideoPath("htpp://ebookfrenzy.com/android_book/movie.mp4");

        //Implementasi fungsi Mediacontroller
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();
    }
}