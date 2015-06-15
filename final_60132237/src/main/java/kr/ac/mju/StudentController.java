package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/StudentController/registPage", method = RequestMethod.GET)
	public String viewPage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		Vector<Gangjwa> gangjwaList = null;
		gangjwaList = service.printGangjwaList();
		
		request.setAttribute("gangjwaList", gangjwaList);
		return "registClass";
	}	
	
	@RequestMapping(value = "/StudentController/gradeview", method = RequestMethod.GET)
	public String gradeviewPage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		Vector<Regist> regist = null;
		regist = service.registList();
		
		request.setAttribute("regist", regist);
		return "gradeview_Student";
	}
	
	@RequestMapping(value = "/StudentController/regist", method = RequestMethod.POST)
	public String RegistForCourse(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		Regist regist = new Regist();
		Vector<Gangjwa> gangjwaList = null;
		
		String stuName = request.getParameter("stuname");
		String className = request.getParameter("classname");
		String classNo = request.getParameter("classnum");
		String proName = request.getParameter("proname");
		String year = request.getParameter("year");
		String grade = request.getParameter("grade");
		String credit = request.getParameter("credit");
		String max = request.getParameter("max");
		
		regist.setStudentname(stuName);
		regist.setClassname(className);
		regist.setNo(classNo);
		regist.setProname(proName);
		regist.setYear(year);
		regist.setGrade(grade);
		regist.setCredit(credit);
		regist.setMax(max);
		
		service.registGangjwa(regist);
		
		gangjwaList = service.printGangjwaList();
		request.setAttribute("gangjwaList", gangjwaList);
		request.setAttribute("regist", regist);
		
		return "registClass";
	}
	
}
