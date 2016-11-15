package com.example.administrator.lb;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.lb.Mydapter.mViewPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 1:
                    int i = vp.getCurrentItem();
                    if (i < views().size() - 1) {
                        i++;
                    } else {
                        i = 0;

                    }
                    vp.setCurrentItem(i);
                    mhandler.sendEmptyMessageDelayed(1, 2000);
                    break;
            }
        }
    };
    private int width;
    private List<ImageView> imageViews;
    private List<View> dots;
    private String titles[];
    private ViewPager vp;
    private LinearLayout ll_point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        ll_point = (LinearLayout) findViewById(R.id.ll_point);
        getdata();
    //    point();
        BeginLunbo();

    }

//    private void point() {
//
//        for (int j = 0; j < views().size(); j++) {
//            View vi = new View(this);
//            vi.setBackgroundResource(R.drawable.dots_normal);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
//            if (j > 0) {
//                params.leftMargin = 10;
//            }
//            vi.setLayoutParams(params);
//            ll_point.addView(vi);
//        }
        //获取视图树；
//        ll_point.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                ll_point.getViewTreeObserver().addOnGlobalLayoutListener(this);
//                width = ll_point.getChildAt(1).getLeft() - ll_point.getChildAt(0).getLeft();
//
//            }
//        });
//}

    private void BeginLunbo() {
        mhandler.sendEmptyMessageDelayed(1, 2000);
    }

    int res[] = new int[]{R.drawable.bd, R.drawable.small, R.drawable.welcome, R.drawable.wy};

    public List<ImageView> views() {
        List<ImageView> views = new ArrayList<ImageView>();
        for (int i = 0; i < res.length; i++) {

            ImageView img = new ImageView(this);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewPager.LayoutParams params = new ViewPager.LayoutParams();
            params.width = ViewPager.LayoutParams.MATCH_PARENT;
            params.height = ViewPager.LayoutParams.WRAP_CONTENT;
            img.setLayoutParams(params);
            //  img.setImageResource(res[i]);
            Picasso.with(this).load(res[i]).into(img);
            views.add(img);
        }
        return views;
    }

    public void getdata() {
        List<ImageView> view = views();
        mViewPagerAdapter adapter = new mViewPagerAdapter(MainActivity.this, view, width);
        vp.setAdapter(adapter);
    }
}
