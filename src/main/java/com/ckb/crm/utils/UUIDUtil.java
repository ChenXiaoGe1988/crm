package com.ckb.crm.utils;

import java.util.UUID;

/**
 * @author ychen
 */
public class UUIDUtil {
	
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replaceAll("-","");
		
	}
	
}
