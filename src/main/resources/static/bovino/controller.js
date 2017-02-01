var app = angular.module("app",[]);

app.controller("BovinoCtrl", function($scope, $http)
{

	$scope.listar = function(){

		$http({

			method : "GET",

			url : "http://localhost:8080/bovino/bovinos"

			}).then(function mySucces(response) {

			$scope.bovinos = response.data;

			}, function myError(response) {

		      window.alert("Erro de GET");

			});
		
		
	}
	
	
	

	$scope.listar();
	
	$scope.salvar = function(){
/*		var bovino = $scope.getbovinoById($scope.bovino.codigo);
		if (bovino == null)
		{
			$scope.bovinos.push($scope.bovino);
		}
		else
			{
			  var indice = $scope.bovinos.indexOf(bovino);
			  $scope.bovinos.splice(indice,1,$scope.bovino);
			}
		
		$scope.bovino = angular.copy($scope.bovino);*/
		$http.post("http://localhost:8080/bovino/bovinos/"+$scope.bovino)
		.then(function(response){
	        $scope.listar();
	        $scope.novo();
			},function (response){
				 window.alert("Erro de POST");
			});
		
	};
	$scope.apagar = function()
	{
		if(window.confirm("tem certeza?"))
			{
				var ind = $scope.bovinos.indexOf($scope.bovino);
				$scope.bovinos.splice(ind,1);
			}
		
		
	};
	
	$scope.getbovinoById = function (codigo)
	{
		for (i = 0 ; i < $scope.bovinos.length ; i++)
			{
			  if ( $scope.bovinos[i].codigo === codigo)
				  {
				    return $scope.bovinos[i];
				  }
			}
		return null;
	};
	
	$scope.selecionar = function( bovino)
	{
		$scope.bovino = angular.copy(bovino);
		
		
		
	};
	$scope.novo=function()
	{
		$scope.bovino = "";
	};
	
});