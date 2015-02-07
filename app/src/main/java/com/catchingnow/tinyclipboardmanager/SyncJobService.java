package com.catchingnow.tinyclipboardmanager;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by heruoxin on 15/1/19.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SyncJobService extends JobService {
    private final static String PACKAGE_NAME = "com.catchingnow.tinyclipboardmanager";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.v(ActivityMain.PACKAGE_NAME, "Start Clean up...");
        CBWatcherService.startCBService(this, false, true);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
