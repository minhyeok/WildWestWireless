package pe.lee.wildwestwireless;

/**
 * 이 클래스는 가입자(Account)의 요금 계산을 수행하는 유틸 클래스이다.
 * see {@link Account}
 * @author 이민혁
 * @version 1.0.0
 * */
public class CalculateFareUtility {
	/**
	 * TODO 계산 전략을 수립하자.
	 * Property 1. 단순 폰빌 계산
	 * Gold/silver 에 따라 요금을 달리한다, 본인외 추가 회선비용이 있다.
	 * Gold : 49.95 + 14.50;
	 * Silver : 29.95 + 21.50;
	 * 
	 * Property 2. 초과요금
	 * Gold : 기본시간 1000분, 초과 분당 0.45
	 * Silver : 기본시간 500분, 초과 분당 0.54
	 * 
	 * Property 3. 가족 할인
	 * 본인 포함 4인 이상이면 4인 째부터 5딸라만 부과 
	 * 엄밀히 말하면 한 계정당 부과하는 것이다.
	 * 
	 * 그리고 실제로 CalcUtility
	 * 그런데... 인원이 많은데도 그냥 기본시간은 그대로 가져간다니
	 * */
	
	public static final double FARE_BASIC_GOLD = 49.95d;
	public static final double FARE_BASIC_SILVER = 29.95d;
	
	public static final double FARE_OPTIONAL_GOLD = 14.50d;
	public static final double FARE_OPTIONAL_SILVER = 21.50d;
	
	public static final double FARE_EXCEED_GOLD = 0.45d;
	public static final double FARE_EXCEED_SILVER = 0.54d;
	
	public static final int LIMIT_EXCEED_GOLD = 1000;
	public static final int LIMIT_EXCEED_SILVER = 500;
	
	public static final double FARE_ABOVE_FOUR = 5.0d;
	
	public static Double calcBasicFare(Account.Plan plan){
		if(plan == Account.Plan.GOLD){
			return FARE_BASIC_GOLD;
		}
		return FARE_BASIC_SILVER;
	}
	public static Double calcExceedFare(Account.Plan plan, int usage){
		double ratio;
		int usageLimit;
		int exceedUsage;
		if(plan == Account.Plan.GOLD){
			ratio = FARE_EXCEED_GOLD;
			usageLimit = LIMIT_EXCEED_GOLD;
		}else{
			ratio = FARE_EXCEED_SILVER;
			usageLimit = LIMIT_EXCEED_SILVER;
		}
		if(usage > usageLimit){
			exceedUsage = usage - usageLimit;
		}else{
			exceedUsage = 0;
		}
		return ratio * exceedUsage;
	}
	
	public static Double calcFamilyFare(Account.Plan plan, int lines){
		double opt;
		if(plan == Account.Plan.GOLD){
			opt = FARE_OPTIONAL_GOLD;
		}else{
			opt = FARE_OPTIONAL_SILVER;
		}
		lines--;
		if(lines < 1){
			return 0.0d;
		}
		if(lines < 3){
			return lines * opt;
		}
		return 2 * opt + (lines - 2) * 5.0d;
	}
}
