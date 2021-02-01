package COM.IES.BINDING;

import lombok.Data;


@Data
public class PlanData {

	private Integer caseNumber;
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private Integer benfitAmount;
	private String denialReason;
}
