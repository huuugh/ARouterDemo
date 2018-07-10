package com.zje.moudlea;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by Hugh on 2018/7/10.
 */

public interface HelloService extends IProvider {
    void sayHello(String name);
}
