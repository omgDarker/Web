package cn.wegoteam.shop.util;

import org.apache.commons.codec.binary.Base64;

public class ZfmBase64 {
	public static String encode(String code)
	{
		if(code==null)
			return null;
		return new String(new Base64().encode(code.getBytes()));
	}
	public static String encode(byte[] code)
	{
		if(code==null)
			return null;
		return new String(new Base64().encode(code));
	}
	
	public static String decode(String code)
	{
		if(code==null)
			return null;
		return new String(new Base64().decode(code.getBytes()));
	}
	public static String  unescape (String src)
	{
	 StringBuffer tmp = new StringBuffer();
	 if(src==null)
		 return null;
	 tmp.ensureCapacity(src.length());
	 int  lastPos=0,pos=0;
	 char ch;
	 while (lastPos<src.length())
	 {
	  pos = src.indexOf("%",lastPos);
	  if (pos == lastPos)
	   {
	   if (src.charAt(pos+1)=='u')
	    {
	    ch = (char)Integer.parseInt(src.substring(pos+2,pos+6),16);
	    tmp.append(ch);
	    lastPos = pos+6;
	    }
	   else
	    {
	    ch = (char)Integer.parseInt(src.substring(pos+1,pos+3),16);
	    tmp.append(ch);
	    lastPos = pos+3;
	    }
	   }
	  else
	   {
	   if (pos == -1)
	    {
	    tmp.append(src.substring(lastPos));
	    lastPos=src.length();
	    }
	   else
	    {
	    tmp.append(src.substring(lastPos,pos));
	    lastPos=pos;
	    }
	   }
	 }
	 return tmp.toString();
	}
}
