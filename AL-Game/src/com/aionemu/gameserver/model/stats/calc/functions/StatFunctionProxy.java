/*
 * This file is part of aion-lightning <aion-lightning.com>.
 *
 *  aion-lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-lightning.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.model.stats.calc.functions;

import com.aionemu.gameserver.model.stats.calc.Stat2;
import com.aionemu.gameserver.model.stats.calc.StatOwner;
import com.aionemu.gameserver.model.stats.container.StatEnum;

/**
 * @author ATracer
 */
public class StatFunctionProxy implements IStatFunction, Comparable<IStatFunction> {

	private final StatOwner owner;
	private final IStatFunction proxiedFunction;
	private final StatEnum stat;

	public StatFunctionProxy(StatOwner owner, IStatFunction statFunction) {
		this.owner = owner;
		this.proxiedFunction = statFunction;
		this.stat = statFunction.getName();
	}

	public StatFunctionProxy(StatOwner owner, IStatFunction statFunction, StatEnum statEnum) {
		this.owner = owner;
		this.proxiedFunction = statFunction;
		this.stat = statEnum;
	}

	public IStatFunction getProxiedFunction() {
		return proxiedFunction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatFunctionProxy other = (StatFunctionProxy) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		}
		else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public int compareTo(IStatFunction o) {
		return proxiedFunction.compareTo(o);
	}

	@Override
	public StatOwner getOwner() {
		return owner;
	}

	@Override
	public StatEnum getName() {
		return stat;
	}

	@Override
	public boolean isBonus() {
		return proxiedFunction.isBonus();
	}

	@Override
	public int getPriority() {
		return proxiedFunction.getPriority();
	}

	@Override
	public int getValue() {
		return proxiedFunction.getValue();
	}

	@Override
	public boolean validate(Stat2 stat, IStatFunction statFunction) {
		return proxiedFunction.validate(stat, statFunction);
	}

	@Override
	public void apply(Stat2 stat) {
		proxiedFunction.apply(stat);
	}

	@Override
	public String toString() {
		return "Proxy [name=" + proxiedFunction.getName() + ", bonus=" + isBonus() + ", value=" + getValue()
			+ ", priority=" + getPriority() + ", owner=" + owner + "]";
	}
}
