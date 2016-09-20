package cn.com.teacher.app.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import cn.com.teacher.app.app.activity.MainActivity;

/**
 * Created by houch on 2016/9/20.
 */
public class BaseFragment extends Fragment {
    protected MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
