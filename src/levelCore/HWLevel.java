package levelCore;

import java.util.ArrayList;
import java.util.HashMap;

public class HWLevel
{
	
	public enum CardinalDir
	{
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	
	private String mLevelName;
	private Rank mRank = Rank.R_BRONZE;				// User rank on this level
	private ItemCard mCard = ItemCard.C_NO_ITEM;	// Item card gained on this level
	private boolean mLocked = false;				// Can player play this level yet?
	
	HashMap<CardinalDir, HWUnlockableCondition<HWLevel>> mNeighbors;	// Places you can go from this one
	ArrayList<HWUnlockableCondition<Treasure>> mTreasures;	// Treasures you can unlock
	
	/**
	 * Constructor: Used to create a general level.
	 * 	Levels are aware of their unlockables, requirements to unlock
	 * 	as well as rank acquired, and locked status 
	 * @param name: Name of the level 
	 * @param r: rank the user has on that level
	 * @param c: Item Card gained on that level 
	 */
	HWLevel(String name, Rank r, ItemCard c)
	{
		mLevelName = name;
		mRank = r;
		mCard = c;
		
		createNeighbors();
	}
	
	/**
	 * updateLevel rank, also unlock rewards
	 * @param r: Rank achieved
	 */
	public void updateLevelRanking(Rank r)
	{
		mRank = r;
		for (HWUnlockableCondition<Treasure> t : mTreasures)
		{
			if (t.didObtain(r))
			{
				t.unlock();
			}
		}
	}
	
	/**
	 * createNeighbors: Initialize all neighbors to null
	 */
	private void createNeighbors()
	{
		mNeighbors = new HashMap<CardinalDir, HWUnlockableCondition<HWLevel>>(4);
		for (CardinalDir d : CardinalDir.values())
		{
			mNeighbors.put(d, null);
		}
	}
	
	// Mutators
	
	/**
	 * addNeighbor: Add a neighbor to this level. Unlocks it if necessary. This fails if Java
	 * 	does not pass objects by reference
	 * @param h
	 * @param r
	 * @param dir
	 */
	public void addNeighbor(HWLevel h, Rank r, CardinalDir dir)
	{
		HWUnlockableCondition<HWLevel> condition = new HWUnlockableCondition<HWLevel>(h, r);
		if (condition.didObtain(r))
		{
			condition.getUnlockable().unlockLevel();
		}
		mNeighbors.put(dir, condition);
	}

	/**
	 * unlock the level if conditions are met
	 */
	public void unlockLevel()
	{
		mLocked = false;
	}

	/**
	 * adds a ranked condition to this level
	 * @param t: Treasure to be unlocked
	 * @param conditions: conditions to unlock
	 */
	public void addRankCondition(Treasure t, HWConditions conditions)
	{
		HWUnlockableCondition<Treasure> cond = 
					new HWUnlockableCondition<Treasure>(t, conditions);
		mTreasures.add(cond);
	}

	/**
	 * Add a tanked condition to this level
	 * @param r: rank needed to unlock this treasure
	 * @param t: treasure unlocked
	 */
	public void addRankCondition(Rank r, Treasure t)
	{
		HWUnlockableCondition<Treasure> cond = 
					new HWUnlockableCondition<Treasure>(t, r);
		mTreasures.add(cond);
	}

}
