package COM.IES.SERVICE;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.springframework.stereotype.Service;

import COM.IES.BINDING.CitizenData;
import COM.IES.BINDING.PlanData;

@Service
public interface CheckEligibilityService {

	public PlanData checkCitizenPlanStatus(CitizenData cData) throws DroolsParserException,IOException;
}
