package com.zje.moudlea;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by Hugh on 2018/7/10.
 *
 */

@Route(path = "/service/helloservice")
public class HelloServiceImpl implements HelloService {

    private Context mContext;

    @Override
    public void sayHello(String name) {
        Toast.makeText(mContext, "hello " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.mContext = context ;
        Log.d("HelloServiceImpl" , "the context is " + mContext);
    }
}