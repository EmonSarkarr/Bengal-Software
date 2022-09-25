package com.example.bengalsoftware;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bengalsoftware.databinding.FragmentHomeBinding;
import com.example.bengalsoftware.viewmodels.LoginViewModel;

public class HomeFragment extends Fragment {

    private LoginViewModel loginViewModel;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        loginViewModel.getStateLiveData().observe(getViewLifecycleOwner(), authState -> {
                    if (authState == LoginViewModel.AuthState.UNAUTHENTICATED) {
                        Navigation.findNavController(container).navigate(R.id.login_action);
                    }
               });

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}