package com.alejandrorios.condorsports.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsData {

	@SerializedName("idEvent")
	@Expose
	private String idEvent;
	@SerializedName("idSoccerXML")
	@Expose
	private String idSoccerXML;
	@SerializedName("strEvent")
	@Expose
	private String strEvent;
	@SerializedName("strFilename")
	@Expose
	private String strFilename;
	@SerializedName("strSport")
	@Expose
	private String strSport;
	@SerializedName("idLeague")
	@Expose
	private String idLeague;
	@SerializedName("strLeague")
	@Expose
	private String strLeague;
	@SerializedName("strSeason")
	@Expose
	private String strSeason;
	@SerializedName("strDescriptionEN")
	@Expose
	private Object strDescriptionEN;
	@SerializedName("strHomeTeam")
	@Expose
	private String strHomeTeam;
	@SerializedName("strAwayTeam")
	@Expose
	private String strAwayTeam;
	@SerializedName("intHomeScore")
	@Expose
	private Object intHomeScore;
	@SerializedName("intRound")
	@Expose
	private String intRound;
	@SerializedName("intAwayScore")
	@Expose
	private Object intAwayScore;
	@SerializedName("intSpectators")
	@Expose
	private Object intSpectators;
	@SerializedName("strHomeGoalDetails")
	@Expose
	private Object strHomeGoalDetails;
	@SerializedName("strHomeRedCards")
	@Expose
	private Object strHomeRedCards;
	@SerializedName("strHomeYellowCards")
	@Expose
	private Object strHomeYellowCards;
	@SerializedName("strHomeLineupGoalkeeper")
	@Expose
	private Object strHomeLineupGoalkeeper;
	@SerializedName("strHomeLineupDefense")
	@Expose
	private Object strHomeLineupDefense;
	@SerializedName("strHomeLineupMidfield")
	@Expose
	private Object strHomeLineupMidfield;
	@SerializedName("strHomeLineupForward")
	@Expose
	private Object strHomeLineupForward;
	@SerializedName("strHomeLineupSubstitutes")
	@Expose
	private Object strHomeLineupSubstitutes;
	@SerializedName("strHomeFormation")
	@Expose
	private Object strHomeFormation;
	@SerializedName("strAwayRedCards")
	@Expose
	private Object strAwayRedCards;
	@SerializedName("strAwayYellowCards")
	@Expose
	private Object strAwayYellowCards;
	@SerializedName("strAwayGoalDetails")
	@Expose
	private Object strAwayGoalDetails;
	@SerializedName("strAwayLineupGoalkeeper")
	@Expose
	private Object strAwayLineupGoalkeeper;
	@SerializedName("strAwayLineupDefense")
	@Expose
	private Object strAwayLineupDefense;
	@SerializedName("strAwayLineupMidfield")
	@Expose
	private Object strAwayLineupMidfield;
	@SerializedName("strAwayLineupForward")
	@Expose
	private Object strAwayLineupForward;
	@SerializedName("strAwayLineupSubstitutes")
	@Expose
	private Object strAwayLineupSubstitutes;
	@SerializedName("strAwayFormation")
	@Expose
	private Object strAwayFormation;
	@SerializedName("intHomeShots")
	@Expose
	private Object intHomeShots;
	@SerializedName("intAwayShots")
	@Expose
	private Object intAwayShots;
	@SerializedName("dateEvent")
	@Expose
	private String dateEvent;
	@SerializedName("strDate")
	@Expose
	private String strDate;
	@SerializedName("strTime")
	@Expose
	private String strTime;
	@SerializedName("strTVStation")
	@Expose
	private Object strTVStation;
	@SerializedName("idHomeTeam")
	@Expose
	private String idHomeTeam;
	@SerializedName("idAwayTeam")
	@Expose
	private String idAwayTeam;
	@SerializedName("strResult")
	@Expose
	private Object strResult;
	@SerializedName("strCircuit")
	@Expose
	private Object strCircuit;
	@SerializedName("strCountry")
	@Expose
	private Object strCountry;
	@SerializedName("strCity")
	@Expose
	private Object strCity;
	@SerializedName("strPoster")
	@Expose
	private Object strPoster;
	@SerializedName("strFanart")
	@Expose
	private Object strFanart;
	@SerializedName("strThumb")
	@Expose
	private Object strThumb;
	@SerializedName("strBanner")
	@Expose
	private Object strBanner;
	@SerializedName("strMap")
	@Expose
	private Object strMap;
	@SerializedName("strLocked")
	@Expose
	private String strLocked;

	public String getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(String idEvent) {
		this.idEvent = idEvent;
	}

	public String getIdSoccerXML() {
		return idSoccerXML;
	}

	public void setIdSoccerXML(String idSoccerXML) {
		this.idSoccerXML = idSoccerXML;
	}

	public String getStrEvent() {
		return strEvent;
	}

	public void setStrEvent(String strEvent) {
		this.strEvent = strEvent;
	}

	public String getStrFilename() {
		return strFilename;
	}

	public void setStrFilename(String strFilename) {
		this.strFilename = strFilename;
	}

	public String getStrSport() {
		return strSport;
	}

	public void setStrSport(String strSport) {
		this.strSport = strSport;
	}

	public String getIdLeague() {
		return idLeague;
	}

	public void setIdLeague(String idLeague) {
		this.idLeague = idLeague;
	}

	public String getStrLeague() {
		return strLeague;
	}

	public void setStrLeague(String strLeague) {
		this.strLeague = strLeague;
	}

	public String getStrSeason() {
		return strSeason;
	}

	public void setStrSeason(String strSeason) {
		this.strSeason = strSeason;
	}

	public Object getStrDescriptionEN() {
		return strDescriptionEN;
	}

	public void setStrDescriptionEN(Object strDescriptionEN) {
		this.strDescriptionEN = strDescriptionEN;
	}

	public String getStrHomeTeam() {
		return strHomeTeam;
	}

	public void setStrHomeTeam(String strHomeTeam) {
		this.strHomeTeam = strHomeTeam;
	}

	public String getStrAwayTeam() {
		return strAwayTeam;
	}

	public void setStrAwayTeam(String strAwayTeam) {
		this.strAwayTeam = strAwayTeam;
	}

	public Object getIntHomeScore() {
		return intHomeScore;
	}

	public void setIntHomeScore(Object intHomeScore) {
		this.intHomeScore = intHomeScore;
	}

	public String getIntRound() {
		return intRound;
	}

	public void setIntRound(String intRound) {
		this.intRound = intRound;
	}

	public Object getIntAwayScore() {
		return intAwayScore;
	}

	public void setIntAwayScore(Object intAwayScore) {
		this.intAwayScore = intAwayScore;
	}

	public Object getIntSpectators() {
		return intSpectators;
	}

	public void setIntSpectators(Object intSpectators) {
		this.intSpectators = intSpectators;
	}

	public Object getStrHomeGoalDetails() {
		return strHomeGoalDetails;
	}

	public void setStrHomeGoalDetails(Object strHomeGoalDetails) {
		this.strHomeGoalDetails = strHomeGoalDetails;
	}

	public Object getStrHomeRedCards() {
		return strHomeRedCards;
	}

	public void setStrHomeRedCards(Object strHomeRedCards) {
		this.strHomeRedCards = strHomeRedCards;
	}

	public Object getStrHomeYellowCards() {
		return strHomeYellowCards;
	}

	public void setStrHomeYellowCards(Object strHomeYellowCards) {
		this.strHomeYellowCards = strHomeYellowCards;
	}

	public Object getStrHomeLineupGoalkeeper() {
		return strHomeLineupGoalkeeper;
	}

	public void setStrHomeLineupGoalkeeper(Object strHomeLineupGoalkeeper) {
		this.strHomeLineupGoalkeeper = strHomeLineupGoalkeeper;
	}

	public Object getStrHomeLineupDefense() {
		return strHomeLineupDefense;
	}

	public void setStrHomeLineupDefense(Object strHomeLineupDefense) {
		this.strHomeLineupDefense = strHomeLineupDefense;
	}

	public Object getStrHomeLineupMidfield() {
		return strHomeLineupMidfield;
	}

	public void setStrHomeLineupMidfield(Object strHomeLineupMidfield) {
		this.strHomeLineupMidfield = strHomeLineupMidfield;
	}

	public Object getStrHomeLineupForward() {
		return strHomeLineupForward;
	}

	public void setStrHomeLineupForward(Object strHomeLineupForward) {
		this.strHomeLineupForward = strHomeLineupForward;
	}

	public Object getStrHomeLineupSubstitutes() {
		return strHomeLineupSubstitutes;
	}

	public void setStrHomeLineupSubstitutes(Object strHomeLineupSubstitutes) {
		this.strHomeLineupSubstitutes = strHomeLineupSubstitutes;
	}

	public Object getStrHomeFormation() {
		return strHomeFormation;
	}

	public void setStrHomeFormation(Object strHomeFormation) {
		this.strHomeFormation = strHomeFormation;
	}

	public Object getStrAwayRedCards() {
		return strAwayRedCards;
	}

	public void setStrAwayRedCards(Object strAwayRedCards) {
		this.strAwayRedCards = strAwayRedCards;
	}

	public Object getStrAwayYellowCards() {
		return strAwayYellowCards;
	}

	public void setStrAwayYellowCards(Object strAwayYellowCards) {
		this.strAwayYellowCards = strAwayYellowCards;
	}

	public Object getStrAwayGoalDetails() {
		return strAwayGoalDetails;
	}

	public void setStrAwayGoalDetails(Object strAwayGoalDetails) {
		this.strAwayGoalDetails = strAwayGoalDetails;
	}

	public Object getStrAwayLineupGoalkeeper() {
		return strAwayLineupGoalkeeper;
	}

	public void setStrAwayLineupGoalkeeper(Object strAwayLineupGoalkeeper) {
		this.strAwayLineupGoalkeeper = strAwayLineupGoalkeeper;
	}

	public Object getStrAwayLineupDefense() {
		return strAwayLineupDefense;
	}

	public void setStrAwayLineupDefense(Object strAwayLineupDefense) {
		this.strAwayLineupDefense = strAwayLineupDefense;
	}

	public Object getStrAwayLineupMidfield() {
		return strAwayLineupMidfield;
	}

	public void setStrAwayLineupMidfield(Object strAwayLineupMidfield) {
		this.strAwayLineupMidfield = strAwayLineupMidfield;
	}

	public Object getStrAwayLineupForward() {
		return strAwayLineupForward;
	}

	public void setStrAwayLineupForward(Object strAwayLineupForward) {
		this.strAwayLineupForward = strAwayLineupForward;
	}

	public Object getStrAwayLineupSubstitutes() {
		return strAwayLineupSubstitutes;
	}

	public void setStrAwayLineupSubstitutes(Object strAwayLineupSubstitutes) {
		this.strAwayLineupSubstitutes = strAwayLineupSubstitutes;
	}

	public Object getStrAwayFormation() {
		return strAwayFormation;
	}

	public void setStrAwayFormation(Object strAwayFormation) {
		this.strAwayFormation = strAwayFormation;
	}

	public Object getIntHomeShots() {
		return intHomeShots;
	}

	public void setIntHomeShots(Object intHomeShots) {
		this.intHomeShots = intHomeShots;
	}

	public Object getIntAwayShots() {
		return intAwayShots;
	}

	public void setIntAwayShots(Object intAwayShots) {
		this.intAwayShots = intAwayShots;
	}

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getStrTime() {
		return strTime;
	}

	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

	public Object getStrTVStation() {
		return strTVStation;
	}

	public void setStrTVStation(Object strTVStation) {
		this.strTVStation = strTVStation;
	}

	public String getIdHomeTeam() {
		return idHomeTeam;
	}

	public void setIdHomeTeam(String idHomeTeam) {
		this.idHomeTeam = idHomeTeam;
	}

	public String getIdAwayTeam() {
		return idAwayTeam;
	}

	public void setIdAwayTeam(String idAwayTeam) {
		this.idAwayTeam = idAwayTeam;
	}

	public Object getStrResult() {
		return strResult;
	}

	public void setStrResult(Object strResult) {
		this.strResult = strResult;
	}

	public Object getStrCircuit() {
		return strCircuit;
	}

	public void setStrCircuit(Object strCircuit) {
		this.strCircuit = strCircuit;
	}

	public Object getStrCountry() {
		return strCountry;
	}

	public void setStrCountry(Object strCountry) {
		this.strCountry = strCountry;
	}

	public Object getStrCity() {
		return strCity;
	}

	public void setStrCity(Object strCity) {
		this.strCity = strCity;
	}

	public Object getStrPoster() {
		return strPoster;
	}

	public void setStrPoster(Object strPoster) {
		this.strPoster = strPoster;
	}

	public Object getStrFanart() {
		return strFanart;
	}

	public void setStrFanart(Object strFanart) {
		this.strFanart = strFanart;
	}

	public Object getStrThumb() {
		return strThumb;
	}

	public void setStrThumb(Object strThumb) {
		this.strThumb = strThumb;
	}

	public Object getStrBanner() {
		return strBanner;
	}

	public void setStrBanner(Object strBanner) {
		this.strBanner = strBanner;
	}

	public Object getStrMap() {
		return strMap;
	}

	public void setStrMap(Object strMap) {
		this.strMap = strMap;
	}

	public String getStrLocked() {
		return strLocked;
	}

	public void setStrLocked(String strLocked) {
		this.strLocked = strLocked;
	}
}
