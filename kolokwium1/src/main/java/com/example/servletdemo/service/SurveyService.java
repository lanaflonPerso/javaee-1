package com.example.servletdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletdemo.domain.Survey;

public class SurveyService {
	private List<Survey> db = new ArrayList<Survey>();
	
	public void addSurvey(Survey survey) {
		Survey newSurvey = new Survey(survey.getId(), survey.getFrom(), survey.getTo(), survey.getFrequency(), survey.getComments());
		db.add(newSurvey);
	}
	
	public List<Survey> getAllSurveys() {
		return db;
	}
	
	public void removeSurvey(Survey survey) {
		db.remove(survey);
	}
}
