
package org.bet.binas.service.user;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bet.binas.model.Betlist;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class UserManagement {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Betlist> userEventSrc;

	public void register(Betlist betList) throws Exception {
		log.info("Registering " + betList.getBetname());
		em.persist(betList);
		userEventSrc.fire(betList);
	}

}
