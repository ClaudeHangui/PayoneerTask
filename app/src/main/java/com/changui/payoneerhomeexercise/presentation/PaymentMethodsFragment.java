package com.changui.payoneerhomeexercise.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;

import com.changui.payoneerhomeexercise.R;
import com.changui.payoneerhomeexercise.databinding.PaymentMethodsFragmentBinding;
import com.changui.payoneerhomeexercise.domain.Failure;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PaymentMethodsFragment extends Fragment implements View.OnClickListener {
    private PaymentMethodsFragmentBinding binding;
    private PaymentMethodsViewModel paymentMethodsViewModel;
    private PaymentMethodsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PaymentMethodsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paymentMethodsViewModel = new ViewModelProvider(this).get(PaymentMethodsViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        paymentMethodsViewModel.refreshPaymentMethods();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
        setUpObservers();
    }

    private void showErrorState(Failure failure) {
        String failureTitle;
        String failureDescription;
        switch (failure) {
            case BadRequestError:
                failureTitle = getString(R.string.error_forbidden);
                failureDescription = getString(R.string.error_forbidden_desc);
            case ForbiddenError:
                failureTitle = getString(R.string.error_forbidden);
                failureDescription = getString(R.string.error_forbidden_desc);
                break;
            case GatewayError:
                failureTitle = getString(R.string.error_gateway);
                failureDescription = getString(R.string.error_gateway_desc);
                break;
            case NetworkError:
                failureTitle = getString(R.string.error_network);
                failureDescription = getString(R.string.error_network_desc);
                break;
            case NotFoundError:
                failureTitle = getString(R.string.error_not_found);
                failureDescription = getString(R.string.error_not_found_desc);
                break;
            case ServerError:
                failureTitle = getString(R.string.error_internal_server);
                failureDescription = getString(R.string.error_internal_server_desc);
                break;
            case UnauthorisedError:
                failureTitle = getString(R.string.error_unauthorised);
                failureDescription = getString(R.string.error_unauthorised_desc);
                break;
            case UnknownError:
            default:
                failureTitle = getString(R.string.error_unknown);
                failureDescription = getString(R.string.error_unknown_desc);
                break;
        }
        setErrorView(failureTitle, failureDescription);
    }

    private void setErrorView(String failureTitle, String failureDescription) {
        binding.paymentMethodsErrorContainer.failureTitle.setText(failureTitle);
        binding.paymentMethodsErrorContainer.failureDescription.setText(failureDescription);
        binding.paymentMethodsErrorContainer.exitButton.setOnClickListener(this);
        binding.paymentMethodsErrorContainer.retryButton.setOnClickListener(this);
        binding.paymentMethodsErrorContainer.errorRoot.setVisibility(View.VISIBLE);
    }

    private void setUpObservers() {
        paymentMethodsViewModel.getLoadingStateLiveData().observe(getViewLifecycleOwner(), this::showLoadingState);
        paymentMethodsViewModel.getPaymentMethodsLiveData().observe(getViewLifecycleOwner(), this::showSuccessState);
        paymentMethodsViewModel.getErrorMessageLiveData().observe(getViewLifecycleOwner(), this::showErrorState);
    }

    private void setUpRecyclerView(){
        adapter = new PaymentMethodsAdapter(new ArrayList<>());
        binding.paymentMethodsRecycler.setHasFixedSize(true);
        binding.paymentMethodsRecycler.setAdapter(adapter);
    }

    private void showLoadingState(Boolean shouldShow) {
        binding.progress.setVisibility(shouldShow ? View.VISIBLE:View.GONE);
    }

    private void showSuccessState(List<PaymentMethodUIModel> uiModelList) {
        adapter.setPaymentMethodsList(uiModelList);
        binding.paymentMethodsRecycler.setVisibility(View.VISIBLE);
    }

    public static PaymentMethodsFragment newInstance() {
        PaymentMethodsFragment fragment = new PaymentMethodsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.exit_button){
            if (isAdded()) getActivity().finish();
        }
        else if (view.getId() == R.id.retry_button){
            binding.paymentMethodsErrorContainer.errorRoot.setVisibility(View.GONE);
            paymentMethodsViewModel.refreshPaymentMethods();
        }
    }
}
