package com.alejandrorios.condorsports.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alejandrorios.condorsports.R;
import com.alejandrorios.condorsports.models.TeamData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamHolder> {
	public interface Delegate {
		void onTeamClicked(TeamData team);
	}

	private Context context;
	private List<TeamData> teamsList;
	private RecyclerView recyclerView = null;
	private Delegate delegate;

	public TeamListAdapter(final Context context, final List<TeamData> teamsList) {
		this.context = context;
		this.teamsList = teamsList;
	}

	@NonNull
	@Override
	public TeamHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
		return new TeamHolder(v);
	}

	@Override
	public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);

		this.recyclerView = recyclerView;
	}

	@Override
	public void onBindViewHolder(@NonNull final TeamHolder holder, final int position) {
		final TeamData team = teamsList.get(position);

		holder.txtTeamName.setText(team.getStrTeam());
		holder.txtTeamStadium.setText(team.getStrStadium());

		if (!TextUtils.isEmpty(team.getStrTeamBadge())) {
			Glide.with(context)
					.load(team.getStrTeamBadge())
					.diskCacheStrategy(DiskCacheStrategy.DATA)
					.placeholder(R.drawable.ic_soccer_ball)
					.error(R.drawable.ic_no_img)
					.into(holder.imgTeamBadge);
		} else {
			holder.imgTeamBadge.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_no_img));
		}

		holder.lytTeam.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				delegate.onTeamClicked(team);
			}
		});
	}

	@Override
	public int getItemCount() {
		return teamsList.size();
	}

	public class TeamHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.imgTeamBadge)
		ImageView imgTeamBadge;
		@BindView(R.id.txtTeamName)
		TextView txtTeamName;
		@BindView(R.id.txtTeamStadium)
		TextView txtTeamStadium;
		@BindView(R.id.lytTeam)
		View lytTeam;

		public TeamHolder(final View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}

	public void setDelegate(final Delegate delegate) {
		this.delegate = delegate;
	}
}
