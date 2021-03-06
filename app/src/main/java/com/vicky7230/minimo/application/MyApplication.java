package com.vicky7230.minimo.application;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.fonts.TypiconsModule;
import com.vicky7230.minimo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by agrim on 27/3/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //initialize iconify
        Iconify
                .with(new FontAwesomeModule())
                .with(new MaterialModule())
                .with(new IoniconsModule())
                .with(new TypiconsModule());

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/JosefinSans-SemiBold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
