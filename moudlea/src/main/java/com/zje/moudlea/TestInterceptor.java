package com.zje.moudlea;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by Hugh on 2018/7/10.
 *  拦截器
 */

@Interceptor(priority = 1,name = "Interceptor for test")
public class TestInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if ("/test/activity".equals(postcard.getPath())){
            postcard.withString("why","disappointed");
            callback.onContinue(postcard);
//            callback.onInterrupt(new ErrnoException("some error may be happened",1));
//            callback.onInterrupt(null);
        }
    }

    @Override
    public void init(Context context) {
        Log.e("init",TestInterceptor.class.getSimpleName() + " has been inited");
    }
}
