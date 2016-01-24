package levelCore;

enum Treasure
{
	T_HEART_PIECE,
	T_HEART_CONTAINER,
	T_SKULLTULA,
	T_WEAPON;	
	// Character? tied to
	// Hidden reward? Move to class object
}

enum Rank 
{
	R_GOLD,
	R_SILVER,
	R_BRONZE,
	R_NO_RANK;

	/** 
	 * TODO: Delete this if ordinal works
	 */
	public int order(Rank r)
	{
		switch(r)
		{
		case R_GOLD:
			return 0;
		case R_SILVER:
			return 1;
		case R_BRONZE:
			return 2;
		case R_NO_RANK:
			return 3;
		}
		return 0;
	}
}

enum ItemCard 
{
	C_COMPASS,
	C_BOMB,
	C_CANDLE,
	C_LADDER,
	C_POWER_BRACELET,
	C_WATER_BOMB,
	C_DIGGING_MITTS,
	C_ICE_ARROW,
	C_RAFT,
	C_HOOKSHOT,
	C_RECORDER,
	C_GODDESS_HARP,
	C_LANTERN,
	C_JAR,
	C_FISHING_ROD,
	C_CLAWSHOT,
	C_SPINNER,
	C_TEARS_OF_LIGHT,
	C_OOCCOO,
	C_TEARS_OF_TWILIGHT,
	C_DEKU_MASK,
	C_GORON_MASK,
	C_ZORA_MASK,
	C_MASK_OF_TRUTH,
	C_MAJORAS_MASK,
	C_DEKU_STICK,
	C_SONG_OF_TIME,
	C_INVERTED_SONG_OF_TIME,
	C_GIANT,
	C_WIND_WAKER,
	C_SALVAGE_ARM,
	C_SEA_CHART,
	C_CANNON,
	C_HEROS_BOW,
	C_BOOMERANG,
	C_HYOI_PEAR,
	C_POWER_BRACELETS,
	C_HAMMER,
	C_DEKU_LEAF,
	C_NO_ITEM;
}

