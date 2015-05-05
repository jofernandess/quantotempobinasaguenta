function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1);
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

function checkCookie() {
	var user = getCookie("username");
	if (user != "") {
		alert("Welcome again " + user);
	} else {
		user = prompt("Please enter your name:", "");
		if (user != "" && user != null) {
			setCookie("username", user, 30);
		}
	}
}
/* Uses JAX-RS GET to retrieve current member list */
function updateMemberTable() {
	// Display the loader widget
	$.mobile.loading("show");

	$.ajax({
		url : "rest/users",
		cache : false,
		success : function(data) {
			$("#members").empty().append(buildMemberRows(data));
			$("#member-table").table("refresh");
		},
		error : function(error) {
			console.log("error updating table -" + error.status);
		},
		complete : function() {
			// Hide the loader widget
			$.mobile.loading("hide");
		}
	});
}
function processUser(email, data) {

	searchUser(email, data);
}

/*
 * Attempts to register a new member using a JAX-RS POST. The callbacks the
 * refresh the member table, or process JAX-RS response codes to update the
 * validation errors.
 */
function searchUser(email, data) {
	// Display the loader widget
	var dataObj = {
		"email" : email
	};
	$.mobile.loading("show");
	$.ajax({
		url : "rest/users/" + email,
		cache : true,
		data : dataObj,
		success : function(data) {
			console.log("User exists.....so go to welcome page");
			sendData(data);
		},
		error : function(error) {
			if (error.status == 404) {
				console.log("User with email! " + email + " doesn\'t exist!");
				console.log("User with email! " + email
						+ " will now be registered!");
				registerUser(data);
			} else {
				console.log("There was an error in the email search!");
			}

		},
		complete : function() {
			// Hide the loader widget
			$.mobile.loading("hide");
		}
	});
}
/*
 * Attempts to register a new member using a JAX-RS POST. The callbacks the
 * refresh the member table, or process JAX-RS response codes to update the
 * validation errors.
 */
function registerUser(userData) {

	// Display the loader widget
	$.mobile.loading("show");

	$.ajax({
		url : "rest/users",
		contentType : "application/json",
		dataType : "json",
		type : "POST",
		data : JSON.stringify(userData),
		success : function(data) {
			console.log("User registered");

		},
		error : function(error) {
			if ((error.status == 409) || (error.status == 400)) {
				console.log("Validation error registering user!");

				var errorMsg = $.parseJSON(error.responseText);

			} else {
				$.mobile.loading("hide");
				console.log("error - unknown server issue");
				//						
				var errorMsg = $.parseJSON(error.responseText);

			}
		},
		complete : function() {
			// Hide the loader widget
			$.mobile.loading("hide");
		}
	});
}

