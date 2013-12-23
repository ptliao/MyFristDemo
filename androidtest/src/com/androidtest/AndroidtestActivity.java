package com.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidtest2.ListActivity;

public class AndroidtestActivity extends Activity {
    /** Called when the activity is first created. */
	private static String Tag="ass";
	private ImageView image;
	private Button bt;
	private Button bt2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        去掉标题栏
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        去掉提示信息栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main2);
        ListActivity.getListActivity().addActibity(this);
        Log.e(Tag, "TWOonCreate().........................................");
        image=(ImageView) findViewById(R.id.imag);
        image.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				Intent intent=new Intent(AndroidtestActivity.this,Androidtest2Activity.class);
				startActivity(intent);
			}
		});
        bt=(Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				ListActivity.getListActivity().delAll();	
			}
		});
        
        bt2 =(Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(AndroidtestActivity.this, "您现在在第二个界面", Toast.LENGTH_LONG).show(); 
				
			}
		});
        
    }
    @Override
    protected void onStart() {
    	
    	super.onStart();
    	Log.e(Tag, "TWOonStart().........................................");
    }
    @Override
    protected void onRestart() {
    	
    	super.onRestart();
    	Log.e(Tag, "TWOonRestart().........................................");
    }
    @Override
    protected void onResume() {
    	
    	super.onResume();
    	Log.e(Tag, "TWOonResume().........................................");
    }
    @Override
    protected void onPause() {
    	
    	super.onPause();
    	Log.e(Tag, "TWOonPause().........................................");
    }
    @Override
    protected void onStop() {
    	
    	super.onStop();
    	Log.e(Tag, "TWOonStop().........................................");
    }
    @Override
    protected void onDestroy() {
    	
    	super.onDestroy();
    	Log.e(Tag, "TWOonDestroy().........................................");
    }
}