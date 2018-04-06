package com.aionemu.gameserver.dao;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.commons.database.dao.DAO;

public abstract class PlayerRankDAO implements DAO{

	@Override
	public final String getClassName() {
		return PlayerRankDAO.class.getName();
	}

	public abstract void loadCustomRank(Player player);
	public abstract void storeCustomRank(Player player);
	public abstract void insertCustomRank(Player player);
}
