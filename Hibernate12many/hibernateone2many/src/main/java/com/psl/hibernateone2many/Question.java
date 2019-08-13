package com.psl.hibernateone2many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="questionId")
	@OrderColumn(name="type")
	private List<Answers> answerlist;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answers> getAnswerlist() {
		return answerlist;
	}

	public void setAnswerlist(List<Answers> answerlist) {
		this.answerlist = answerlist;
	}
	
	
	

}
