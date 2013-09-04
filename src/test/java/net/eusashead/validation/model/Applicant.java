package net.eusashead.validation.model;

public class Applicant {
	
	private Integer id;
	 
    private String name;
 
    private int age;
 
    private boolean valid;
    
	public Applicant(Integer id, String name, int age) {
		super();
		this.setId(id);
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
 
}