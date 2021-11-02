package com.example.todosapp.Fragment.Main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todosapp.Adapter.TaskCalendarAdapter;
import com.example.todosapp.Adapter.TaskCalendarCompletedAdapter;
import com.example.todosapp.Models.Task;
import com.example.todosapp.R;


import java.util.ArrayList;


public class TaskFragment extends Fragment {


    View view;
    LinearLayout layoutTask, layoutNoTask, layoutContainer;

    RecyclerView rvCalendar;
    ArrayList<Task> tasks;
    TaskCalendarAdapter adapter;

    RecyclerView rvTaskCompleted;
    ArrayList<Task> tasksCompleted;
    TaskCalendarCompletedAdapter adapterCompleted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_task, container, false);
        InitComponent();
        GetTask();
        SetUpRvTask();
        SetUpRvTaskCompleted();
        return view;
    }

    private void InitComponent() {
        //layoutContainer = view.findViewById(R.id.layout_calendar_container);
        layoutTask = view.findViewById(R.id.task_layout_calendar);
        layoutNoTask = view.findViewById(R.id.no_task_layout);
        rvCalendar = view.findViewById(R.id.rv_calendar);
        rvTaskCompleted = view.findViewById(R.id.rv_task_completed);
    }

    private void GetTask() {
        tasks = new ArrayList<>();
        tasks.add(new Task("1", "1", "1", true, true, new ArrayList<>(), null));
        tasks.add(new Task("2", "2", "2", true, false, new ArrayList<>(), null));
        tasks.add(new Task("3", "3", "3", true, true, new ArrayList<>(), null));
        tasks.add(new Task("4", "4", "4", true, false, new ArrayList<>(), null));
        tasks.add(new Task("5", "5", "4", true, false, new ArrayList<>(), null));
        tasks.add(new Task("6", "6", "4", true, false, new ArrayList<>(), null));

        tasksCompleted = new ArrayList<>();
        tasksCompleted.add(new Task("1", "123456789", "1", false, true, new ArrayList<>(), null));
        tasksCompleted.add(new Task("3", "123456789", "3", false, false, new ArrayList<>(), null));

        layoutTask.setVisibility(View.VISIBLE);
        layoutNoTask.setVisibility(View.GONE);
    }

    private void SetUpRvTask() {
        adapter = new TaskCalendarAdapter(getContext(), tasks,
                null,
                null);

        rvCalendar.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rvCalendar.setAdapter(adapter);
    }

    private void SetUpRvTaskCompleted() {
        adapterCompleted = new TaskCalendarCompletedAdapter(getContext(), tasksCompleted, null,
                null);

        rvTaskCompleted.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rvTaskCompleted.setAdapter(adapterCompleted);
    }
}