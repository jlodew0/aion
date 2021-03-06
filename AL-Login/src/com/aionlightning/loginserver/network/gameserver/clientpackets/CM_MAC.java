/**
 * This file is part of aion-lightning <aion-lightning.org>.
 * 
 * aion-lightning is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * aion-lightning is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with aion-lightning.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionlightning.loginserver.network.gameserver.clientpackets;

import org.slf4j.LoggerFactory;

import com.aionlightning.loginserver.controller.AccountController;
import com.aionlightning.loginserver.network.gameserver.GsClientPacket;

/**
 * 
 * @author nrg
 *
 */
public class CM_MAC extends GsClientPacket {

	private int accountId;
	private String address;
	
	@Override
	protected void readImpl() {
		accountId = readD();
		address = readS();
	}
	
	@Override
	protected void runImpl() {
		if(!AccountController.refreshAccountsLastMac(accountId, address))
				LoggerFactory.getLogger(CM_MAC.class).error("[WARN] We just weren't able to update account_data.last_mac for accountId "+accountId);
	}
}
