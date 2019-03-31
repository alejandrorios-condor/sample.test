package com.alejandrorios.condorsports.ui.teamDetails;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alejandrorios.condorsports.R;
import com.alejandrorios.condorsports.adapters.EventsListAdapter;
import com.alejandrorios.condorsports.common.ConfirmationDialog;
import com.alejandrorios.condorsports.models.EventsData;
import com.alejandrorios.condorsports.models.TeamData;
import com.alejandrorios.condorsports.service.api.GetEventsList;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamDetailsActivity extends AppCompatActivity implements TeamDetailsActivityView, BottomNavigationView.OnNavigationItemSelectedListener {

	@BindView(R.id.collapsing_toolbar)
	CollapsingToolbarLayout collapsing_toolbar;

	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@BindView(R.id.bottomNavTeam)
	BottomNavigationView bottomNavTeam;

	@BindView(R.id.pbEventsList)
	ProgressBar pbEventsList;

	@BindView(R.id.imgTeam)
	ImageView imgTeam;

	@BindView(R.id.imgTeamJersey)
	ImageView imgTeamJersey;

	@BindView(R.id.txtTeamFormedYear)
	TextView txtTeamFormedYear;

	@BindView(R.id.txtTeamDesc)
	TextView txtTeamDesc;

	@BindView(R.id.rvEventsList)
	RecyclerView rvEventsList;

	private TeamDetailsPresenter presenter;
	private TeamData teamData;
	private ConfirmationDialog dialog;

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_details);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);

		final Bundle arguments = getIntent().getExtras();

		try {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setDisplayShowHomeEnabled(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (arguments != null) {
			final Gson gson = new Gson();
			teamData = gson.fromJson(getIntent().getStringExtra("teamData"), TeamData.class);
			collapsing_toolbar.setTitle(teamData.getStrTeam());
		}

		presenter = new TeamDetailsPresenter(getApplicationContext(), this, new GetEventsList());
		presenter.fetchEventsData(teamData);
	}

	@Override
	public void setupEventsList(final List<EventsData> eventsData) {
		final LinearLayoutManager llm = new LinearLayoutManager(this);
		final int resId = R.anim.recycler_animation_falldown;
		final LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);

		txtTeamFormedYear.setText(teamData.getIntFormedYear());
		txtTeamDesc.setText(teamData.getStrDescriptionEN());

		if (!TextUtils.isEmpty(teamData.getStrTeamBadge())) {
			Glide.with(this)
					.load(teamData.getStrTeamBadge())
					.diskCacheStrategy(DiskCacheStrategy.DATA)
					.placeholder(R.drawable.ic_soccer_ball)
					.error(R.drawable.ic_no_img)
					.into(imgTeam);
		} else {
			imgTeam.setImageDrawable(getResources().getDrawable(R.drawable.ic_no_img));
		}

		if (!TextUtils.isEmpty(teamData.getStrTeamJersey())) {
			Glide.with(this)
					.load(teamData.getStrTeamJersey())
					.diskCacheStrategy(DiskCacheStrategy.DATA)
					.placeholder(R.drawable.ic_soccer_ball)
					.error(R.drawable.ic_no_img)
					.into(imgTeamJersey);
		} else {
			imgTeamJersey.setImageDrawable(getResources().getDrawable(R.drawable.ic_no_img));
		}

		if (eventsData != null && eventsData.size() > 0) {
			final EventsListAdapter adapter = new EventsListAdapter(this, eventsData);
			rvEventsList.setLayoutManager(llm);
			rvEventsList.setLayoutAnimation(animation);
			rvEventsList.setAdapter(adapter);
		}

		bottomNavTeam.setItemIconTintList(null);
		bottomNavTeam.setOnNavigationItemSelectedListener(this);
		showProgress(false);
	}

	@Override
	public void showProgress(final boolean show) {
		final int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

		pbEventsList.setVisibility(show ? View.VISIBLE : View.GONE);
		pbEventsList.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(final Animator animation) {
				pbEventsList.setVisibility(show ? View.VISIBLE : View.GONE);
			}
		});
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
		switch (menuItem.getItemId()) {
			case R.id.navWebSite:
				if (!TextUtils.isEmpty(teamData.getStrWebsite())) {
					presenter.goWebsite(teamData.getStrWebsite());
				} else {
					showDialogMsg(R.string.team_details_no_web);
				}
				break;
			case R.id.navFacebook:
				if (!TextUtils.isEmpty(teamData.getStrFacebook())) {
					presenter.goFacebook(teamData.getStrFacebook());
				} else {
					showDialogMsg(R.string.team_details_no_facebook);
				}
				break;
			case R.id.navTwitter:
				if (!TextUtils.isEmpty(teamData.getStrTwitter())) {
					presenter.goTwitter(teamData.getStrTwitter());
				} else {
					showDialogMsg(R.string.team_details_no_twitter);
				}
				break;
			case R.id.navInstagram:
				if (!TextUtils.isEmpty(teamData.getStrInstagram())) {
					presenter.goInstagram(teamData.getStrInstagram());
				} else {
					showDialogMsg(R.string.team_details_no_instagram);
				}
				break;
			case R.id.navYouTube:
				if (!TextUtils.isEmpty(teamData.getStrYoutube())) {
					presenter.goYouTube(teamData.getStrYoutube());
				} else {
					showDialogMsg(R.string.team_details_no_youtube);
				}
				break;
		}
		return true;
	}

	public void showDialogMsg(final int msg) {
		if (dialog == null) {
			dialog = new ConfirmationDialog(this);
		}

		dialog.showSimple(msg, true);
	}
}
