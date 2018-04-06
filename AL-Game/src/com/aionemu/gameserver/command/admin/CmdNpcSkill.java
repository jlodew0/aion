package com.aionemu.gameserver.command.admin;

import com.aionemu.gameserver.command.BaseCommand;
import com.aionemu.gameserver.dataholders.DataManager;
import com.aionemu.gameserver.model.gameobjects.Npc;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.templates.npcskill.NpcSkillTemplate;
import com.aionemu.gameserver.utils.PacketSendUtility;

import java.util.List;


public class CmdNpcSkill extends BaseCommand {
	
	

	public void execute(Player admin, String... params) {
		Npc target = NpcTarget(admin);

		if (target == null) {
			PacketSendUtility.sendMessage(admin, "You should select a valid target first!");
			return;
		}

		StringBuilder strbld = new StringBuilder("-list of skills:\n");

		List<NpcSkillTemplate> list = DataManager.NPC_SKILL_DATA.getNpcSkillList(target.getNpcId()).getNpcSkills();

		for (NpcSkillTemplate skill : list)
			strbld.append("    level " + skill.getSkillLevel() + " of " + skill.getSkillid() + ".\n");
		showAllLines(admin, strbld.toString());
	}

	private void showAllLines(Player admin, String str) {
		int index = 0;
		String[] strarray = str.split("\n");

		while (index < strarray.length - 20) {
			StringBuilder strbld = new StringBuilder();
			for (int i = 0; i < 20; i++, index++) {
				strbld.append(strarray[index]);
				if (i < 20 - 1)
					strbld.append("\n");
			}
			PacketSendUtility.sendMessage(admin, strbld.toString());
		}
		int odd = strarray.length - index;
		StringBuilder strbld = new StringBuilder();
		for (int i = 0; i < odd; i++, index++)
			strbld.append(strarray[index] + "\n");
		PacketSendUtility.sendMessage(admin, strbld.toString());
	}
}

