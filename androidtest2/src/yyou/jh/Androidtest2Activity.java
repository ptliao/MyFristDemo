package yyou.jh;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
 * ���������
 */
public class Androidtest2Activity extends Activity {
    /** Called when the activity is first created. */
//	�ı���ǩ
	private TextView text1;
//	����ѡ���
	private Spinner sp;
	private List<String> list=new ArrayList<String>();
	private static final String Tag="asdf";
//	��ѡ��
	private CheckBox checkBox1,checkBox2,checkBox3;
	private List<CheckBox> listcheckBoxs=new ArrayList<CheckBox>();
//	��ѡ����
	private RadioGroup rodiogroup;
//	��ѡ��ť
	private RadioButton radiobutton1,radiobutton2;
//	��ҳ��ͼ
	private WebView webview;
	private MenuItem item;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		text1 =(TextView)findViewById(R.id.textview1);
		text1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Androidtest2Activity.this,Androidtest3Activity.class);
				intent.putExtra("key", "����ת������");
				
				startActivity(intent);
			}
		});
//		����ѡ��������
		sp=(Spinner) findViewById(R.id.spinner);
		list.add("sdf");
		list.add("wolail");
		list.add("123123");
		list.add("qwqweqwe");
       
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(Androidtest2Activity.this, list.get(arg2), Toast.LENGTH_LONG).show();	
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub	
			}
		});
		checkBox1 =(CheckBox) findViewById(R.id.checkBox);
		checkBox2 =(CheckBox) findViewById(R.id.checkBox1);
		checkBox3 =(CheckBox) findViewById(R.id.checkBox2);
		listcheckBoxs.add(checkBox1);
		listcheckBoxs.add(checkBox2);
		listcheckBoxs.add(checkBox3);
		for(CheckBox check:listcheckBoxs){
			check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(isChecked){
						Toast.makeText(Androidtest2Activity.this, buttonView.getText()+"ѡ�а�ť", Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(Androidtest2Activity.this,buttonView.getText()+ "δѡ�а�ť", Toast.LENGTH_SHORT).show();
					}
					
				}
			});
		}
		
		
		rodiogroup=(RadioGroup) findViewById(R.id.radioGroup1);
		rodiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				radiobutton1=(RadioButton) findViewById(checkedId);
				Toast.makeText(Androidtest2Activity.this, radiobutton1.getText()+"ѡ�а�ť", Toast.LENGTH_SHORT).show();
			}
		});
//		���ؾ�̬��ҳ����
		webview=(WebView) findViewById(R.id.webview);
		String ss=WebString.webHtml;
		webview.loadDataWithBaseURL(null, ss, "text/html", "utf-8", null);
    }
//    ����ѡ��˵�
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflate=getMenuInflater();
    	inflate.inflate(R.menu.menu, menu);
    	int length=menu.size();
    	for(int i=0;i<length;i++){
    		item=menu.getItem(i);
        	item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
    			
    			@Override
    			public boolean onMenuItemClick(MenuItem item) {
    				
    				Toast.makeText(Androidtest2Activity.this,item.getTitle() , Toast.LENGTH_SHORT).show();
    				return false;
    			}
    		});
    	}
    	
    	return super.onCreateOptionsMenu(menu);
    }
    
}