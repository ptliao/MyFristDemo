package com.androidtest;

import com.androidtest2.ListActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Androidtest2Activity extends Activity{

	private static final String Tag="Androidtest2Activity";
	private TextView text1;
	private Button but_1,but_2,but_3,but_4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
//      去掉标题栏
        
      requestWindowFeature(Window.FEATURE_NO_TITLE);
//      去掉提示信息栏
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		ListActivity.getListActivity().addActibity(this);
		Log.e(Tag, "onCreate()...................................");
		but_1=(Button) findViewById(R.id.button1);
		but_2=(Button) findViewById(R.id.button2);
		but_3=(Button) findViewById(R.id.button3);
		but_4=(Button) findViewById(R.id.button4);
		
		but_1.setOnClickListener(onClickListener);
		but_2.setOnClickListener(onClickListener);
		but_3.setOnClickListener(onClickListener);
		but_4.setOnClickListener(onClickListener);
		
//		text1 =(TextView) findViewById(R.id.text1);
//		text1.setOnClickListener(new View.OnClickListener() {
//			
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent intent=new Intent(Androidtest2Activity.this,AndroidtestActivity.class);
//				startActivity(intent);
//			}
//		});
	}
	
	private OnClickListener onClickListener= new View.OnClickListener() {
		
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button1:
				but_1.requestFocus();
				break;
			case R.id.button2:
				but_2.requestFocus();
				break;
			case R.id.button3:
				but_3.requestFocus();
				break;
			case R.id.button4:
				but_4.requestFocus();
				break;
			}
		}
	};
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e(Tag, "onStart()...................................");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e(Tag, "onResume()...................................");
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.e(Tag, "onRestart()...................................");
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e(Tag, "onStop()...................................");
	}
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	Log.e(Tag, "onPause()...................................");
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	Log.e(Tag, "onDestroy()...................................");
    }
}
