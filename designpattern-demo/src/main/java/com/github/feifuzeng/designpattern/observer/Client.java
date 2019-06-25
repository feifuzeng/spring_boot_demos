package com.github.feifuzeng.designpattern.observer;

import com.github.feifuzeng.designpattern.observer.impl.Police;
import com.github.feifuzeng.designpattern.observer.impl.Security;
import com.github.feifuzeng.designpattern.observer.impl.Thief;
import com.github.feifuzeng.designpattern.observer.impl.Transporter;

/**
 * @Author: feifz
 * @Date: 2019-03-15 17:20
 * @Version: 1.0
 * @Description: 客户端-测试类
 */
public class Client {
    public static void main(String[] args)
    {
        Transporter transporter = new Transporter();

        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(thief);

        transporter.notifyWatchers();
    }
}