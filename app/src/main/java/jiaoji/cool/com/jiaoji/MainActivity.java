package jiaoji.cool.com.jiaoji;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import cn.jzvd.JZDataSource;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import jiaoji.cool.com.jiaoji.CustomMediaPlayer.CustomMediaPlayerAssertFolder;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //避免切后台后重新启动程序
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }

        //注册到application
        MyApp application = (MyApp) this.getApplication();
        application.setMainActive(this);
        //注册到application
        VideoStd.setMainActive(this);


        //播放
        startMedia();
    }

    // 播放结束回调
    public void playCompletion() {
        if(CGMgr.CGCompletionCallback != null) {
            //存在回调函数 && 执行回调函数

        }
    }

    // 点击屏幕回调
    public void onClick() {
        if(CGMgr.onClickCallback != null) {
            //存在回调函数 && 执行回调函数

        }
    }

    // 暂停播放
    public void pauseMedia() {
        JzvdStd.goOnPlayOnPause();
    }

    //恢复播放
    public void resumeMedia() {
        JzvdStd.goOnPlayOnResume();
    }

    //结束播放
    public void finishMedia() {
        JzvdStd.releaseAllVideos();
    }

    //开始播放
    public void startMedia() {
        //获取视频资源
        JZDataSource jzDataSource = null;
        try {
            jzDataSource = new JZDataSource(getAssets().openFd("1.mp4"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert jzDataSource != null;

        //播放
        Jzvd.setMediaInterface(new CustomMediaPlayerAssertFolder());
        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        JzvdStd.startFullscreen(this, VideoStd.class, jzDataSource);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.resumeMedia();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.pauseMedia();
    }

}
