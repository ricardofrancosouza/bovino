var lotemenuApp = angular.module("LoteMenuControllers",[]);

lotemenuApp.controller("LoteMenuController", function($scope, $http)
{


	$scope.listar = function(){
		$http({
			method : "GET",
			url : "http://localhost:8084/bovino/lotes"
			}).then(function mySucces(response) {
			$scope.bovinos = response.data;
			}, function myError(response) {
		      window.alert("Erro de GET");
			});
	};
	

	$scope.listar();
	
	$scope.selecionar = function(lote)
	{
		$scope.lote = angular.copy(lote);
	
	};
	
	
	$scope.apagar = function(bovino)
	{
		if(window.confirm("tem certeza?"))
			{
			   $http.delete("http://localhost:8084/bovino/lotes/"+$lote.identifier)
			   .then(function(response){
				   $scope.listar();
				
			   }, function (response){
				   window.alert("erro Delete");
			   });
			}		
	};
	
});