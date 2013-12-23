package yyou.jh;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Androidtest3Activity  extends Activity{

	private TextView text1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		Window myWindow = this.getWindow();
		myWindow.setFlags(flag,flag);

		 setContentView(R.layout.main2);
//		 第一种方式：通过源数据来获取
//		savedInstanceState = getIntent().getExtras();
//		String st=savedInstanceState.getString("key");
//		 第二种方式：通过Intent（意图）来获取
		 String st=getIntent().getStringExtra("key");
		text1=(TextView) findViewById(R.id.text);
		text1.setText(st);
	}
}
