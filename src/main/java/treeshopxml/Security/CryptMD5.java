package treeshopxml.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Repository;
@Repository
public class CryptMD5 {
	public String hashMd5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] bit = md.digest();
			String rs = DatatypeConverter.printHexBinary(bit).toUpperCase();
			return rs;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
