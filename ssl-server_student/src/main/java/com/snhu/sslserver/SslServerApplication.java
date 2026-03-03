package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@RestController
class ServerController{
	public static String bytesToHex(byte[] bytes) {
	    StringBuilder sb = new StringBuilder();
	    for (byte b : bytes) {
	        sb.append(String.format("%02x", b));
	    }
	    return sb.toString();
	}

	
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException {
    	String data = "Jesus Rodriguez-Luna!";
    	
    	MessageDigest digest = MessageDigest.getInstance("SHA-256");
    	
    	byte[] hashBytes = digest.digest(data.getBytes());
    	
    	String hexHash = bytesToHex(hashBytes);
       
        return "<p>data:" + data + "</p>" +"<p>SHA-256: Checksum Value: " + hexHash + "</p>";
    }
}