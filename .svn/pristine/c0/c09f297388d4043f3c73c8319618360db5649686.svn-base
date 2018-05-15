package com.yllt.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class EncodingTool {
	/**
	 * 中文转换成utf-8
	 * @param str
	 * @return
	 */
	public static String encodeStr(String str) {  
        try {  
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    } 
	
	
	/*
	 * 文件编码转换
	 * srcFileName：原文件
	 * destFileName：输出后的文件
	 * crccode:原文件编码
	 * destcode：输出文件编码
	 */
	public static void transferFile(File srcFileName, File destFileName,String crccode,String destcode) throws IOException {
		  String line_separator = System.getProperty("line.separator"); 
		  FileInputStream fis = new FileInputStream(srcFileName);
		  StringBuffer content = new StringBuffer();
		  DataInputStream in = new DataInputStream(fis);
		  BufferedReader d = new BufferedReader(new InputStreamReader(in, crccode));  
		  String line = null;
		  while ((line = d.readLine()) != null)
		   content.append(line + line_separator);
		  d.close();
		  in.close();
		  fis.close();
		      
		  Writer ow = new OutputStreamWriter(new FileOutputStream(destFileName), destcode);
		  ow.write(content.toString());
		  ow.close();
	}
}
