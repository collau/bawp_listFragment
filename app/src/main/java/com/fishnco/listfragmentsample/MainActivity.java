package com.fishnco.listfragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // commented after fragment has been inserted into xml
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.myContainer);

        if (fragment == null) {
            fragment = new CourseListFragment();
            fm.beginTransaction()
                    .add(R.id.myContainer, fragment)
                    .commit();
        }
         */
    }
}