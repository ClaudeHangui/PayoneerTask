package com.changui.payoneerhomeexercise.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.changui.payoneerhomeexercise.domain.Failure;
import com.changui.payoneerhomeexercise.domain.GetPaymentMethodsUseCase;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.changui.payoneerhomeexercise.domain.Result;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@HiltViewModel
public class PaymentMethodsViewModel extends ViewModel {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final GetPaymentMethodsUseCase useCase;

    private final MutableLiveData<List<PaymentMethodUIModel>> modelMutableLiveData = new MutableLiveData<>();
    public LiveData<List<PaymentMethodUIModel>> getPaymentMethodsLiveData() { return modelMutableLiveData; }

    private final MutableLiveData<Failure> errorMutableLiveData = new MutableLiveData<>();
    public LiveData<Failure> getErrorMessageLiveData() {
        return errorMutableLiveData;
    }

    private final MutableLiveData<Boolean> isLoadMutableLiveData = new MutableLiveData<>();
    public LiveData<Boolean> getLoadingStateLiveData() {
        return isLoadMutableLiveData;
    }


    @Inject
    public PaymentMethodsViewModel(GetPaymentMethodsUseCase useCase) {
        this.useCase = useCase;
    }

    public void refreshPaymentMethods(){
        isLoadMutableLiveData.setValue(true);
        Disposable lastDisposable = useCase.getPayments()
                .subscribe(this::handleResult);

        compositeDisposable.add(lastDisposable);
    }

    private void handleResult(Result<List<PaymentMethodUIModel>> result) {
        switch (result.status) {
            case SUCCESS:
                isLoadMutableLiveData.setValue(false);
                modelMutableLiveData.setValue(result.data);
                break;
            case ERROR:
                isLoadMutableLiveData.setValue(false);
                errorMutableLiveData.setValue(result.message);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        clearDisposable();

    }

    private void clearDisposable() {
        compositeDisposable.clear();
    }

}
