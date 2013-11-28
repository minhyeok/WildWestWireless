package pe.lee.wildwestwireless;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AccountUtilTest {
	
	@Before
	public void setUp() throws Exception{
	}
	
	@Test
	public void AccountBasic(){
		double result = CalculateFareUtility.calcBasicFare(Account.Plan.SILVER);
		assertEquals(29.95d, result, 0.1d);
	}
	
	@Test
	public void ExcessOverGold(){
		double result = CalculateFareUtility.calcExceedFare(Account.Plan.GOLD, 1123);
		assertEquals(123*0.45d, result, 0.1d);
	}
	
	@Test
	public void ExcessUnderGold(){
		double result = CalculateFareUtility.calcExceedFare(Account.Plan.GOLD, 494);
		assertEquals(0, result, 0.1d);
	}
	
	@Test
	public void ExcessOverSilver(){
		double result = CalculateFareUtility.calcExceedFare(Account.Plan.SILVER, 723);
		assertEquals(223*0.54d, result, 0.1d);
	}
	
	@Test
	public void ExcessUnderSilver(){
		double result = CalculateFareUtility.calcExceedFare(Account.Plan.GOLD, 0);
		assertEquals(0, result, 0.1d);
	}
	
	@Test
	public void FamilyOverGold(){
		double result = CalculateFareUtility.calcFamilyFare(Account.Plan.GOLD, 6);
		assertEquals(15.0d + 2*14.50d, result, 0.1d);
	}
	
	@Test
	public void FamilyUnderGold(){
		double result = CalculateFareUtility.calcFamilyFare(Account.Plan.GOLD, 3);
		assertEquals(2*14.50d, result, 0.1d);
	}
	
	@Test
	public void FamilyOverSilver(){
		double result = CalculateFareUtility.calcFamilyFare(Account.Plan.SILVER, 7);
		assertEquals(20.0d + 2*21.50d, result, 0.1d);
	}
	
	@Test
	public void FamilyUnderSilver(){
		double result = CalculateFareUtility.calcFamilyFare(Account.Plan.SILVER, 3);
		assertEquals(2*21.50d, result, 0.1d);
	}
}
