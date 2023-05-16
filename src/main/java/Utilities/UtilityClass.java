package Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilityClass {

	public static String getUniqueEmail() {
		String email = "abcdef" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDD_HHMMSS"))
				+ "@gmail.com";
		return email;

	}
}
