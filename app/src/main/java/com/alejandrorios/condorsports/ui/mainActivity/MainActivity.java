package com.alejandrorios.condorsports.ui.mainActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.alejandrorios.condorsports.R;
import com.alejandrorios.condorsports.adapters.TeamListAdapter;
import com.alejandrorios.condorsports.common.SpacesItemDecoration;
import com.alejandrorios.condorsports.models.TeamData;
import com.alejandrorios.condorsports.service.api.GetTeamsList;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView, SpeedDialView.OnActionSelectedListener {

	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@BindView(R.id.fabChangeLeague)
	SpeedDialView fab;

	@BindView(R.id.pbTeamsList)
	View pbTeamsList;

	@BindView(R.id.rvTeamsList)
	RecyclerView rvTeamsList;

	@BindView(R.id.txtTeamsEmpty)
	TextView txtTeamsEmpty;

	private List<TeamData> teamList;
	private TeamListAdapter adapter;
	private MainActivityPresenter presenter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		setSupportActionBar(toolbar);

		presenter = new MainActivityPresenter(getApplicationContext(), this, new GetTeamsList());
		presenter.getTeamsList(getString(R.string.spanish_league_code));
	}

	@Override
	public void setupTeamsList(final List<TeamData> teams) {
		teamList = teams;
		final StaggeredGridLayoutManager llm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
		final int resId = R.anim.recycler_animation_falldown;
		final LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
		final SpacesItemDecoration decoration = new SpacesItemDecoration(16);

		adapter = new TeamListAdapter(this, teamList);

		llm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
		rvTeamsList.setLayoutManager(llm);
		rvTeamsList.setLayoutAnimation(animation);
		rvTeamsList.setAdapter(adapter);
		rvTeamsList.addItemDecoration(decoration);
		adapter.setDelegate(presenter);

		fab.addActionItem(
				new SpeedDialActionItem.Builder(R.id.fab_uefa_champions_league, R.drawable.ic_russian_league)
						.setLabel(getString(R.string.russian_premier_league_title))
						.setLabelBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()))
						.create()
		);

		fab.addActionItem(
				new SpeedDialActionItem.Builder(R.id.fab_english_premier_league, R.drawable.ic_english)
						.setLabel(getString(R.string.english_league_title))
						.setLabelBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()))
						.create()
		);

		fab.addActionItem(
				new SpeedDialActionItem.Builder(R.id.fab_spanish_league, R.drawable.ic_la_liga)
						.setLabel(getString(R.string.spanish_league_title))
						.setLabelBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()))
						.create()
		);

		fab.setOnActionSelectedListener(this);
	}

	@Override
	public void showProgress(final boolean show) {
		final int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

		rvTeamsList.setVisibility(show ? View.GONE : View.VISIBLE);
		rvTeamsList.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(final Animator animation) {
				rvTeamsList.setVisibility(show ? View.GONE : View.VISIBLE);
			}
		});
		pbTeamsList.setVisibility(show ? View.VISIBLE : View.GONE);
		pbTeamsList.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(final Animator animation) {
				pbTeamsList.setVisibility(show ? View.VISIBLE : View.GONE);
			}
		});
	}

	@Override
	public void showMsg(boolean show) {
		rvTeamsList.setVisibility(show ? View.GONE : View.VISIBLE);
		txtTeamsEmpty.setVisibility(show ? View.VISIBLE : View.GONE);
	}

	@Override
	public boolean onActionSelected(SpeedDialActionItem actionItem) {
		switch (actionItem.getId()) {
			case R.id.fab_spanish_league:
				presenter.getTeamsList(getString(R.string.spanish_league_code));
				break;
			case R.id.fab_english_premier_league:
				presenter.getTeamsList(getString(R.string.english_league_code));
				break;
			case R.id.fab_uefa_champions_league:
				presenter.getTeamsList(getString(R.string.russian_premier_league_code));
				break;
		}
		clearPosts();
		return false;
	}

	public void clearPosts() {
		teamList.clear();
		adapter.notifyDataSetChanged();
	}
}
