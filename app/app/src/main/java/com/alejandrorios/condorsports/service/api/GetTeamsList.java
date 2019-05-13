package com.alejandrorios.condorsports.service.api;

import android.util.Log;

import com.alejandrorios.condorsports.models.Team;
import com.alejandrorios.condorsports.service.network.RetrofitProvider;
import com.alejandrorios.condorsports.service.network.RetrofitProviderImpl;
import com.alejandrorios.condorsports.ui.mainActivity.MainActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetTeamsList implements MainActivityView.GetTeamsInteractor {

	@Override
	public void getTeamsList(final String codeLeague, final OnFinishedListener onFinishedListener) {
		final RetrofitProvider service = RetrofitProviderImpl.getRetrofitProvider().create(RetrofitProvider.class);
		final Call<Team> call = service.getTeamByLeague(codeLeague);
		Log.wtf("URL Called", call.request().url() + "");

		call.enqueue(new Callback<Team>() {
			@Override
			public void onResponse(final Call<Team> call, final Response<Team> response) {
				onFinishedListener.onFinished(response.body());
			}

			@Override
			public void onFailure(final Call<Team> call, final Throwable t) {
				onFinishedListener.onFailure(t);
			}
		});
	}
}
