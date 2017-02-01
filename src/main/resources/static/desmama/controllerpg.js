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
myApp.controller("DesmamaCtrl", function($scope, $http)
		{

			$scope.listar = function(){
				$http({
					method : "GET",
					url : "http://localhost:8084/bovino/desmamas"
					}).then(function mySucces(response) {
					$scope.desmamas = response.data;
					}, function myError(response) {
				      window.alert("Erro de GET");
					});
			};
			

			$scope.listar();
			
			$scope.salvar = function(){

				if(!$scope.desmama.identifier)
					{
						$http.post("http://localhost:8084/bovino/desmamas/", $scope.desmama)
						.then(function(response){
				        $scope.listar();
				        $scope.novo();
						},function (response){
							 window.alert("Erro de POST");
						});
					}
				else
					{
					   $http.put("http://localhost:8084/bovino/desmamas/"+$scope.desmama.identifier, $scope.desmama)
					   .then(function(response){
						   $scope.listar();
						   $scope.novo();
					   }, function (response){
						   window.alert("erro Put");
					   });
					}
			};
			$scope.apagar = function(desmama)
			{
				/*if(window.confirm("tem certeza?"))
					{*/
					   $http.delete("http://localhost:8084/bovino/desmamas/"+desmama.identifier)
					   .then(function(response){
						   $scope.listar();
						   $scope.novo();
					   }, function (response){
						   window.alert("erro Delete");
					   });
					//}		
			};
			
				
			$scope.selecionar = function(desmama)
			{
				$scope.desmama = angular.copy(desmama);
			};
			$scope.novo=function()
			{
				$scope.desmama = "";
			};
			
			$scope.editar = function(cat){
				$scope.desmama = angular.copy(cat);
				
			};
			

			
		});
