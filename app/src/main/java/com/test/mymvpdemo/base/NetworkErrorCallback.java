package com.test.mymvpdemo.base;

import com.kingja.loadsir.callback.Callback;
import com.test.mymvpdemo.R;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class NetworkErrorCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_network_error;
    }
}
