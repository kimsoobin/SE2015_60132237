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
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;

	@RequestMapping(value = "/UserController/dataInsert", method = RequestMethod.POST)
	public String dataInsert(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		User user = new User();
		user.setID((String) request.getParameter("id"));
		user.setPassword((String) request.getParameter("pw"));
		user.setName((String) request.getParameter("name"));
		user.setPos((String) request.getParameter("pos")); 
		service.insertData(user);
		
		System.out.println("회원가입완료");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/UserController/createAccount", method = RequestMethod.GET)
	public String regist(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		return "createAccount";
	}
}
