package com.fishnco.listfragmentsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fishnco.listfragmentsample.data.Course;
import com.fishnco.listfragmentsample.data.CourseData;

/**
 * Created by junyi on 28/6/21
 */
public class CourseDetailFragment extends Fragment {
    Course course;

    //Required no-args constructor
    public CourseDetailFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("course_id")) {
            int position = bundle.getInt("course_id");
            course = new CourseData().courseList().get(position);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coursedetail, container, false);

        //Instantiate widgets
        if (course != null) {
            TextView courseName = view.findViewById(R.id.detailCourseName);
            courseName.setText(course.getCourseName());

            ImageView courseImage = view.findViewById(R.id.detailCourseImage);
            courseImage.setImageResource(course.getImageResourceId(getActivity()));

            TextView courseDescription = view.findViewById(R.id.detailCourseDescription);
            courseDescription.setText(course.getCourseName());
        }

        return view;
    }
}
