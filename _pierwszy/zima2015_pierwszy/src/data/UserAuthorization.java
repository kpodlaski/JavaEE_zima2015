package data;

import java.security.MessageDigest;
import java.util.HashMap;

import sun.misc.BASE64Encoder;


import model.User;


@SuppressWarnings("restriction")
public class UserAuthorization {

	private static HashMap<String,String> passwords = null;
	
	private static void createPasswords(){
		passwords = new HashMap<>();
		passwords.put("adam", "abc");
		passwords.put("ewa", "123");
	}
	
	public static boolean checkUser(User user){
		//SPRAWDè POPRAWNOå∆ HAS£A
		try{
		if (passwords == null) createPasswords();
		if (passwords.containsKey(user.getUsername())){
			String passwd = passwords.get(user.getUsername())+":"+user.getToken();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(passwd.getBytes());
			//convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<hash.length;i++) {
	    	  if (hash[i]<=9 && hash[i]>=0) hexString.append('0');
	    	  hexString.append(Integer.toHexString(0xFF & hash[i] + 0x100));
	    	}
			String shapass = hexString.toString();
			System.out.println(shapass);
			System.out.println(user.getPassword());
			BASE64Encoder encoder = new BASE64Encoder();
			System.out.println(encoder.encode(hash));
			return shapass.equals(user.getPassword());		
		}
		return false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static void main(String[] a){
		/*
		 * POST DATA
		 * token:token_value
		 * username:adam
		 * password:e53c0533b11dbd8f78e611b35366aabe0306f97b7c5b25498ef632c2a579e73e
		 */
		User u = new User();
		u.setUsername("adam");
		u.setPassword("e53c0533b11dbd8f78e611b35366aabe0306f97b7c5b25498ef632c2a579e73e");
		u.setToken("token_value");
		System.out.println(checkUser(u));
		
	}
}
