package com.perry.widget.recycler.DefaultHeaderAndFooterCreator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.perry.R;
import com.perry.widget.recycler.AutoLoad.AutoLoadFooterCreator;


/**
 * Created by Administrator on 2016/9/30.
 */
public class DefaultAutoLoadFooterCreator extends AutoLoadFooterCreator {

    protected View mAutoLoadFooter;
    protected ImageView iv;
    protected ValueAnimator ivAnim;
    private int loadingDuration = 1000;

    @Override
    protected View getLoadView(Context context, RecyclerView recyclerView) {
        if (mAutoLoadFooter == null) {
            mAutoLoadFooter = LayoutInflater.from(context).inflate(R.layout.layout_auto_load_footer,recyclerView,false);
            iv = (ImageView) mAutoLoadFooter.findViewById(R.id.iv);
            startLoadingAnim();
        }
        return mAutoLoadFooter;
    }

    @Override
    protected View getNoMoreView(Context context, RecyclerView recyclerView) {
        return null;
    }

    private void startLoadingAnim() {
        if (ivAnim != null) {
            ivAnim.cancel();
        }
        ivAnim = ObjectAnimator.ofFloat(0, 360).setDuration(loadingDuration);
        ivAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                iv.setRotation((Float) animation.getAnimatedValue());
            }
        });
        ivAnim.setRepeatMode(ObjectAnimator.RESTART);
        ivAnim.setRepeatCount(ObjectAnimator.INFINITE);
        ivAnim.setInterpolator(new LinearInterpolator());
        ivAnim.start();
    }

}
