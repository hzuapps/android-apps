package edu_hzuapps_androidworks_homeworks_com1314080901115_activity;

import com.example.dianzicaidan.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Weiyemian extends Activity
{
	private Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weiyemian);
		bt2=(Button) findViewById(R.id.button1_second);
		bt2.setOnClickListener(new OnClickListener()
		{
			@Override
		public void onClick(View v)
		{
		// ����Intent����
		Intent intent=new Intent();
		//ΪIntent����Action,Category����
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
		}
		}); 
	}
	
}
