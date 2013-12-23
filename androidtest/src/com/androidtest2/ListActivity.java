package com.androidtest2;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class ListActivity {
	
	private static List<Activity> list=new LinkedList<Activity>();
	private static ListActivity listActivity;
	//����ģʽ(��˽�л��޲ι��췽��)
	private ListActivity(){
		
	}
	public static ListActivity getListActivity(){
		if(listActivity==null){
			return new ListActivity();
		}
		return listActivity;
	}
//	���ҳ�浽������
	public void addActibity(Activity act){
		if(act!=null){
			list.add(act);
		}
	}
//	ɾ�����е�ҳ��
	public void delAll(){
		for(Activity a:list){
			a.finish();
		}
	}
}
