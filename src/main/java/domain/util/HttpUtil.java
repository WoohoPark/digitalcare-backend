package domain.util;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {

	public static String getRequestURI( HttpServletRequest request) {
		
		return request.getRequestURI();
	}
}
