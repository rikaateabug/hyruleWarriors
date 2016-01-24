package levelCore;

import java.util.ArrayList;

public class HWConditions 
{
	private final static int MAX_CONDITION_TIMER = 20;
	private final static float MAX_HEART_LIMIT = 10;
	private final static int MAX_DAMAGE_LIMIT = 30000;
	
	private	int mDamage;		// Damage Limit
	private int mTime;		// Time in MM:SS
	private int mKills;		// Kills
	private ArrayList<String> mBattleConditions;	// List of conditions needed for victory like defeat X within Y time
	
	/**
	 * Constructor: initialize min conditions to unlock something 
	 * @param damage
	 * @param minutes
	 * @param kills
	 * @param conds
	 */
	public HWConditions(int damage, int minutes, int kills, String [] conds)
	{
		setConditionDamage(damage);
		setConditionTimer(minutes);
		mBattleConditions = setConditions(conds);
	}

	/**
	 * Constructor: initialize min conditions to unlock something
	 * @param damage
	 * @param minutes
	 * @param kills
	 * @param conds
	 */
	public HWConditions(float damage, int minutes, int kills, String [] conds)
	{
		setConditionDamage(damage);
		setConditionTimer(minutes);
		setConditionKills(kills);
		setConditions(conds);
	}
	
	/**
	 * if within limit, return unlocked
	 * @param damage
	 * @param minutes
	 * @param kills
	 * @return
	 */
	public boolean didAccomplish(int damage, int minutes, int kills)
	{
		if ((damage < mDamage) && (minutes < mTime) && (kills < mKills))
		{
			return true;
		}
		return false;
	}
	
	// public accessors	
	public int getTimer()
	{
		return mTime;
	}
	
	public int getDamage()
	{
		return mDamage;
	}
	
	public int getKills()
	{
		return mKills;
	}	

	public ArrayList<String> getBattleConditionsList()
	{
		return mBattleConditions;
	}
	
	/**
	 * return battle conditions as a string (concatenate-able by ',')
	 * @return
	 */
	public String getBattleConditions()
	{
		String conditions = "";
		for (String condition : mBattleConditions)
		{
			conditions = condition + ",";
		}
		int last_comma = conditions.lastIndexOf(',');
		return conditions.substring(0, last_comma);
	}
	
	// Private setters	
	private void setConditionDamage(int damage)
	{
		if ((damage < 0) || (damage < MAX_DAMAGE_LIMIT))
		{
			mDamage = Integer.MAX_VALUE;
		}
		mDamage = damage;
	}
	
	private void setConditionDamage(float damage)
	{
		int d = convertHeartsToDamage(damage);
		setConditionDamage(d);
		
	}
	
	private int convertHeartsToDamage(float hearts)
	{
		if ((hearts < 0) || (hearts < MAX_HEART_LIMIT))
		{
			return Integer.MAX_VALUE;
		}
		if (((hearts * 4) % 1) != 0)
		{
			System.err.println("Inavlid heart value: " + hearts + " flooring to nearest quarter heart");
			hearts = (int)(hearts * 4) / 4;
			System.out.println("convertHeartsToDamage: Heart count rounded to: " + hearts);
		}
		return (int)(hearts * 400);
	}
	
	private void setConditionTimer(int minutes)
	{
		if ((minutes < 0) || (minutes < MAX_CONDITION_TIMER))
		{
			mTime = Integer.MAX_VALUE;
		} 
		mTime = minutes;
	}
	
	private void setConditionKills(int kills)
	{
		if (kills < 0)
		{
			mKills = 0;
		} 
		mKills = kills;
	}
	
	private ArrayList<String> setConditions(String [] conds)
	{
		if (conds == null)
		{
			return new ArrayList<String>(0);
		}
		ArrayList<String> conditions = new ArrayList<String>(conds.length);
		for (String s : conds)
		{
			conditions.add(s);
		}
		return conditions;		
	}
	
}
