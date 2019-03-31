package com.alejandrorios.condorsports.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alejandrorios.condorsports.R;
import com.alejandrorios.condorsports.common.RealmManager;
import com.alejandrorios.condorsports.models.EventsData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.EventsHolder> {

	private Context context;
	private List<EventsData> eventsList;
	private RecyclerView recyclerView = null;

	public EventsListAdapter(final Context context, final List<EventsData> eventsList) {
		this.context = context;
		this.eventsList = eventsList;
	}

	@NonNull
	@Override
	public EventsHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
		return new EventsHolder(v);
	}

	@Override
	public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);

		this.recyclerView = recyclerView;
	}

	@Override
	public void onBindViewHolder(@NonNull final EventsHolder holder, final int position) {
		final EventsData event = eventsList.get(position);
		final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yy", Locale.US);
		final Date date;
		final String homeTeamBadge = RealmManager.getInstance().getTeamByName(event.getIdHomeTeam());
		final String awayTeamBadge = RealmManager.getInstance().getTeamByName(event.getIdAwayTeam());

		try {
			date = sf.parse(event.getStrDate());
			sf.applyPattern("dd MMMM yyyy");

			holder.txtEventDate.setText(sf.format(date));
		} catch (Exception e) {
			holder.txtEventDate.setText(context.getString(R.string.event_date_error));
		}

		holder.txthomeTeam.setText(event.getStrHomeTeam());
		holder.txtAwayTeam.setText(event.getStrAwayTeam());

		if (!TextUtils.isEmpty(homeTeamBadge)) {
			Glide.with(context)
					.load(homeTeamBadge)
					.diskCacheStrategy(DiskCacheStrategy.DATA)
					.placeholder(R.drawable.ic_soccer_ball)
					.error(R.drawable.ic_no_img)
					.into(new SimpleTarget<Drawable>(100, 220) {
						@Override
						public void onResourceReady(@NonNull final Drawable resource,
													@Nullable final Transition<? super Drawable> transition) {
							holder.txthomeTeam.setCompoundDrawablesWithIntrinsicBounds(null, resource, null, null);
						}
					});
		} else {
			holder.txthomeTeam.setCompoundDrawablesWithIntrinsicBounds(null, context.getResources().getDrawable(R.drawable.ic_no_img), null, null);
		}

		if (!TextUtils.isEmpty(awayTeamBadge)) {
			Glide.with(context)
					.load(awayTeamBadge)
					.diskCacheStrategy(DiskCacheStrategy.DATA)
					.placeholder(R.drawable.ic_soccer_ball)
					.error(R.drawable.ic_no_img)
					.into(new SimpleTarget<Drawable>(100, 220) {
						@Override
						public void onResourceReady(@NonNull final Drawable resource,
													@Nullable final Transition<? super Drawable> transition) {
							holder.txtAwayTeam.setCompoundDrawablesWithIntrinsicBounds(null, resource, null, null);
						}
					});
		} else {
			holder.txtAwayTeam.setCompoundDrawablesWithIntrinsicBounds(null, context.getResources().getDrawable(R.drawable.ic_no_img), null, null);
		}

	}

	@Override
	public int getItemCount() {
		return eventsList.size();
	}

	public class EventsHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.txtHomeTeam)
		TextView txthomeTeam;
		@BindView(R.id.txtAwayTeam)
		TextView txtAwayTeam;
		@BindView(R.id.txtEventDate)
		TextView txtEventDate;

		public EventsHolder(final View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
