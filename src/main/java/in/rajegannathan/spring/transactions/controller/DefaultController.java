package in.rajegannathan.spring.transactions.controller;

import in.rajegannathan.spring.transactions.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/default.atg")
	public @ResponseBody String handleDefaultRequest(HttpServletRequest request, HttpServletResponse response){
		int count = userDAO.getCountOfUsers();
		return "hai "+ count;
	}
}