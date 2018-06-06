package harryguo.voicecmd.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;

import com.tencent.tac.crash.TACCrashSimulator;

import harryguo.voicecmd.activity.setting.NluSetting;
import harryguo.voicecmd.activity.setting.OfflineSetting;
import harryguo.voicecmd.recognization.CommonRecogParams;
import harryguo.voicecmd.recognization.nlu.NluRecogParams;
import harryguo.voicecmd.recognization.offline.OfflineRecogParams;

public class MainActivity extends ActivityRecog {

    {
        descText = "请说出你的指令：";
        enableOffline = true;
    }

    public MainActivity() {
        super();
        // settingActivityClass = OfflineSetting.class;
        settingActivityClass = NluSetting.class;
    }

    @Override
    protected CommonRecogParams getApiParams() {
        // return new OfflineRecogParams(this);
        // TACCrashSimulator.testJavaCrash();
        {
            //2.通过Notification.Builder来创建通知
            Notification.Builder myBuilder = new Notification.Builder(this);
            myBuilder.setContentTitle("QQ")
                    .setContentText("这是内容")
                    .setSubText("这是补充小行内容")
                    .setTicker("您收到新的消息")
                    //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示
                    //设置默认声音和震动
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                    .setAutoCancel(true)//点击后取消
                    .setWhen(System.currentTimeMillis())//设置通知时间
                    .setPriority(Notification.PRIORITY_HIGH)//高优先级
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
                    //android5.0加入了一种新的模式Notification的显示等级，共有三种：
                    //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知
                    //VISIBILITY_PRIVATE 任何情况都会显示通知
                    //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知
                    // .setContentIntent(pi);  //3.关联PendingIntent
            Notification myNotification = myBuilder.build();
            //4.通过通知管理器来发起通知，ID区分通知
            NotificationManager myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            myManager.notify(1, myNotification);
        }
        return new NluRecogParams(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            }
//        }, 100);
    }
}
