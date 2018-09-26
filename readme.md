# 游戏CG播放控制

### 简介
本项目是基于[JiaoZiVideoPlayer](https://github.com/lipangit/JiaoZiVideoPlayer)写的，重写了JzvdStd的部分方法使其更适合游戏CG播放的场景。

### API
<!-- YAML
added: v1.0.0
-->

* `setMainActive` {设置被代理的active}
* `pauseMedia` {暂停播放}
* `resumeMedia` {恢复播放}
* `finishMedia` {结束播放}
* `startMedia` {开始播放}
* `setOnClickCallback` {设置播放过程中点击回调}
* `setCGCompletionCallback` {设置播放结束回调}

所有API都由CGMgr代理并且全部是静态方法（方便在GL线程调用）并且持有active的弱引用（避免内存泄漏），使用过程中发现问题欢迎提issues。
默认CG播放是全屏，如果需要自定义请自行修改。
