package com.alejandrorios.condorsports.common;

import com.alejandrorios.condorsports.models.TeamData;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmManager {

	private Realm realm;

	private static RealmManager ourInstance = new RealmManager();

	public static RealmManager getInstance() {
		return ourInstance;
	}

	public RealmManager() {
		realm = Realm.getDefaultInstance();
	}

	public Realm getRealmInstance() {
		return realm;
	}

	public List<TeamData> getAll() {
		final List<TeamData> results = realm.where(TeamData.class).findAll();

		return realm.copyFromRealm(results);
	}

	public String getTeamByName(final String teamName) {
		final TeamData results = realm.where(TeamData.class).equalTo("idTeam", teamName).findFirst();
		String url;

		try {
			url = results.getStrTeamBadge();
		} catch (NullPointerException e) {
			e.printStackTrace();
			url = "";
		}

		return url;
	}

	public <E extends RealmObject> void update(final E object) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.copyToRealmOrUpdate(object);
			}
		});
	}

	public <E extends RealmObject> void updateList(final Iterable<E> objects) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.copyToRealmOrUpdate(objects);
			}
		});
	}

	public <E extends RealmObject> void saveList(final Iterable<E> objects, final Class<E> clazz) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.copyToRealmOrUpdate(objects);
			}
		});
	}

	public <E extends RealmObject> void deleteAll() {
		final RealmResults<TeamData> results = realm.where(TeamData.class).findAll();

		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				if (results == null) {
					return;
				}

				results.deleteAllFromRealm();
			}
		});
	}
}
