var app = angular.module("app",[]);

app.controller("DesmamaCtrl", function($scope, $http)
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