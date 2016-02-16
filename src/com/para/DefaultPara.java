package com.para;

import android.content.Context;

public class DefaultPara {

	GetPara gp=new GetPara();
	SetPara sp=new SetPara();
	
	//public String Ipaddr="218.107.191.49";
	//public String ServerPort="28571";
	
	public String Ipaddr="192.168.1.2";
	public String ServerPort="8887";
	
	public void exec(Context ctx)
	{
		
		sp.setPara(ctx, "username", "gg");
		sp.setPara(ctx, "filename", "gg");
		
		sp.setPara(ctx, "isFirst", "1");
		sp.setPara(ctx, "isService", "1");
		sp.setPara(ctx, "Ipaddr", Ipaddr);
		//sp.setPara(ctx, "FTPDir", 21);
		sp.setPara(ctx, "FTPPort", 21);
		sp.setPara(ctx, "ServerPort", ServerPort);
		sp.setPara(ctx, "FTPUsername", "gg");
		sp.setPara(ctx, "FTPPassword", "123456");
		//sp.setPara(ctx, "Username", "gg");
		//sp.setPara(ctx, "Password", "123");
		sp.setPara(ctx, "LocalRomDir", "/data/data/com.test/files/");
		sp.setPara(ctx, "LocalDir", ".GetRestore");
		sp.setPara(ctx, "LocalFileName", "synccontent.php");
		//sp.setPara(ctx, "ServerDir", "user01");//服务器里的文件夹在创建用户时创建，其它时候不可创建
		sp.setPara(ctx, "ServerFileName", "synccontent.php");
		//sp.setPara(ctx, "SyncFileUrl", "http://"+gp.getPara(ctx, "Ipaddr")+":"+gp.getPara(ctx, "ServerPort")+"/"+gp.getPara(ctx, "ServerDir"));
		sp.setPara(ctx, "Interval", 1*1000);//软件更新时间间隔，毫秒为单位
		sp.setPara(ctx, "SysInterval", 1*60*60*1000);
		sp.setPara(ctx, "PicDir", "DCIM/Camera");
		//sp.setPara(ctx, "PicDir",Environment.getExternalStorageDirectory()+"/dcim/Camera");//相册的默认存储目录
		
		
	}
	
	public void setAddr(Context ctx)
	{
		sp.setPara(ctx, "Ipaddr", Ipaddr);
		sp.setPara(ctx, "ServerPort", ServerPort);
	}
	
}
