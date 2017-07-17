package org.edx.mobile.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.edx.mobile.R;

public class ProgressFragment extends Fragment {

    View v;
    RecyclerView  quiz_recyclerView;
    RecyclerView.Adapter adapter, quiz_adapter;
    String[] qz = {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5", "Test 6", "Test 7", "Test 8", "Test 9", "Test 10"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.progress_fragment, container, false);

//        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        quiz_recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view2);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setHasFixedSize(true);

        quiz_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        quiz_recyclerView.setHasFixedSize(true);

        adapter = new Quiz_Adapter(getActivity(), qz);

//        recyclerView.setAdapter(adapter);
        quiz_recyclerView.setAdapter(adapter);

        return v;

    }
}
