var myApp = angular.module('myApp', [ 'ui.router' ]);

myApp.config(function($stateProvider, $urlRouterProvider) {
	//
	// Para alguma URL não configurada, redirect para /state1
	$urlRouterProvider.otherwise("/state0");
	//
	// Configurando os states/estados
	$stateProvider.state('state1', {
		url : "/state1",
		templateUrl : "paginas/state1.html"
	}).state('state1.list', {
		url : "/list",
		templateUrl : "paginas/state1.list.html",
		controller : function($scope) {
			$scope.items = [ "A", "List", "Of", "Items" ];
		}
	}).state('state2', {
		url : "/state2",
		templateUrl : "paginas/state2.html"
	}).state('state2.list', {
		url : "/list",
		templateUrl : "paginas/state2.list.html",
		controller : function($scope) {
			$scope.things = [ "A", "Set", "Of", "Things" ];
		}
	})
});
