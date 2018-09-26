package jiaoji.cool.com.jiaoji;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.lang.ref.WeakReference;

public class MyApp extends Application {
    WeakReference<MainActivity> mMainActive;
    boolean isBackGround = false;

    public void setMainActive(MainActivity mMainActive) {
        this.mMainActive = new WeakReference<>(mMainActive);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            isBackGround = true;
            MainActivity mainActivity = mMainActive.get();
            if(mainActivity != null) {
                mainActivity.pauseMedia();
            }

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();


        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (isBackGround) {
                    isBackGround = false;
                    MainActivity mainActivity = mMainActive.get();
                    if(mainActivity != null) {
                        mainActivity.resumeMedia();
                    }
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

    }
}
