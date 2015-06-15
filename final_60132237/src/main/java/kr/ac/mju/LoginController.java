package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		//LoginInfo 
		User user = null;
		try {
			user = service.login(userID, userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		logger.info(userID+" login");
		if(user == null){
			System.out.println("등록되지 않은 사용자입니다.");
			return "redirect:/";
		}else{
			request.getSession().setAttribute("user", user);
			
			if(user.getPos().equals("prof")) {
				return "gyosu";
			} else if(user.getPos().equals("stu")) {
				return "haksaeng";
			}
			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/create", method = RequestMethod.POST)
	public String create(HttpServletRequest request){
		try {
			service.create();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/drop", method = RequestMethod.POST)
	public String drop(HttpServletRequest request){
		try {
			service.drop();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/loginController/createAccount", method = RequestMethod.GET)
	public String createAccount(HttpServletRequest request){
		
		return "createAccount";
	}
}
