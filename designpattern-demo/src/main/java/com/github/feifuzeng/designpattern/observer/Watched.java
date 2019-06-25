package com.github.feifuzeng.designpattern.observer;

/**
 * @Author: feifz
 * @Date: 2019-03-15 17:13
 * @Version: 1.0
 * @Description: 抽象的被观察者
 */
public interface Watched
{
    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers();
}