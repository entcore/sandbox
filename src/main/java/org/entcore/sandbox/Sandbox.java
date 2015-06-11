package org.entcore.sandbox;

import fr.wseduc.rs.ApiPrefixDoc;
import org.entcore.common.http.BaseServer;
import org.entcore.sandbox.controllers.SandboxController;

@ApiPrefixDoc
public class Sandbox extends BaseServer {

	@Override
	public void start() {
		super.start();
		addController(new SandboxController());
	}

}
