package org.entcore.sandbox.controllers;

import fr.wseduc.rs.Get;
import fr.wseduc.security.SecuredAction;
import org.entcore.common.controller.ControllerHelper;
import org.vertx.java.core.http.HttpServerRequest;

public class SandboxController extends ControllerHelper {

	public SandboxController() {
		super();
	}

	@Get("")
	@SecuredAction("sandbox.access")
	public void index(HttpServerRequest request) {
		renderView(request); // View must have the same name than the last element in URL path
	}

}
