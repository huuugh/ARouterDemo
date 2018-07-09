package com.zje.arouterdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zje.data_moudle.User;

import butterknife.Bind;
import butterknife.ButterKnife;

@Route(path = "/main/activity")
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_simple)
    Button btSimple;
    @Bind(R.id.bt_with_data)
    Button btWithData;
    @Bind(R.id.bt_for_result)
    Button btForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleJump();
            }
        });

        btWithData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withDataJump();
            }
        });

        btForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpForResult();
            }
        });
    }

    private void simpleJump() {
        ARouter.getInstance().build("/test/activity")
                //可以添加跳转动画
                //.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                .navigation();
    }

    private void withDataJump() {
        ARouter.getInstance().build("/test/activity")
                //可以添加跳转动画
                //.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                .withLong("key1", 666L)
                .withString("key3", "888")
                .withObject("key4", new User("Jack", "male"))
                .navigation();
    }

    private void jumpForResult() {
        ARouter.getInstance().build("/test/activity")
                //可以添加跳转动画
                //.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                .navigation(this,666);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String key1 = data.getStringExtra("key1");
        String key2 = data.getStringExtra("key2");
        Toast.makeText(this, key1+"---"+key2, Toast.LENGTH_SHORT).show();
    }
}
