/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/
package lbms.plugins.mldht.kad.messages;

import java.util.Map;
import java.util.TreeMap;

import lbms.plugins.mldht.kad.DHT;

/**
 * @author Damokles
 *
 */
public class AnnounceResponse extends MessageBase {

	/**
	 * @param mtid
	 * @param id
	 */
	public AnnounceResponse (byte[] mtid) {
		super(mtid, Method.PRISM_ANNOUNCE_PEER, Type.RSP_MSG);
	}

	/* (non-Javadoc)
	 * @see lbms.plugins.mldht.kad.messages.MessageBase#apply(lbms.plugins.mldht.kad.DHT)
	 */
	@Override
	public void apply (DHT dh_table) {
		dh_table.response(this);
	}
	
	@Override
	public Map<String, Object> getInnerMap() {
		Map<String, Object> inner = new TreeMap<>();
		inner.put("id", id.getHash());

		return inner;
	}

}
