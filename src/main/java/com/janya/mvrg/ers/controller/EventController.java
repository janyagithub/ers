package com.janya.mvrg.ers.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.janya.mvrg.ers.dao.MasterEventRepository;
import com.janya.mvrg.ers.dto.ResultListDto;
import com.janya.mvrg.ers.enitity.MasterEventEntity;
import com.janya.mvrg.ers.service.EventActivityService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventActivityService eventActivityService;

	@Autowired
	private MasterEventRepository masterEventRepository;

	// Link 7 link 2
	@GetMapping("/result/{eventId}")
	@ResponseBody
	public ResultListDto showSignUpForm(@PathVariable("eventId") Long eventId, Pageable pageable) {

		return eventActivityService.getResultEvent(eventId, pageable);
	}

	// Dash Board marquee
	@GetMapping("/latest-events/{records}")
	@ResponseBody
	public List<MasterEventEntity> upComingEvents(@PathVariable("records") int records) {

		return masterEventRepository.getUpComingEvents(PageRequest.of(0, records)).getContent();
	}

	// Dash Board corrosal
	@GetMapping("/last-events/{records}")
	@ResponseBody
	public List<MasterEventEntity> lastEvents(Pageable pageable) {

		return masterEventRepository.getLastEvents(pageable, new Date()).getContent();

	}

}
