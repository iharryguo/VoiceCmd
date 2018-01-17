package harryguo.voicecmd.activity;

import android.os.Bundle;

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
