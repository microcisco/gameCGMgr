package jiaoji.cool.com.jiaoji;

import java.lang.ref.WeakReference;

public class CGMgr {
    public static String onClickCallback = null;      //点击屏幕回调函数
    public static String CGCompletionCallback = null; //CG播放结束回调

    static WeakReference<MainActivity> mMainActive;

    static public void setMainActive(MainActivity mMainActive) {
        CGMgr.mMainActive = new WeakReference<>(mMainActive);
    }

    // 暂停播放
    public static void pauseMedia() {
        MainActivity mainActivity = mMainActive.get();
        if (mainActivity != null) {
            mainActivity.pauseMedia();
        }

    }

    //恢复播放
    public static void resumeMedia() {
        MainActivity mainActivity = mMainActive.get();
        if (mainActivity != null) {
            mainActivity.resumeMedia();
        }
    }

    //结束播放
    public static void finishMedia() {
        MainActivity mainActivity = mMainActive.get();
        if (mainActivity != null) {
            mainActivity.finishMedia();
        }
    }

    //开始播放
    public static void startMedia() {
        MainActivity mainActivity = mMainActive.get();
        if (mainActivity != null) {
            mainActivity.startMedia();
        }
    }

    //////////////////////////////////////////////////
    //设置点击视频回调
    public static void setOnClickCallback(String funcName) {
        onClickCallback = funcName;
    }

    //设置CG视频播放完成回调
    public static void setCGCompletionCallback(String funcName) {
        CGCompletionCallback = funcName;
    }
}
