package com.fishnco.listfragmentsample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.fishnco.listfragmentsample.data.Course;
import com.fishnco.listfragmentsample.data.CourseArrayAdapter;
import com.fishnco.listfragmentsample.data.CourseData;
import com.fishnco.listfragmentsample.util.ScreenUtility;

import java.util.List;

/**
 * Created by junyi on 26/6/21
 */
public class CourseListFragment extends ListFragment {
    List<Course> courses = new CourseData().courseList();

    public CourseListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility = new ScreenUtility(getActivity());
        Log.e("MyFragment", "Width: " + String.valueOf(screenUtility.getDpWidth()));
        Log.e("MyFragment", "Height: " + String.valueOf(screenUtility.getDpHeight()));

        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_listitem, courses);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courselist, container, false);
        return view;
    }
}
