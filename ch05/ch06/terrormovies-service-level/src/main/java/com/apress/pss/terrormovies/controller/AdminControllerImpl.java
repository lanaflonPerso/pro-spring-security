package com.apress.pss.terrormovies.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apress.pss.terrormovies.model.User;

@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController{

	@RequestMapping(method = RequestMethod.POST, value = "/movies")
	@ResponseBody
	@Secured("ROLE_ADMIN")
	public String createMovie(@RequestBody String movie) {
		System.out.println("Adding movie!! "+movie);
		return "created";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/movies")
	@ResponseBody
	@Secured("ROLE_ADMIN")
	public String createMovie() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("returned movie!");
		return "User "+user.getLastname()+" is accessing movie x";
	}
}
