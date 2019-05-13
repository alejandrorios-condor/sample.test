package com.alejandrorios.condorsports.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alejandrorios.condorsports.R;
import com.alejandrorios.condorsports.ui.mainActivity.MainActivity;

public class CondorSportsActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme);
		super.onCreate(savedInstanceState);
		startActivity(new Intent(CondorSportsActivity.this, MainActivity.class));
		finish();
	}
}