package com.alejandrorios.condorsports.ui.teamDetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.alejandrorios.condorsports.models.Events;
import com.alejandrorios.condorsports.models.TeamData;

public class TeamDetailsPresenter implements TeamDetailsActivityView.Presenter, TeamDetailsActivityView.GetEventsInteractor.OnFinishedListener {

	private final Context context;
	private final TeamDetailsActivityView view;
	private final TeamDetailsActivityView.GetEventsInteractor eventsList;

	public TeamDetailsPresenter(final Context context, final TeamDetailsActivityView view, final TeamDetailsActivityView.GetEventsInteractor eventsList) {
		this.context = context;
		this.view = view;
		this.eventsList = eventsList;
	}

	@Override
	public void fetchEventsData(final TeamData team) {
		view.showProgress(true);
		eventsList.getEventsList(team.getIdTeam(), this);
	}

	@Override
	public void goWebsite(final String url) {
		final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + url));

		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	@Override
	public void goFacebook(final String facebook) {
		final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + facebook));

		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	@Override
	public void goTwitter(final String twitter) {
		final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + twitter));

		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	@Override
	public void goInstagram(final String instagram) {
		final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + instagram));

		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	@Override
	public void goYouTube(final String youtube) {
		final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + youtube));

		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	@Override
	public void onFinished(final Events eventsList) {
		if (view != null) {
			view.setupEventsList(eventsList.getEvents());
		}
	}

	@Override
	public void onFailure(final Throwable t) {
		if (view != null) {
			view.showProgress(false);
		}
	}
}
