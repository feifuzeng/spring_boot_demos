package com.ohaotian.feifz.designpattern.observer.impl;

import com.ohaotian.feifz.designpattern.observer.Watched;
import com.ohaotian.feifz.designpattern.observer.Watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: feifz
 * @Date: 2019-03-15 17:17
 * @Version: 1.0
 * @Description: 具体的被观察者
 */
public class Transporter implements Watched {
    private List<Watcher> list = new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher)
    {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher)
    {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers()
    {
        for (Watcher watcher : list)
        {
            watcher.update();
        }
    }

}