package COM.IES.BINDING;


import lombok.Data;


@Data
public class CitizenData {
	private Integer caseNumber;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String planName;
	private Integer income;
	private Integer kidsCount;
	private Boolean isEmployed;
	private Boolean isGraduate;
}
