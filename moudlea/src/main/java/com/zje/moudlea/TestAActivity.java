package com.zje.moudlea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSON;

import butterknife.ButterKnife;

@Route(path = "/test/activity")
public class TestAActivity extends AppCompatActivity {


/*    @Bind(R.id.displays)
    TextView toDisplay;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);
        ButterKnife.bind(this);

        TextView toDisplay = (TextView) findViewById(R.id.displays);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String key4 = (String)extras.getSerializable("key4");
        if (key4 != null){
            String name = JSON.parseObject(key4).getString("name");
            String gender = JSON.parseObject(key4).getString("gender");
            toDisplay.setText(name+"--"+gender);
        }


        Intent intent1 = new Intent();
        intent1.putExtra("key1","你猜");
        intent1.putExtra("key2","你猜不到");
        setResult(666,intent1);
    }
}
