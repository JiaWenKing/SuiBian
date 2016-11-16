package com.example.administrator.suibian;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //自定义通知栏
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(MainActivity.this);
        //顶层小图标
        builder.statusBarDrawable = R.mipmap.timg   ;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder);

        //自定义通知栏2
        CustomPushNotificationBuilder builder2 = new
                CustomPushNotificationBuilder(MainActivity.this,
                R.layout.view_notification,
                R.id.icon,
                R.id.title,
                R.id.text);
        // 指定定制的 Notification Layout
        builder2.statusBarDrawable = R.mipmap.yanjipaiapp;
        // 指定最顶层状态栏小图标
        builder2.layoutIconDrawable = R.mipmap.timg;
        // 指定下拉状态栏时显示的通知图标
        JPushInterface.setPushNotificationBuilder(2, builder2);
    }
}
