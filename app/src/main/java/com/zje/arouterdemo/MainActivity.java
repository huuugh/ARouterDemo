package com.zje.arouterdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zje.data_moudle.User;
import com.zje.moudlea.HelloService;

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
    @Bind(R.id.bt_uri)
    Button btUri;

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

        btUri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpByUri();
            }
        });

        //发现服务
        ((HelloService) ARouter.getInstance().build("/service/helloservice").navigation()).sayHello("micro name ");
    }

    private void jumpByUri() {
        ARouter.getInstance().build(Uri.parse("/test/activity"))
                //可以添加跳转动画
                //.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                .navigation();
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
                //绿色通道，不会受到任何拦截
                //.greenChannel()
                .withLong("key1", 666L)
                .withString("key3", "888")
                .withObject("key4", new User("Jack", "male"))
                .navigation(/*this,new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {

                    }

                    @Override
                    public void onLost(Postcard postcard) {

                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        //在回调中finish，否则可能出现白屏
                        finish();
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {

                    }
                }*/);
    }

    private void jumpForResult() {
        ARouter.getInstance().build("/test/activity")
                //可以添加跳转动画
                //.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                //设置lunchMode
                //.withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
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
