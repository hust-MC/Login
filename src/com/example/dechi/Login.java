package com.example.dechi;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Html;
import android.view.Menu;
import android.view.Window;
import android.widget.*;
import android.view.*;

public class Login extends Activity
{
	TextView softName, usrName, usrPwd, checkCode;
	EditText inputName, inputPwd, inputCode;
	Button confirm, clear;
	Spinner usrType;
	CheckBox rememberMe;

	public void soft_Name()
	{
		String softName_Text = "<b><i><tt><big>"
				+ getResources().getString(R.string.Name)
				+ "</big></tt></i></b>";
		CharSequence softName_Sequence = Html.fromHtml(softName_Text);
		softName.setText(softName_Sequence);
	}

	public void usrType()
	{
		usrType = (Spinner) findViewById(R.id.spinner);

		ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.spinner, android.R.layout.simple_list_item_1);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		usrType.setAdapter(adapter);
	}

	public void widget_init()
	{
		softName = (TextView) findViewById(R.id.softname);
		usrName = (TextView) findViewById(R.id.usrname);
		usrPwd = (TextView) findViewById(R.id.usrpwd);
		checkCode = (TextView) findViewById(R.id.check);

		inputName = (EditText) findViewById(R.id.input_name);
		inputPwd = (EditText) findViewById(R.id.inputpwd);
		inputCode = (EditText) findViewById(R.id.inputcheck);

		rememberMe = (CheckBox) findViewById(R.id.remember_me);
	}

	public void getSave()
	{
		SharedPreferences sp = getSharedPreferences("rememberMe",
				Activity.MODE_PRIVATE);
		String isSaved = sp.getString("isSaved", "no");
		if (isSaved.equals("yes"))
		{
			String spName = sp.getString("name", "");
			inputName.setText(spName);
		}
	}

	public void save()
	{
		SharedPreferences sp = getSharedPreferences("rememberMe",
				Activity.MODE_PRIVATE);
		SharedPreferences.Editor spEdit = sp.edit();
		if (rememberMe.isChecked())
		{
			spEdit.putString("isSaved", "yes");
			spEdit.putString("name", inputName.getText().toString());
		}
		else
		{
			spEdit.putString("isSaved", "no");
		}
		spEdit.commit();
	}

	// 按下确定键, 验证用户身份
	public void onClick_confirm(View view)
	{
		String name = inputName.getText().toString();
		String pwd = inputPwd.getText().toString();

		if (name.length() == 0)
		{
			Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
		}
		else if (pwd.length() == 0)
		{
			Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
		}
		else
		{
			if (usrType.getSelectedItem().equals(new String("内部员工")))
			{
				if (name.equals(new String("mc"))
						&& pwd.equals(new String("123456")))
				{
					Intent intent = new Intent(this,Company.class);
					startActivity(intent);
					
					Toast.makeText(this, "内部员工登陆成功", Toast.LENGTH_SHORT).show();
					save();
				}
				else
				{
					Toast.makeText(this, "您输入的账号或者密码错误", Toast.LENGTH_SHORT)
							.show();
				}
			}
			else
			{
				if (name.equals(new String("dechi"))
						&& pwd.equals(new String("dechi")))
				{
					Intent intent  = new Intent(this,Vip.class);
					startActivity(intent);
					
					Toast.makeText(this, "会员客户成功", Toast.LENGTH_SHORT).show();
					save();
				}
				else
				{
					Toast.makeText(this, "您输入的账号或者密码错误", Toast.LENGTH_SHORT)
							.show();
				}
			}
		}
	}

	public void onClick_newUsr(View view)
	{
		Intent intent = new Intent("android.inent.action.register1");
		startActivity(intent);
	}
	
	// 按下清空键, 清除输入内容
	public void onClick_clear(View view)
	{
		inputName.setText("");
		inputCode.setText("");
		inputPwd.setText("");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		widget_init(); // 初始化控件
		soft_Name();
		usrType();
		getSave();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
