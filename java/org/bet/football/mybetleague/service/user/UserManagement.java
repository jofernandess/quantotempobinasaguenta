
package org.bet.football.mybetleague.service.user;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bet.football.mybetleague.model.User;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class UserManagement {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<User> userEventSrc;

	public void register(User user) throws Exception {
		log.info("Registering " + user.getUsername());
		em.persist(user);
		userEventSrc.fire(user);
	}

}
