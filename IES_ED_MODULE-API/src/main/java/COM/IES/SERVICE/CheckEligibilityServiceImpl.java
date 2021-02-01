package COM.IES.SERVICE;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.stereotype.Service;

import COM.IES.BINDING.CitizenData;
import COM.IES.BINDING.PlanData;



@Service
public class CheckEligibilityServiceImpl implements CheckEligibilityService{

	public PlanData checkCitizenPlanStatus(CitizenData cData) throws DroolsParserException, IOException
	{
	
		
		PlanData planData= new PlanData();
		planData.setPlanName(cData.getPlanName());
		planData.setCaseNumber(cData.getCaseNumber());

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/" + cData.getPlanName() + ".drl";
		System.out.println(ruleFile);
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();

		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		workingMemory.insert(cData);
		workingMemory.insert(planData);
		workingMemory.fireAllRules();
		return planData;
		
	}
}
