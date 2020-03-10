package io.github.wangcheng678.lockscreen;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;

public class LockScreenAccessibilityService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        if (action != null && action.equals(MainActivity.ACTION_LOCK_SCREEN)) {
            if (!performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)) {
                openSettings();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void openSettings() {
        Intent goToSettings = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        goToSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(goToSettings);
    }
}
