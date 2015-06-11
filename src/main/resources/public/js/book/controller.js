routes.define(function($routeProvider){
	$routeProvider
		.when('/view/:bookId', {
			action: 'viewBook'
		})
		.when('/list', {
			action: 'openList'
		})
		.otherwise({
			redirectTo: '/list'
		})
});

function BookController(date, model, $scope, route){
	route({
		viewBook: function(params){
			template.open('main', 'view-book');
			$scope.book = model.books.findWhere({ _id: params.bookId })
		},
		openList: function(params){
			template.open('main', 'display-books');
		}
	});

	$scope.newBook = function(){
		var book = new Book();
		book.title = "Titre du livre";
		book.content = "Mon contenu";
		book.save();
	};

	$scope.books = model.books;
}