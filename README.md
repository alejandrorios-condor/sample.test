# Condor Sports

Condor Sports is a sample app that shows a list of of teams from [The Sports DB](https://www.thesportsdb.com/api.php). The app runs from API 21 and above, just copy the project and run it as you normally run an Android project.

## Proposed Architecture
This app is builded with a MVP Architecture, which is one of the most popular patterns to organize the presentation layer for Android applications.

## Third-party libraries
The app uses this libraries:

  - [Retrofit 2](https://square.github.io/retrofit/): type-safe client for Android and Java, used to make API REST calls.
  - [Realm](https://realm.io/docs/java/latest/): database management system used for this project.
  - [Guava](https://github.com/google/guava): is a set of libraries from Google that facilitates things like sort an array, filter from a list, Null validations, etc.
  - [ButterKnife](https://github.com/JakeWharton/butterknife): Library that uses annotations to bind fields and methods for android views.
  - [Speed Dial Floating Button](https://github.com/leinardi/FloatingActionButtonSpeedDial): Simple library used to swipe or slide a layout to show a different layout.

## Project Structure

```sh
.
├── adapters
├── common
├── models
├── service
│   ├── api
│   └── network
└── ui
    ├── mainActivity
    └── teamDetails

```

- `. app` main folder of the project.
- `adapters` contains the implementation of the 2 lists used (TeamsList, Events).
- `common` Realm configuration class, Manager for Realm queries, Dialog and Custom item decorator for Teams List.
- `models` POJO files for the API call response.
- `service` API classes for the Retrofit calls.
- `ui` main content folder, where all the magic happens :)

### Notes and considerations

  - Most of the drawable resources were taken from this source: https://www.flaticon.com/
  - La liga logo taken from: http://dheyaa-hussein.com/applications/Infoviz2017/works/francisco/img/LaLiga-white.png
  - English League logo taken from: https://s3-us-west-2.amazonaws.com/theathletic-league-logos/league-6.png
  - Russian League logo taken from: https://www.thesportsdb.com/images/media/league/badge/fg0ad21532769374.png