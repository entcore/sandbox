function Book(){

}

Book.prototype.toJSON = function(){
	return {
		content: this.content,
		title: this.title
	}
};

Book.prototype.create = function(){
	http().postJson('/sandbox/book', this).done(function(){
		//La liste est resynchronisée afin de garder le contenu à jour
		model.books.sync();
	});
};

Book.prototype.saveModifications = function(){
	http().putJson('/sandbox/book/' + this._id, this);
};

Book.prototype.save = function(){
	if(!this._id){
		this.create();
	}
	else{
		this.saveModifications();
	}
};

Book.prototype.remove = function(){
	http().delete('/sandbox/book/' + this._id).done(function(){
		model.books.sync();
	});
};

model.build = function(){
	this.makeModels([Book]);
	this.collection(Book, {
		sync: '/sandbox/book/list/all'
	});
};