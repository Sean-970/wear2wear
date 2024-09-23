package tw.Final.FinalS1.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import tw.Final.FinalS1.dto.RegisterRequest;
import tw.Final.FinalS1.model.UserModel;

public interface UserService {
	
	public ResponseEntity<Map<String, Object>> registerUser(RegisterRequest request);
		
	public ResponseEntity<Map<String, Object>> loginUser(RegisterRequest request, HttpServletRequest servletRequest);
	
	public ResponseEntity<Map<String, Object>> logincheck(String account);
	
	public void googleUser(OAuth2User oAuth2User);
	
	public ResponseEntity<Map<String, String>> sessionResponse(HttpSession session);
		
}
