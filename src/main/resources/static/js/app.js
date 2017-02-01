var myApp = angular.module('myApp', [ 'ui.router','myApp.controllers']);

myApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/state0");
	//
	// Configurando os states/estados
	$urlRouterProvider.otherwise('/home0');

	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'paginas/partial-home.html'
	})

	.state('about', {
		url : '/about',
		templateUrl : 'paginas/partial-about.html'
	})

	.state('desmamas', {
		url : '/desmamas',
		templateUrl : 'paginas/partial-desmamas.html',
		controller : "DesmamaController"
	})
	.state('bovinos', {
		url : '/bovinos',
		templateUrl : 'paginas/partial-bovinos.html',
		controller : "BovinoController"
	})
		.state('lote-menu', {
		url : '/lotes',
		templateUrl : 'paginas/partial-lote-menu.html',
		controller : "LoteMenuController"
	})
			.state('lote-cadastro', {
		url : '/lotecadastro',
		templateUrl : 'paginas/partial-lote-cadastro.html',
		controller : "LoteCadastroController"
	})
});
