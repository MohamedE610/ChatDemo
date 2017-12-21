/*
package com.example.abdallah.chatdemo.Utils.RetrofitLib;

import com.example.abdallah.chatdemo.Models.Clients.Clients;
import com.example.abdallah.chatdemo.Utils.Callbacks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

*/
/**
 * Created by abdallah on 12/18/2017.
 *//*

public class GetClientsTask implements Callback<Clients>{

    Retrofit retrofit;
    ApiInterface apiInterface;
    final String acceptHeader="application/json";
    final String contentTypeHeader="application/json";
    Callbacks callbacks;

    public GetClientsTask(){
    }

    public void setCallbacks(Callbacks callbacks){
        this.callbacks=callbacks;
    }

    public void start() {
        retrofit=ApiClient.getClient();
        apiInterface=retrofit.create(ApiInterface.class);
        Call<Clients>clientsCall = apiInterface.getCompanyClients();
        clientsCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<Clients> call, Response<Clients> response) {
        callbacks.OnSuccess(response);
    }

    @Override
    public void onFailure(Call<Clients> call, Throwable t) {

    }
}
*/
