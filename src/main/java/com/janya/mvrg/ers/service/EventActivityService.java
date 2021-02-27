package com.janya.mvrg.ers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janya.mvrg.ers.dao.EventActivityRepository;
import com.janya.mvrg.ers.dto.EventActivityDto;
import com.janya.mvrg.ers.dto.ResultListDto;

@Service
public class EventActivityService {

	@Autowired
	private EventActivityRepository eventActivityRepo;

	public ResultListDto getResultEvent(Long eventId) {

		List<Object[]> results = eventActivityRepo.getEventResultByEventId(eventId);

		if (results.isEmpty())
			return null;

		ResultListDto result = new ResultListDto();
		List<EventActivityDto> activityResultList = new ArrayList<>();

		results.forEach(one -> {

			result.setEventName(null == one[0] ? null : (String) one[0].toString());
			result.setConductedBy(null == one[1] ? null : (String) one[1].toString());
			result.setLocation(null == one[2] ? null : (String) one[2].toString());

			EventActivityDto activity = new EventActivityDto();
			activity.setActivityName(null == one[3] ? null : (String) one[3].toString());
			activity.setWinner(null == one[4] ? null : (String) one[4].toString());
			activity.setRunner(null == one[5] ? null : (String) one[5].toString());

			activityResultList.add(activity);

		});

		result.setEventActivityDto(activityResultList);

		return result;

	}
}
