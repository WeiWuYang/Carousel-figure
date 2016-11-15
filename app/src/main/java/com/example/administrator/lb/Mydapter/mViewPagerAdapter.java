package com.example.administrator.lb.Mydapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public class mViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private Context context;
    private int width;
  private LayoutInflater layout;
    public mViewPagerAdapter(Context context, List<ImageView> images,int width) {
        this.context = context;
        this.images = images;
        this.width=width;
        layout=LayoutInflater.from(context);
    }

    List<ImageView> images;
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
