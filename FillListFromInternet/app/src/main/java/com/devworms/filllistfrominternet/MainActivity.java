package com.devworms.filllistfrominternet;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.devworms.filllistfrominternet.com.devworms.utils.ImageAdapter;
import com.devworms.filllistfrominternet.com.devworms.utils.ImageDownloader;

public class MainActivity extends ListActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        setListAdapter(new ImageAdapter());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ImageDownloader.Mode mode = ImageDownloader.Mode.NO_ASYNC_TASK;

        if (checkedId == R.id.correctButton) {
            mode = ImageDownloader.Mode.CORRECT;
        }else if (checkedId == R.id.randomButton) {
            mode = ImageDownloader.Mode.NO_DOWNLOADED_DRAWABLE;
        }

        ((ImageAdapter) getListAdapter()).getImageDownloader().setMode(mode);
    }
}
