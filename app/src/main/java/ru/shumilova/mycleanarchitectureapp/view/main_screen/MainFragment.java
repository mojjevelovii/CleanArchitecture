package ru.shumilova.mycleanarchitectureapp.view.main_screen;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.shumilova.mycleanarchitectureapp.R;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private TextView isRating;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initRenderer();
        viewModel.initScreen();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initRenderer() {
        viewModel.getViewState().observe(getViewLifecycleOwner(), new Observer<ViewState>() {
            @Override
            public void onChanged(ViewState viewState) {
                if (viewState.isShowRating()) {
                    isRating.setText("Пожалуйста оцените приложение.");
                } else {
                    isRating.setText("");
                }
            }
        });
    }

    private void initView(View view) {
        isRating = view.findViewById(R.id.tv_is_rating);
    }
}