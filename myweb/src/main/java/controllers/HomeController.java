package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.MyBean;

@Controller
@Scope("request")
public class HomeController{
	private MyBean myBean;

	@Autowired
	public void setMyBean(MyBean mb){
		myBean = mb;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		System.out.println("MyBean hashcode=" + myBean.hashCode());
		return "home";
	}
}
