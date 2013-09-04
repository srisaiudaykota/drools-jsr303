package net.eusashead.validation.form;

import java.util.Date;

import net.eusashead.validation.annotation.BusinessRulesConstraint;

@BusinessRulesConstraint
public class ApplicationForm {

	private Integer applicantId;

	private Date date;
	
	public ApplicationForm(Integer applicantId, Date date) {
		super();
		this.applicantId = applicantId;
		this.date = date;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
