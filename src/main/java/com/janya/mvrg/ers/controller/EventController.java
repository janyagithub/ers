package com.janya.mvrg.ers.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.janya.mvrg.ers.dao.EventActivityRepository;
import com.janya.mvrg.ers.dao.MasterCollegeRepository;
import com.janya.mvrg.ers.dao.MasterEventRepository;
import com.janya.mvrg.ers.dao.StudentRegistrationRepository;
import com.janya.mvrg.ers.dto.ResultListDto;
import com.janya.mvrg.ers.enitity.EventActivityEntity;
import com.janya.mvrg.ers.enitity.MasterCollegeEntity;
import com.janya.mvrg.ers.enitity.MasterEventEntity;
import com.janya.mvrg.ers.enitity.StudentRegistrationEntity;
import com.janya.mvrg.ers.service.EventActivityService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventActivityService eventActivityService;

	@Autowired
	private EventActivityRepository eventActivityRepo;

	@Autowired
	private MasterEventRepository masterEventRepository;
	
	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;

	// Link 7 link 2
	@Autowired
	private MasterCollegeRepository masterCollegeRepository;
	
	// Link 7
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

	@PutMapping("/result-entry") // Link 5
	public String addStudentRegistration(@Valid List<EventActivityEntity> eventDataWithResultList, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "add-student";
		}

		eventActivityRepo.saveAll(eventDataWithResultList);

		return "redirect:list";
	}

	@GetMapping("/fetchEvent/{id}")
	public String fetchEvent(@PathVariable("id") long id, Model model) {
		Optional<MasterEventEntity> event = masterEventRepository.findById(id);
		if (event.isPresent())
			model.addAttribute("event", event.get());
		return "event-page";
	}
	
	@GetMapping("/listCollegeDetail/{records}/{clg_id}")
	@ResponseBody
	public List<StudentRegistrationEntity> getCollegeStudentEventDetail(@PathVariable("records") int records,@PathVariable("clg_id") long clg_id){
		return studentRegistrationRepository.listCollegeStudentRegDetail(PageRequest.of(0, records), clg_id).getContent();
	}
	
	@GetMapping("/colleges")
	@ResponseBody
	public Collection<MasterCollegeEntity> listColleges() {
		return masterCollegeRepository.findAll();
	}
}
