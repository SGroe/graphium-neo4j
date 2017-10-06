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
package at.srfg.graphium.mapmatching.online;

import at.srfg.graphium.mapmatching.model.IMatchedWaySegment;

/**
 * @author mwimmer
 *
 */
public class MatchedSegmentCounter {
	
	private IMatchedWaySegment segment;
	private int count = 1;
	
	public MatchedSegmentCounter(IMatchedWaySegment segment) {
		super();
		this.segment = segment;
	}

	public MatchedSegmentCounter(IMatchedWaySegment segment, int count) {
		super();
		this.segment = segment;
		this.count = count;
	}

	public void incrementCounter() {
		count++;
	}

	public IMatchedWaySegment getSegment() {
		return segment;
	}

	public int getCount() {
		return count;
	}
	
}
