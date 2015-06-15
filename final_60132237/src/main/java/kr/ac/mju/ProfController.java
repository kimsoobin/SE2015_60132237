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
public class ProfController {
	
	@Autowired
	private ProfService service;
	
	@RequestMapping(value = "/ProfController/createClass", method = RequestMethod.POST)
	public String openclass(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		Gangjwa gangjwa = new Gangjwa();
		
		gangjwa.setId((String) request.getParameter("id"));
		gangjwa.setProf_name((String) request.getParameter("prof_name"));
		gangjwa.setName((String) request.getParameter("name"));
		gangjwa.setYear((String) request.getParameter("year"));
		gangjwa.setGrade((String) request.getParameter("grade"));
		gangjwa.setMax((String) request.getParameter("max"));
		gangjwa.setCredit((String) request.getParameter("credit"));
		
		service.createClass(gangjwa);
		
		return "gyosu";
	}
	
	@RequestMapping(value = "/ProfController/createClassPage", method = RequestMethod.GET)
	public String viewclasspage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		return "createClass";
	}
	
	@RequestMapping(value = "/ProController/gradegrant", method = RequestMethod.GET)
	public String gradegrant(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("no");
		Vector<Regist> registList = null;
		
		registList = service.grantGrade(no);
		request.setAttribute("registList", registList);
		return "gradeview_professor";
	}
	
	@RequestMapping(value = "/ProController/grantgrade", method = RequestMethod.GET)
	public String grantGrade(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");

		String stuname = request.getParameter("name");
		String classname = request.getParameter("classname");
		String grade = request.getParameter("classgrade");
		
		Regist regist = new Regist();
		regist.setClassGrade(grade);
		regist.setStudentname(stuname);
		regist.setClassname(classname);
		
		service.Grade(regist);
		
		return "gyosu";
	}
	
	@RequestMapping(value = "/ProController/gradegrantpage", method = RequestMethod.GET)
	public String viewgradepage(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		Vector<Gangjwa> gangjwaList = null;
		gangjwaList = service.List();
		request.setAttribute("gangjwaList", gangjwaList);
		return "gradegrant_Professor";
	}
}
