package com.alejandrorios.condorsports.service.network;

import com.alejandrorios.condorsports.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProviderImpl {

	private static Retrofit retrofit = null;

	public static Retrofit getRetrofitProvider() {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder()
					.baseUrl(BuildConfig.SERVER_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit;
	}
}
