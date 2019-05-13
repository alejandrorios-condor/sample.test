package com.alejandrorios.condorsports.service.api;

import android.util.Log;

import com.alejandrorios.condorsports.ui.teamDetails.TeamDetailsActivityView;
import com.alejandrorios.condorsports.models.Events;
import com.alejandrorios.condorsports.service.network.RetrofitProvider;
import com.alejandrorios.condorsports.service.network.RetrofitProviderImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetEventsList implements TeamDetailsActivityView.GetEventsInteractor {

	@Override
	public void getEventsList(final String teamId, final OnFinishedListener onFinishedListener) {
		final RetrofitProvider service = RetrofitProviderImpl.getRetrofitProvider().create(RetrofitProvider.class);
		final Call<Events> call = service.getEventsByTeam(teamId);
		Log.wtf("URL Called", call.request().url() + "");

		call.enqueue(new Callback<Events>() {
			@Override
			public void onResponse(final Call<Events> call, final Response<Events> response) {

				onFinishedListener.onFinished(response.body());
			}

			@Override
			public void onFailure(final Call<Events> call, final Throwable t) {
				onFinishedListener.onFailure(t);
			}
		});
	}
}
