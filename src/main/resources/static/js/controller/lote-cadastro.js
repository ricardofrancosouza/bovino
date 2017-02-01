var lotecadastroApp = angular.module("LoteCadastroControllers",[]);

lotecadastroApp.controller("LoteCadastroController", function($scope, $http)
{
	
	
	
	$scope.selecionados = [];
	$scope.listar = function(){
		$http({
			method : "GET",
			url : "http://localhost:8084/bovino/bovinos/semlotes"
			}).then(function mySucces(response) {
			$scope.bovinos = response.data;
			}, function myError(response) {
		      window.alert("Erro de GET");
			});
	};
	

	$scope.listar();
	
	
	$scope.salvar = function(){

		if(!$scope.lote.identifier)
			{
				
			  //  $http.post("http://localhost:8084/bovino/statusbovinos/", $scope.bovino.statusbovino)
				
			    $http.post("http://localhost:8084/bovino/lotes/", $scope.lote)
				
				.then(function(response){
				},function (response){
					 window.alert("Erro de POST");
				});
			    
			}

	};
	
	
	$scope.selecionar = function(bovino)
	{
		
		$scope.bovino = angular.copy(bovino);
	
	};
	
	$scope.novobovino = function(){
  	    
  	  			$scope.bovino ="";
  	  } ; 
  	  
   	$scope.adicionarbovino = function(){
   		$scope.selecionados.push(angular.copy($scope.bovino));
   		$scope.apagarselecionado();
   		delete $scope.bovino;
		$scope.novobovino();
	};	
	
	$scope.apagarselecionado = function()
	{
		var tam = $scope.bovinos.length;
		for(var i = 0; i < tam; i++) {
			
			$scope.aux = $scope.bovinos[i];
		    if ($scope.aux.identifier === $scope.bovino.identifier) {
		       var  ind = i;
		       $scope.bovinos.splice(ind,1);
		       break;
		    }
		}
		
	};
		
		$scope.novobovino=function()
		{
			$scope.bovino = "";
			
		};
	
});