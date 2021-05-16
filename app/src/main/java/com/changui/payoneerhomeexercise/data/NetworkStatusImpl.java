package com.changui.payoneerhomeexercise.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class NetworkStatusImpl implements NetworkStatus {
    private final Context appContext;

    public NetworkStatusImpl(Context context) {
        this.appContext = context;
    }

    @Override
    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return postAndroidMInternetCheck(connectivityManager);
        } else {
            return preAndroidMInternetCheck(connectivityManager);
        }
    }

    private boolean preAndroidMInternetCheck(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) {
            return (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private boolean postAndroidMInternetCheck(ConnectivityManager connectivityManager) {
        Network network = connectivityManager.getActiveNetwork();
        NetworkCapabilities connection = connectivityManager.getNetworkCapabilities(network);
        return connection != null && (
                connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));
    }
}
