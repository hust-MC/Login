package com.example.dechi;

import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class Register1 extends Activity
{

	EditText comName;
	EditText comName2;

	public void widget_init()
	{
		comName = (EditText) findViewById(R.id.input_comName);
		comName2 = (EditText) findViewById(R.id.input_comName2);
	}

	public void onClick_back(View view)
	{
		Intent intent = new Intent(this, Login.class);
		startActivity(intent);
	}

	public void onClick_next(View view)
	{

		if (comName.getText().length() == 0 || comName2.getText().length() == 0)
		{
			Toast.makeText(this, "*Îª±ØÌîÏî", Toast.LENGTH_LONG).show();
		}
		else
		{
			Intent intent = new Intent(this, Register2.class);
			startActivity(intent);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register1);
		widget_init();
	}
}
