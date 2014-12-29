package com.sakebook.android.sample.propertysample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

// BuildConfigはimportしなくてよい。
// 異なるModuleのBuildConfigをimportしないように注意。

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 特別な処理を加えたいとき
        if (!TextUtils.isEmpty(BuildConfig.STR)) {
            findViewById(R.id.layout_main).setBackgroundColor(Color.parseColor("#29B6F6"));
        }

        if (BuildConfig.BOOL) {
            ((TextView)findViewById(R.id.text_current_time)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.text_current_time)).setText(new Date().toString());
        }

        ((TextView)findViewById(R.id.text_string_property)).setText("STR: " + BuildConfig.STR);
        ((TextView)findViewById(R.id.text_int_property)).setText("UINT: " + BuildConfig.UINT);
        ((TextView)findViewById(R.id.text_boolean_property)).setText("BOOL: " + BuildConfig.BOOL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
