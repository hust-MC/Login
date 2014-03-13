package com.example.dechi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.Toast;

public class Register2 extends Activity
{
	EditText name;
	EditText mobile;

	public void widget_init()
	{
		name = (EditText) findViewById(R.id.input_newName);
		mobile = (EditText) findViewById(R.id.input_mobile);
	}

	public void onClick_back(View view)
	{
		Intent intent = new Intent(this, Register1.class);
		startActivity(intent);
	}

	public void onClick_next(View view)
	{
		if (name.getText().length() == 0 || mobile.getText().length() == 0)
		{
			Toast.makeText(this, "*Îª±ØÌîÏî", Toast.LENGTH_LONG).show();
		}
		else
		{
			Intent intent = new Intent(this, Register3.class);
			startActivity(intent);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register2);
		widget_init();
	}
}
