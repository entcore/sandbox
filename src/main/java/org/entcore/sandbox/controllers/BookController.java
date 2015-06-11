package org.entcore.sandbox.controllers;

import fr.wseduc.rs.*;
import fr.wseduc.security.SecuredAction;
import org.entcore.common.mongodb.MongoDbControllerHelper;
import org.vertx.java.core.http.HttpServerRequest;
import fr.wseduc.security.ActionType;
import fr.wseduc.security.SecuredAction;

public class BookController extends MongoDbControllerHelper {

	public BookController() {
		super("book");
	}

	@Get("book")
	@SecuredAction("sandbox.book.access")
	public void index(HttpServerRequest request) {
		renderView(request); // View must have the same name than the last element in URL path
	}

	@Get("book/list/:filter")
	@SecuredAction("sandbox.books.list")
	public void list(HttpServerRequest request) {
		super.list(request);
	}

	@Post("book")
	@SecuredAction("sandbox.book.add")
	public void add(HttpServerRequest request) {
		create(request);
	}

	@Put("book/:id")
	@SecuredAction(value = "book.contrib", type = ActionType.RESOURCE)
	public void update(HttpServerRequest request) {
		super.update(request);
	}
}
