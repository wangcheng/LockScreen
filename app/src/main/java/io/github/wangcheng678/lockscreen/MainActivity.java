package io.github.wangcheng678.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {
    static String ACTION_LOCK_SCREEN = "io.github.wangcheng678.lockscreen.LOCK_SCREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(), LockScreenAccessibilityService.class);
        intent.setAction(ACTION_LOCK_SCREEN);
        startService(intent);
        finish();
    }
}
