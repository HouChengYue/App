package cn.com.teacher.app.app.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.teacher.app.app.R;
import cn.com.teacher.app.app.fragment.FandFragment;
import cn.com.teacher.app.app.fragment.LocaFragment;
import cn.com.teacher.app.app.fragment.MessageFrameng;
import cn.com.teacher.app.app.fragment.StudyFragment;

public class MainActivity extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, View.OnClickListener {


    @Bind(R.id.vp_main)
    ViewPager vpMain;
    @Bind(R.id.btnLearn)
    Button btnLearn;
    @Bind(R.id.btnFand)
    Button btnFand;
    @Bind(R.id.btnMeaage)
    Button btnMeaage;
    @Bind(R.id.btnLoca)
    Button btnLoca;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationIcon(R.drawable.my);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_like) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Wiewpager 适配器
     */

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        vpMain.setAdapter(adapter);
//          ViewPager设置监听
        vpMain.setOnPageChangeListener(this);
        //首次进入时的页面
        btnFand.setSelected(true);//按键设置
        vpMain.setCurrentItem(1, false);//ViewPager设置

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        btnLearn.setSelected(position == 0);
        btnFand.setSelected(position == 1);
        btnMeaage.setSelected(position == 2);
        btnLoca.setSelected(position == 3);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @OnClick({R.id.vp_main, R.id.btnLearn, R.id.btnFand, R.id.btnMeaage, R.id.btnLoca})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLearn:
                vpMain.setCurrentItem(0, false);
                break;
            case R.id.btnFand:
                vpMain.setCurrentItem(1, false);
                break;
            case R.id.btnMeaage:
                vpMain.setCurrentItem(2, false);
                break;
            case R.id.btnLoca:
                vpMain.setCurrentItem(3, false);
                break;
            default:
                throw new RuntimeException("未知错误！");
        }
    }

    private final FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new StudyFragment();
                case 1:
                    return new FandFragment();
                case 2:
                    return new MessageFrameng();
                case 3:
                    return new LocaFragment();
                default:
                    throw new RuntimeException("未知故障！");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
}
