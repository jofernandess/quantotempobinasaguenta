/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bet.football.mybetleague.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bet.football.mybetleague.data.BetRepository;
import org.bet.football.mybetleague.model.Betlist;
import org.bet.football.mybetleague.service.user.UserManagement;
import org.bet.football.mybetleague.util.Security;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the users
 * table.
 */
@Path("/bets")
@RequestScoped
@Stateful
public class BetService {

	@Inject
	private Logger log;

	@Inject
	private Validator validator;

	@Inject
	private BetRepository repository;

	@Inject
	UserManagement userManagement;

	@Inject
	Security security;

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Betlist> listAllBetNames() {
//		return repository.findAllOrderedByName();
//	}

//	@GET
//	@Path("/{id:[0-9][0-9]*}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public User lookupUserById(@PathParam("id") long id) {
//		User user = repository.findById(id);
//		if (user == null) {
//			throw new WebApplicationException(Response.Status.NOT_FOUND);
//		}
//		return user;
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public User lookupUserByEmail( String email) {
//		User user = null;
//		try {
//
//			user = repository.findByEmail(email);
//
//		} catch (Exception e) {
//			throw new WebApplicationException(Response.Status.NOT_FOUND);
//		}
//
//		return user;
//	}
//
//	/**
//	 * Creates a new user from the values provided. Performs validation, and
//	 * will return a JAX-RS response with either 200 ok, or with a map of
//	 * fields, and related errors.
//	 */
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createUser(User user) {
//
//		Response.ResponseBuilder builder = null;
//
//		try {
//
//			populateUser(user);
//			// Validates user using bean validation
//			validateUser(user);
//
//			userManagement.register(user);
//
//			// Create an "ok" response
//			builder = Response.ok().entity(user);
//		} catch (ConstraintViolationException ce) {
//			// Handle bean validation issues
//			builder = createViolationResponse(ce.getConstraintViolations());
//		} catch (ValidationException e) {
//			// Handle the unique constrain violation
//			Map<String, String> responseObj = new HashMap<>();
//			responseObj.put(EMAIL, "Email taken");
//			builder = Response.status(Response.Status.CONFLICT).entity(
//					responseObj);
//		} catch (Exception e) {
//			// Handle generic exceptions
//			Map<String, String> responseObj = new HashMap<>();
//			responseObj.put("error", e.getMessage());
//			builder = Response.status(Response.Status.BAD_REQUEST).entity(
//					responseObj);
//		}
//
//		return builder.build();
//	}
//
//	private User populateUser(User user) {
//		final boolean status = Boolean.TRUE;
//		user.setCreateDate(DateTime.now());
//		user.setRole(Role.user);
//		user.setSalt(security.nextSessionId());
//		user.setPassword(security.MD5Security(user.getToken() + user.getSalt()));
//		user.setToken(security.MD5Security(user.getToken() + user.getSalt()));
//		user.setStatus(status);
//		return user;
//	}
//
//	/**
//	 * <p>
//	 * Validates the given User variable and throws validation exceptions based
//	 * on the type of error. If the error is standard bean validation errors
//	 * then it will throw a ConstraintValidationException with the set of the
//	 * constraints violated.
//	 * </p>
//	 * <p>
//	 * If the error is caused because an existing user with the same email is
//	 * registered it throws a regular validation exception so that it can be
//	 * interpreted separately.
//	 * </p>
//	 * 
//	 * @param user
//	 *            User to be validated
//	 * @throws ConstraintViolationException
//	 *             If Bean Validation errors exist
//	 * @throws ValidationException
//	 *             If user with the same email already exists
//	 */
//	private void validateUser(User user) throws ConstraintViolationException,
//			ValidationException {
//		// Create a bean validator and check for issues.
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//
//		if (!violations.isEmpty()) {
//			throw new ConstraintViolationException(
//					new HashSet<ConstraintViolation<?>>(violations));
//		}
//
//		// Check the uniqueness of the email address
//		if (emailAlreadyExists(user.getEmail())) {
//			throw new ValidationException("Unique Email Violation");
//		}
//	}
//
//	/**
//	 * Creates a JAX-RS "Bad Request" response including a map of all violation
//	 * fields, and their message. This can then be used by clients to show
//	 * violations.
//	 * 
//	 * @param violations
//	 *            A set of violations that needs to be reported
//	 * @return JAX-RS response containing all violations
//	 */
//	private Response.ResponseBuilder createViolationResponse(
//			Set<ConstraintViolation<?>> violations) {
//		log.fine("Validation completed. violations found: " + violations.size());
//
//		Map<String, String> responseObj = new HashMap<>();
//
//		for (ConstraintViolation<?> violation : violations) {
//			responseObj.put(violation.getPropertyPath().toString(),
//					violation.getMessage());
//		}
//
//		return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
//	}
//
//	/**
//	 * Checks if a user with the same email address is already registered. This
//	 * is the only way to easily capture the
//	 * "@UniqueConstraint(columnNames = "email")" constraint from the User
//	 * class.
//	 * 
//	 * @param email
//	 *            The email to check
//	 * @return True if the email already exists, and false otherwise
//	 */
//	private boolean emailAlreadyExists(String email) {
//		User user = null;
//		try {
//			user = repository.findByEmail(email);
//		} catch (NoResultException e) {
//
//		}
//		return user != null;
//	}
}
