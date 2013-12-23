package com.it.dialogcomfirm;

import com.androidtest.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class mainActivity extends Activity {
	private Button but, but_ok, but_cancel;
	private Dialog dia;
	private TextView tv_mess;
	private boolean stopThread;
	private int count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 去掉提示信息栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.dialogconfirm_main);

		but = (Button) findViewById(R.id.con_but);
		but.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				

				dia = new Dialog(mainActivity.this, R.style.MyDialog);
				View view = getLayoutInflater().inflate(R.layout.dialog, null);
				dia.setContentView(view);
				tv_mess=(TextView) view.findViewById(R.id.dia_tv_mess);
				but_ok = (Button) view.findViewById(R.id.dialog_button_ok);
				but_cancel = (Button) view
						.findViewById(R.id.dialog_button_cancel);
				but_ok.setOnClickListener(onClickListener);
				but_cancel.setOnClickListener(onClickListener);
				dia.show();
				
				
				count=10;
				stopThread=true;
				new Thread(){
					public void run() {
						while(stopThread){
							count--;
							Message mes=Message.obtain(myHandler);
							if(count==0){
								mes.obj="end";
								mes.arg1=count;
								stopThread=false;
								mes.sendToTarget();
								break;
							}else{
								mes.obj="start";
								mes.arg1=count;
								mes.sendToTarget();
							}
							try {
								Thread.sleep(400);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
						}
					};
				}.start();
				
			}
		});
	}

	private OnClickListener onClickListener = new View.OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.dialog_button_ok:
				stopThread=false;
				dia.dismiss();
				break;
			case R.id.dialog_button_cancel:
				stopThread=false;
				dia.dismiss();
				break;
			}
		}
	};
	
	private Handler myHandler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String s=(String)msg.obj;
			int index=msg.arg1;
			if("start".equals(s)){
				tv_mess.setText(Html.fromHtml("<font color='#FF0000'>"+index+"</font>秒钟后将自动发送消息"));
				but_ok.setText(Html.fromHtml("确定<font color='#FF0000'>("+index+")</font>"));
			}else if("end".equals(s)){
				dia.dismiss();
			}
		}
	};
	

}
