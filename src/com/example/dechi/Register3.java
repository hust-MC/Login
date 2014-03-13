package com.example.dechi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;

public class Register3 extends Activity
{
	public void onClick_back(View view)
	{
		Intent intent = new Intent(this,Register2.class);
		startActivity(intent);
	}
	
	public void onClick_commit(View view)
	{
		Toast.makeText(this, "×¢²á³É¹¦", Toast.LENGTH_SHORT).show();;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register3);
	}
}
