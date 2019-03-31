package com.alejandrorios.condorsports.ui.mainActivity;

import com.alejandrorios.condorsports.adapters.TeamListAdapter;
import com.alejandrorios.condorsports.models.Team;
import com.alejandrorios.condorsports.models.TeamData;

import java.util.List;

public interface MainActivityView {
	interface Presenter extends TeamListAdapter.Delegate {
		void getTeamsList(String leagueCode);
	}

	interface GetTeamsInteractor {

		interface OnFinishedListener {
			void onFinished(Team teamList);

			void onFailure(Throwable t);
		}

		void getTeamsList(String codeLeague, OnFinishedListener onFinishedListener);
	}

	void setupTeamsList(List<TeamData> teams);

	void showProgress(boolean show);

	void showMsg(boolean show);
}
