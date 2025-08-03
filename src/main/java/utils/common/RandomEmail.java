package utils.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomEmail {

	public static String generateRandomEmail() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String randomPart = chars.charAt((int) (Math.random() * 26)) + chars.charAt((int) (Math.random() * 26))
				+ String.valueOf((int) (Math.random() * 1000));
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return "test_" + randomPart + "_" + timestamp + "@mailinator.com";
	}

}
