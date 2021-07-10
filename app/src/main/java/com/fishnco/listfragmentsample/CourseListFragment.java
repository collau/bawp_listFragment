package com.fishnco.listfragmentsample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
    // instantiate courseData to create a list of courses
    List<Course> courses = new CourseData().courseList();
    private Callbacks activity;

    public CourseListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility = new ScreenUtility(getActivity());
        Log.e("MyFragment", "Width: " + String.valueOf(screenUtility.getDpWidth()));
        Log.e("MyFragment", "Height: " + String.valueOf(screenUtility.getDpHeight()));

        // instantiate arrayAdapter and set adapter to listFragment
        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_listitem, courses);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courselist, container, false);
        return view;
    }

    // To allow the activity (in this case, MainActivity), to be able to listen to whatever is happening inside fragments
    public interface Callbacks {
        public void onItemSelected(Course course, int position);
    }

    // use onListItemClick to trigger onItemSelected in the MainActivity
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        // Create a course object when a certain course in a list is clicked
        Course course = courses.get(position);
        this.activity.onItemSelected(course, position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        /* When attaching fragment to the activity, we need to pass the context of the activity (in this case, MainActivity)
           to the fragment to invoke the onItemSelected method.
           onListItemClick will then know which activity's onItemSelected will be called
        */
        super.onAttach(context);
        this.activity = (Callbacks) context;
    }
}
