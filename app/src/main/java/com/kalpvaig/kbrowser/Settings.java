package com.kalpvaig.kbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kalpvaig.kbrowser.Setting.Prefs;

public class Settings extends AppCompatActivity {

    private EditText url, appname;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        url = (EditText) findViewById(R.id.url);
        appname = (EditText) findViewById(R.id.appname);

        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Prefs.saveToPreferences(Settings.this,"url",url.getText().toString());
                Prefs.saveToPreferences(Settings.this,"appname",appname.getText().toString());
            }
        });
    }

}
