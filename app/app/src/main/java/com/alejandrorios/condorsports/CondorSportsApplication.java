package com.alejandrorios.condorsports;

import android.app.Application;
import android.content.Context;

import com.alejandrorios.condorsports.common.RealmDbModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CondorSportsApplication extends Application {
	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();

		mContext = this;

		Realm.init(this);
		RealmConfiguration config = new RealmConfiguration.Builder()
				.name("condorsports.realm")
				.modules(new RealmDbModule())
				.build();
		Realm.setDefaultConfiguration(config);
	}

	public static Context getContext() {
		return mContext;
	}
}
