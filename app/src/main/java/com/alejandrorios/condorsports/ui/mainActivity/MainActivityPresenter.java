package com.alejandrorios.condorsports.ui.mainActivity;

import android.content.Context;
import android.content.Intent;

import com.alejandrorios.condorsports.adapters.TeamListAdapter;
import com.alejandrorios.condorsports.common.RealmManager;
import com.alejandrorios.condorsports.models.Team;
import com.alejandrorios.condorsports.models.TeamData;
import com.alejandrorios.condorsports.ui.teamDetails.TeamDetailsActivity;
import com.google.gson.Gson;

public class MainActivityPresenter implements MainActivityView.Presenter, MainActivityView.GetTeamsInteractor.OnFinishedListener, TeamListAdapter.Delegate {

	private final Context context;
	private final MainActivityView view;
	private final MainActivityView.GetTeamsInteractor teamsList;

	public MainActivityPresenter(final Context context, final MainActivityView view, final MainActivityView.GetTeamsInteractor teamsList) {
		this.context = context;
		this.view = view;
		this.teamsList = teamsList;
	}

	@Override
	public void getTeamsList(final String codeLeague) {
		view.showProgress(true);
		teamsList.getTeamsList(codeLeague, this);
	}

	@Override
	public void onFinished(final Team teamList) {
		if (view != null) {
			view.showProgress(false);
			RealmManager.getInstance().saveList(teamList.getTeams(), TeamData.class);
			view.setupTeamsList(teamList.getTeams());
		}
	}

	@Override
	public void onFailure(final Throwable t) {
		if (view != null) {
			view.showProgress(false);
			view.showMsg(true);
		}
	}

	@Override
	public void onTeamClicked(final TeamData team) {
		final Intent intent = new Intent(context, TeamDetailsActivity.class);
		final Gson gson = new Gson();
		final String teamJson = gson.toJson(team);

		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("teamData", teamJson);
		context.startActivity(intent);
	}
}
