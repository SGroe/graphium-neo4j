/**
 * Graphium Neo4j - Map Matching module of Graphium
 * Copyright © 2017 Salzburg Research Forschungsgesellschaft (graphium@salzburgresearch.at)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package at.srfg.graphium.mapmatching.model;

import java.util.Comparator;

public interface IWeightingStrategy {
	
	public abstract double calculateMatchedFactor(IMatchedBranch branch);
	public abstract Comparator<IMatchedBranch> getComparator();
	
	public abstract boolean branchIsValid(IMatchedBranch branch);
	public abstract boolean branchIsValid(IMatchedBranch branch, int lastPartsToCheck);
	
	/**
	 * Maximum value of matched factor for valid branches: 
	 * If the matched factor of a branch is greater than this value, the branch is invalid and is thrown away.
	 */
	public abstract double getMaxValidMatchedFactor();
	
}
