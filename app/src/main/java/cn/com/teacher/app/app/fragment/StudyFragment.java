package cn.com.teacher.app.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.teacher.app.app.R;

/**
 * Created by houch on 2016/9/20.
 */
public class StudyFragment extends Fragment {
    private View view;
    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_learn, container, false);
        }
        return view;
    }
}
