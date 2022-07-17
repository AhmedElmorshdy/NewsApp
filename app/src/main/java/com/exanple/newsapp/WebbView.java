package com.exanple.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebbView extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webb_view);
        webView = findViewById(R.id.web);
        Intent intent = getIntent();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(intent.getStringExtra("url"));
    }
}