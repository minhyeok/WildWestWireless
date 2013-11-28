package pe.lee.wildwestwireless;

import java.util.ArrayList;

/**
 * 이것은 가입자(클래스 Account)를 관리하는 클래스이다.
 * {@link Account}
 * */
public final class AccountManager {
/**
 * TODO 계정 관리 전략 수립
 * */
	/**내부 인스턴스 레퍼런스.*/
	private static AccountManager Instance;
	/**
	 * 가입자 생성 리스트.
	 * */
	private ArrayList<Account> mAccountList = new ArrayList<Account>();
	/**요금계산이 완료된 가입자 리스트.*/
	private ArrayList<Account> mCalculatedList = new ArrayList<Account>();
	/**생성자. no special.*/
	private AccountManager() {
	}
	/**
	 * 고유 인스턴스를 얻어온다.
	 * @return AccountManager instance.
	 * */
	public AccountManager getInsatance() {
		if (Instance == null) {
			Instance = new AccountManager();
		}
		return Instance;
	}
	/**
	 * 계산할 가입자를 추가한다.
	 * @param account 추가할 가입자.
	 * */
	public void enqueueList(Account account) {
		mAccountList.add(account);
	}
	/**
	 * 계산할 가입자를 추가한다.
	 * @param accountList ArrayList 형태의 추가할 가입자의 묶음.
	 * */
	public void enqueueAllList(ArrayList<Account> accountList) {
		mAccountList.addAll(accountList);
	}
	/**
	 * 계산할 가입자 한명을 반환한다.
	 * @return 리스트 최 우측 Element.
	 * */
	public Account dequeueList(){
		return mAccountList.remove(0);
	}
	/**
	 * 실질적 계산을 수행한다.
	 * */
	public void executeCalc(){
		Account account = dequeueList();
		double fare;
		if (account != null) {
			fare = CalculateFareUtility.
					calcBasicFare(account.getPlan());
			fare += CalculateFareUtility.
					calcExceedFare(account.getPlan(),
					account.getUsageTime());
			fare += CalculateFareUtility.
					calcFamilyFare(account.getPlan(),
					account.getLines());
			account.setFare(fare);
		}
		mCalculatedList.add(account);
	}
}
