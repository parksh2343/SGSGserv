package cama.dto;

public class CamaDto {
	private String name;
	private String age;
	private String personId;
	
	public CamaDto() {
		
	}
	
	public CamaDto(String name, String age, String personId) {
		super();
		this.name = name;
		this.age = age;
		this.personId = personId;
	}
	
	
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getPersonId() {
		return personId;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
}
