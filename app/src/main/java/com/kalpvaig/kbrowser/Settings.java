package com.kalpvaig.kbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kalpvaig.kbrowser.Setting.Prefs;

public class Settings extends AppCompatActivity {

    private EditText url, appname;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        url = (EditText) findViewById(R.id.url);
        appname = (EditText) findViewById(R.id.appname);

        url.setText(Prefs.getPreference(this,"url","http://kalpvaig.com"));
        appname.setText(Prefs.getPreference(this,"appname","KBrowser"));
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Prefs.saveToPreferences(Settings.this,"url",url.getText().toString());
                Prefs.saveToPreferences(Settings.this,"appname",appname.getText().toString());

                Toast.makeText(Settings.this, "Successfully Saved", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Settings.this,MainActivity.class));

            }
        });
    }

}
