package com.example.hw2_m3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    Button btnPlus, btnMinus, btnResult;
    TextView text;
    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnMinus = view.findViewById(R.id.btn_min);
        btnPlus = view.findViewById(R.id.btn_pls);
        btnResult = view.findViewById(R.id.btn_send);
        text = view.findViewById(R.id.tv_count);

        btnPlus.setOnClickListener(v -> {
            count++;
            text.setText(String.valueOf(count));
        });
        btnMinus.setOnClickListener(v -> {
            if (count > 0) {
                count--;
                text.setText(String.valueOf(count));
            }
        });
        btnResult.setOnClickListener(v -> {
            String result = text.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("key", result);

            FirstFragment resultFragment = new FirstFragment();
            resultFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, resultFragment)
                    .commit();
        });

    }
}