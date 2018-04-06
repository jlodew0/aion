package ai.instance.beshmundirTemple;

import ai.AggressiveNpcAI2;
import com.aionemu.gameserver.ai2.AIName;

/**
 * @author Kairyu
 *
 */
@AIName("sorcererhakiki")
public class SorcererHakiki extends AggressiveNpcAI2 {
  
	@Override
	public int modifyDamage(int damage)	{
		return 2;
	}

}
