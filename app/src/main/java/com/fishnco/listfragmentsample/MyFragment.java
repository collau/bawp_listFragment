package com.fishnco.listfragmentsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.fishnco.listfragmentsample.data.Course;
import com.fishnco.listfragmentsample.data.CourseArrayAdapter;
import com.fishnco.listfragmentsample.data.CourseData;

import java.util.List;

/**
 * Created by junyi on 26/6/21
 */
public class MyFragment extends ListFragment {
    List<Course> courses = new CourseData().courseList();

    public MyFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_listitem, courses);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        return view;
    }
}
