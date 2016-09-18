package edu.vub.ns.webcore.manager.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import edu.vub.ns.webcore.manager.IdGenerator;



public class IdGeneratorImpl implements IdGenerator {
	
	protected static final int NUM_CHARS = 15;
    protected static String chars = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    protected static Random r = new Random();
    protected static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
    
	@Override
	public synchronized String generateId() {
		Date today = new Date();      
        String todayAsString = df.format(today);
        return todayAsString + "-" + getRandomWord();
    }

    protected synchronized String getRandomWord() {
        char[] buf = new char[NUM_CHARS];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = chars.charAt(r.nextInt(chars.length()));
        }
        return new String(buf);
    }
	
	@Override
	public synchronized String getSessionId() {
		return UUID.randomUUID().toString();
	}
	
	
	
}




