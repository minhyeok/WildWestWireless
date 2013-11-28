package pe.lee.wildwestwireless;
/**
 * 이 클래스는 각 개인 가입자를 구현한 클래스이다. 
 * */
public class Account {
	/**이 Enum은 가입자의 요금제를 구분할 것이다.*/
	public enum Plan{
		GOLD,
		SILVER
	};
	/**가입자가 어떤 요금제를 가입했는가를 나타낸다.*/
	private Plan mPlan;
	/**요금을 의미함.*/
	private Double mFare = null;
	/**가입자 수를 의미함.*/
	private int iLines;
	/**사용시간을 의미함.*/
	private int iUsage;
	/**생성자이다. 파라미터는 추후에.*/
	public Account(Plan plan, int lines, int usage) {
		this.mPlan = plan;
		this.iLines = lines;
		this.iUsage = usage;
	}

	public void setFare(Double fare){
		this.mFare = fare;
	}
	public Double getFare(){
		return mFare;
	}
	public int getLines(){
		return iLines;
	}
	public int getUsageTime(){
		return iUsage;
	}
	public Plan getPlan(){
		return mPlan;
	}
	
}
