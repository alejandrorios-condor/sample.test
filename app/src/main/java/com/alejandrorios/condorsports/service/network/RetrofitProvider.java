package com.alejandrorios.condorsports.service.network;

import com.alejandrorios.condorsports.models.Events;
import com.alejandrorios.condorsports.models.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitProvider {

	@GET("lookup_all_teams.php")
	Call<Team> getTeamByLeague(@Query("id") String userId);

	@GET("eventsnext.php")
	Call<Events> getEventsByTeam(@Query("id") String teamId);
}
