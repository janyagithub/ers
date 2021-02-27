package com.janya.mvrg.ers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.janya.mvrg.ers.dto.ResultListDto;
import com.janya.mvrg.ers.service.EventActivityService;

@Controller
@RequestMapping("/event/")
public class EventController {

	@Autowired
	private EventActivityService eventActivityService;

	//Link 7
	@GetMapping("/result/{eventId}")
	@ResponseBody
	public ResultListDto showSignUpForm(@PathVariable("eventId") Long eventId) {

		ResultListDto resultEvent = eventActivityService.getResultEvent(eventId);
		System.out.println("Size of the results " + resultEvent.getEventActivityDto().size());
		return resultEvent;
	}

}
