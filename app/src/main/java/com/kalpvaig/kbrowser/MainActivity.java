package com.kalpvaig.kbrowser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.kalpvaig.kbrowser.Setting.Prefs;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private LinearLayout progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(Prefs.getPreference(this,"appname","KBrowser"));

        String url = Prefs.getPreference(this,"url","http://kalpvaig.com");

        progressLayout = (LinearLayout) findViewById(R.id.progressLayout);

        webView = (WebView) findViewById(R.id.website);

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                progressLayout.setVisibility(View.GONE);
            }
        });
        webView.loadUrl(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.settings) {
            startActivity(new Intent(MainActivity.this,Settings.class));
        }

        if (id==R.id.about)
            startActivity(new Intent(MainActivity.this,AboutApp.class));

        return super.onOptionsItemSelected(item);
    }


}
