package com.alejandrorios.condorsports.common;

import com.alejandrorios.condorsports.models.TeamData;

import io.realm.annotations.RealmModule;

@RealmModule(classes = {TeamData.class})
public class RealmDbModule {
}
