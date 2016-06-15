package edu.hzuapps.androidworks.homeworks.net1314080903124;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import android.os.Environment;
import android.util.Log;

public class Net1314080903124_SaveDB {
	private static String urlNull = "ԭ�ļ�·��������";
	 private static String isFile = "ԭ�ļ������ļ�";
	 private static String canRead = "ԭ�ļ����ܶ�";
	 //private static String notWrite = "�����ļ�����д��";
	 private static String message = "���ݳɹ�";
	 private static String cFromFile = "����ԭ�ļ�����:";
	 private static String ctoFile = "���������ļ�����:";
	 //���ݿ�ԭ�ļ���ַ
	 private static String fromFileUrl="/data/data/edu.hzuapps.androidworks.homeworks.net1314080903124/databases/account.db";
	 //���ݿⱸ�ݵ�ַ
	 private static String toFileUrl="";
	 /**
	  * 
	 
	  * @return ���ر����ļ�����Ϣ��ok�ǳɹ����������Ǵ���
	  */
	 public static String Save( ) {
	  File fromFile = null;
	  File toFile = null;
	  
	  
	  if (Environment.getExternalStorageState().equals((Environment.MEDIA_MOUNTED))){
          File sdCardDir=Environment.getExternalStorageDirectory();
          toFileUrl=sdCardDir.getPath()+"//Zachay-";
      }else{
    	  return "û��sd��";
      }
	  //��ȡԴ�ļ�
	  try {
		  fromFile = new File(fromFileUrl);
	  } catch (Exception e) {
		  return cFromFile + e.getMessage();
	  }
	  //���������ļ�
	  try {
	   toFile = new File(getToFileUrl());
	  } catch (Exception e) {
	   return ctoFile + e.getMessage();
	  }

	  if (!fromFile.exists()) {
	   return urlNull;
	  }
	  if (!fromFile.isFile()) {
	    return isFile;
	  }
	  if (!fromFile.canRead()) {
	    return canRead;
	  }

	  // ���Ƶ���·����������ھʹ���
	  if (!toFile.getParentFile().exists()) {
	   toFile.getParentFile().mkdirs();
	  }
	         //�Ѵ��ھ�ɾ��
	  if (toFile.exists()) {
	   toFile.delete();
	  }
	         //����д��
	  if (!toFile.canWrite()) {
	   // return notWrite;
	  }
	  try {
	   java.io.FileInputStream fosfrom = new java.io.FileInputStream(
	     fromFile);
	   java.io.FileOutputStream fosto = new FileOutputStream(toFile);
	   byte bt[] = new byte[1024];
	   int c;

	   while ((c = fosfrom.read(bt)) > 0) {
	    fosto.write(bt, 0, c); // ������д�����ļ�����
	   }

	   fosfrom.close();
	   fosto.close();

	  } catch (Exception e) {
		  Log.i("Zachay",e.getMessage());  
		  message = "����ʧ��!"+e.toString();
	  }
	  return message;

	 }
	 
	 
	 
	 
	 /**
	  * 
	  * @return��ñ������ݿ��µ�ַ
	  */
	 private static String getToFileUrl(){  
	  StringBuffer sb=new StringBuffer(); 
	        sb.append(toFileUrl); 
	        sb.append(getTime());    
	        sb.append(".db");    
	        return sb.toString();  
	 }
	 
	  /**
	  * 
	  * @return ��ȡ��ǰʱ�� 2012-08-2213:56:02
	  */
	 private static String getTime() {
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String nowTime = sdf.format(new java.util.Date());   
	  return nowTime.replaceAll(" ","");
	 }

}
