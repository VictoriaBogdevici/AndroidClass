package com.example.conted.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
        Button button;
        WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        button=findViewById(R.id.button);
        webView=findViewById(R.id.web);
    }

    public void showWeb(View view) {
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.amazon.ca/");
    }

    @Override
    public void onBackPressed() {
       if(webView.canGoBack())
           webView.goBack();
       else super.onBackPressed();
    }
}
