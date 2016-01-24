package levelCore;

public class HWUnlockableCondition<Unlockable> 
{
	private HWConditions mConditions;
	private Unlockable mGain;
	private Rank mRank;
	private boolean mUnlocked = false;

	/**
	 * Constructor: Do not care about damage, time, or kills
	 * @param g: Unlockable feature
	 * @param r: Rank needed to unlock
	 */
	public HWUnlockableCondition(Unlockable g, Rank r)
	{
		mConditions = new HWConditions(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
		mRank = r;
		mGain = g;
	}

	/**
	 * Constructor: Do not care about rank, just the conditions
	 * @param g: Unlockable feature
	 * @param r: Rank needed to unlock
	 * @param conditions: Conditions needed to unlock
	 */
	public HWUnlockableCondition(Unlockable g, HWConditions conditions)
	{
		mGain = g;
		mConditions = conditions;
		mRank = Rank.R_NO_RANK;
	}
	
	/**
	 * didObtain: check if reward can be unlocked given achieved rank
	 * @param r: Rank achieved
	 * @return true if unlocked, false if rank insufficient
	 */
	public boolean didObtain(Rank r)
	{
		if (mRank.order(mRank) <= r.order(r))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * check if reward can be unlocked given achieved set
	 * @param damage
	 * @param minutes
	 * @param kills
	 * @return true if unlocked, false if rank insufficient
	 */
	public boolean didObtain(int damage, int minutes, int kills)
	{
		if (mConditions.didAccomplish(damage, minutes, kills))
		{
			return true;
		}
		return false;
	}

	// Public accessors	
	public boolean isUnLocked()
	{
		return mUnlocked;
	}
	
	public Unlockable getUnlockable()
	{
		return mGain;
	}
	
	public Rank getUnlockableRank()
	{
		return mRank;
	}
	
	// public mutators	
	public void relock()
	{
		mUnlocked = false;
	}

	public void unlock()
	{
		mUnlocked = true;
	}
}
