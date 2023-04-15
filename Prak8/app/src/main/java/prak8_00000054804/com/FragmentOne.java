package prak8_00000054804.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentOne extends Fragment {


    /*buat manggil Webviewpager*/
    WebView WEBVIEW1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_one, container, false);

        WEBVIEW1 = view.findViewById(R.id.WebView);
        WEBVIEW1.getSettings().setJavaScriptEnabled(true); //enable JS
        WEBVIEW1.setWebViewClient(new WebViewClient());
        //WEBVIEW1.loadUrl("http://www.google.com");
        WEBVIEW1.loadUrl("http://www.enterkomputer.com");

        return view;
    }

}
