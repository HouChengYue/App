package cn.com.teacher.app.app.activity;

import android.os.Bundle;
import android.os.Handler;

import cn.com.teacher.app.app.R;
import cn.com.teacher.app.app.base.BaseActivity;

/**
 * 欢迎页面
 */
public class SplanActivity extends BaseActivity {
    private long SPLAN_TIME=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splan);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.class);
                finish();
            }
        }, SPLAN_TIME);
    }


}
