package com.wlfei.mcn.util;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

public class NoteUtil {
	/**
	 * 利用U生成主键UID算法
	 * @return
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	/**
	 * 将传入的src加密处理
	 * @param src 明文字符串
	 * @return 加密后的字符串结果
	 * @throws Exception 
	 */
	public static String md5(String src) {
		//将字符串信息采用MD5处理
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] output = md.digest(src.getBytes());
			//将MD5处理结果利用Base64转成字符串
			//https://www.cnblogs.com/alter888/p/9140732.html
//			final Base64.Decoder decoder = Base64.getDecoder();
			final Base64.Encoder encoder = Base64.getEncoder();
			//编码
			String encodedText = encoder.encodeToString(output);
			return encodedText;
			
		} catch (Exception e) {
			throw new NoteException("密码加密失败", e);
		}		
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(md5("123456"));
		System.out.println(md5("1234567"));
		System.out.println(md5("12354654676dfdfdfdf"));
		System.out.println(createId());
		System.out.println(createId());
	}
	
}
