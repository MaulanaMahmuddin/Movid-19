package com.example.movid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class web_mengobati extends AppCompatActivity {

    private WebView webb;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_mengobati);


        back = findViewById(R.id.finish);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webb = findViewById(R.id.webView3);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl("https://www.who.int/news-room/q-a-detail/q-a-coronaviruses#:~:text=protect");
    }
}
