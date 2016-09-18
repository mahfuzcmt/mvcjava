package edu.vub.ns.webcore.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.vub.ns.webcore.bean.SmsResponseBean;

public class SmsSender {
	
	public static void main(String[] args){
		String res = sendSms();
		System.out.println(res);
		SmsResponseBean result = (SmsResponseBean) GsonUtil.parseObject(res, SmsResponseBean.class);
		System.out.println(result.getStatus());
	}
	public static String sendSms() {
		try {
			// Construct data
			String user = "username=" + "mahfuz.ahmed@spectrum-bd.com";
			String hash = "&hash=" + "09cba9215e103e302184395009118b130ff31906";
			String message = "&message=" + "This is test message";
			String sender = "&sender=" + "VUB";
			String numbers = "&numbers=" + "+8801";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.txtlocal.com/send/?").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
