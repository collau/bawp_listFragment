package com.fishnco.listfragmentsample.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by junyi on 28/6/21
 * At runtime, we know the width and height of device screen
 * For dynamic layout of application
 */
public class ScreenUtility {
    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public ScreenUtility(Activity activity) {
        this.activity = activity;

        //get default display width of device
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();

        display.getRealMetrics(outMetrics);

        //density (to convert pixels to dp)
        float density = activity.getResources().getDisplayMetrics().density;

        dpHeight = outMetrics.heightPixels / density;
        dpWidth = outMetrics.widthPixels / density;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public void setDpWidth(float dpWidth) {
        this.dpWidth = dpWidth;
    }

    public float getDpHeight() {
        return dpHeight;
    }

    public void setDpHeight(float dpHeight) {
        this.dpHeight = dpHeight;
    }
}
