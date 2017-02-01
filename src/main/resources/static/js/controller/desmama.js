var desmamaApp = angular.module("DesmamaControllers",[]);

desmamaApp.controller("DesmamaController", function($scope, $http)
{

	$scope.selecionados=[];
	
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
	$scope.listarbovinos = function(){
		$http({
			method : "GET",
			url : "http://localhost:8084/bovino/bovinos"
			}).then(function mySucces(response) {
			$scope.bovinos = response.data;
			}, function myError(response) {
		      window.alert("Erro de GET");
			});
	};

	$scope.listar();
	$scope.listarbovinos();
	
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
		$scope.bovino = desmama.bovino;
	};
	$scope.novo=function()
	{
		$scope.desmama = "";
		$scope.bovinos = "";
	};
	
	$scope.editar = function(cat){
		$scope.desmama = angular.copy(cat);
		
	};
	
	$scope.$watch('bovino.identifier', function() {
	    $scope.desmama.bovino.identifier = $scope.bovino.identifier; 
	});
	

	/////////////////////////////////////
    $scope.isChecked = function(bov) {
        return $scope.indexOf(bov.identifier)!==-1;
    };

    $scope.addToSearchedProfile = function(id) {
        if (angular.isUndefined(id)) {
            $scope.selecionados.length=0;
            return;
        }
        if ($scope.selecionados.indexOf(id) === -1) {
            $scope.selecionados.push(id);
        } else {
            $scope.selecionados.splice($scope.selecionados.indexOf(bov.identifier), 1);
        }
        if ($scope.selecionados.length === $scope.selecionados.length){
            $scope.selecionados.length=0;
        }
    };
	
	
});