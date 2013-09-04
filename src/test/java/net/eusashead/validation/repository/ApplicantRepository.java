package net.eusashead.validation.repository;

import java.util.HashMap;
import java.util.Map;

import net.eusashead.validation.model.Applicant;

public class ApplicantRepository {
	
	private final Map<Integer, Applicant> applicants = new HashMap<Integer, Applicant>();
	  
    public ApplicantRepository() {
        Applicant app1 = new Applicant(1, "Mr John Smith", 16);
        applicants.put(app1.getId(), app1);
        Applicant app2 = new Applicant(2, "Mr Joe Bloggs", 21);
        applicants.put(app2.getId(), app2);
    }
  
    public Applicant findApplicant(Integer identifier) {
       return applicants.get(identifier);
    }

}
