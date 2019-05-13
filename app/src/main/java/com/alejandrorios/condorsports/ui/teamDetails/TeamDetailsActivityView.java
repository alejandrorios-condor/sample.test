package com.alejandrorios.condorsports.ui.teamDetails;

import com.alejandrorios.condorsports.models.Events;
import com.alejandrorios.condorsports.models.EventsData;
import com.alejandrorios.condorsports.models.TeamData;

import java.util.List;

public interface TeamDetailsActivityView {
	interface Presenter {
		void fetchEventsData(TeamData team);

		void goWebsite(String url);

		void goFacebook(String facebook);

		void goTwitter(String twitter);

		void goInstagram(String instagram);

		void goYouTube(String youtube);
	}

	interface GetEventsInteractor {

		interface OnFinishedListener {
			void onFinished(Events eventsList);

			void onFailure(Throwable t);
		}

		void getEventsList(String teamId, OnFinishedListener onFinishedListener);
	}

	void showProgress(boolean show);

	void setupEventsList(List<EventsData> eventsData);
}
