package jiaoji.cool.com.jiaoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.ref.WeakReference;

import cn.jzvd.JzvdStd;

public class VideoStd extends JzvdStd {
    static WeakReference<MainActivity> mMainActive;

    static public void setMainActive(MainActivity mMainActive) {
        VideoStd.mMainActive = new WeakReference<>(mMainActive);
    }

    public VideoStd(Context context) {
        super(context);
    }

    public VideoStd(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        MainActivity mainActivity = VideoStd.mMainActive.get();
        if (mainActivity != null) {
            mainActivity.onClick();
        }

        return true;
//        return super.onTouch(v, event);
    }

    @Override
    public void onCompletion() {
        MainActivity mainActivity = VideoStd.mMainActive.get();
        if (mainActivity != null) {
            mainActivity.playCompletion();
        }

        super.onCompletion();
    }

    @Override
    public void changeUiToNormal() {
        super.changeUiToNormal();

        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToPreparing() {
        super.changeUiToPreparing();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToPlayingClear() {
        super.changeUiToPlayingClear();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToPauseShow() {
        super.changeUiToPauseShow();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToPauseClear() {
        super.changeUiToPauseClear();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToComplete() {
        super.changeUiToComplete();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }

    @Override
    public void changeUiToError() {
        super.changeUiToError();
        bottomContainer.setVisibility(GONE);
        bottomProgressBar.setVisibility(GONE);
        fullscreenButton.setVisibility(GONE);
    }
}
