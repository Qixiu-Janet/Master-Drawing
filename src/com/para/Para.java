package com.para;

//����Ϊ�����õ��Ĳ���
public class Para {
	
	public String getIpaddr1()
	{
		return "192.168.1.102";
	}
	
	public int getPort1()
	{
		return 21;
	}
	
	public String getUsername1()
	{
		return "gg";
	}
	
	public String getPassword1()
	{
		return "123456";
	}
	
	public String getLocalDir1()
	{
		return "GetRestore";
	}
	
	public String getLocalFileName1()
	{
		return "synccontent.php";
	}
	
	//����������ļ����ڴ����û�ʱ����������ʱ�򲻿ɴ���
	public String getServerDir1()
	{
		return "user01";
	}
	
	public String getServerFileName1()
	{
		return "synccontent.php";
	}

	//JSO��ȡhttp����
	public String getSyncFileUrl1(String filename)
	{
		//return "http://"+getIpaddr()+":8887/"+filename;
		return null;
	}
	
	//����ʱ����������Ϊ��λ
	public int getInterval1()
	{
		return 1000;
	}
	
	

		
	

}
