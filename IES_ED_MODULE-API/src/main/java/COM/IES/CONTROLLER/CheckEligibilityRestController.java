package COM.IES.CONTROLLER;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import COM.IES.BINDING.CitizenData;
import COM.IES.BINDING.PlanData;
import COM.IES.SERVICE.CheckEligibilityService;

@RestController
public class CheckEligibilityRestController {

	@Autowired
	CheckEligibilityService checkService;
	
	@PostMapping(value="/checkEligibility",consumes="application/json" )
	public ResponseEntity<Object> checkPlanEligibility(@RequestBody CitizenData cData)throws DroolsParserException, IOException
	{
		PlanData planData=null;
		planData= checkService.checkCitizenPlanStatus(cData);
		if(planData.getPlanStatus().equalsIgnoreCase("Approved"))
		{
			return ResponseEntity.ok(planData);
		}else {
			return ResponseEntity.badRequest().body(planData);
		}
		
	}
}
