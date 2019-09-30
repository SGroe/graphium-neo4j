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
package at.srfg.graphium.mapmatching.util;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import at.srfg.graphium.mapmatching.model.IMatchedBranch;

/**
 * Created by mwimmer
 */
public class MapMatchingUtil {

	public static List<IMatchedBranch> filterEmptyBranches(List<IMatchedBranch> branches) {
		// filter empty paths
		return Lists.newArrayList(Collections2.filter(branches, new Predicate<IMatchedBranch>() {
			public boolean apply(IMatchedBranch branch) {
				return !branch.getMatchedWaySegments().isEmpty();
			}
		}));

	}

}
