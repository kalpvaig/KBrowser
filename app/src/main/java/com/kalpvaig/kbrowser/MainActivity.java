package com.kalpvaig.kbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.kalpvaig.kbrowser.Setting.Prefs;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(Prefs.getPreference(this,"appname","KBrowser"));

        String url = Prefs.getPreference(this,"url","http://kalpvaig.com");

        webView = (WebView) findViewById(R.id.website);
        webView.loadUrl(url);

    }
}
