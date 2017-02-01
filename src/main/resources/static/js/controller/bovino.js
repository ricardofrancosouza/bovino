var bovinoApp = angular.module("BovinoControllers",[]);

bovinoApp.controller("BovinoController", function($scope, $http)
{

	$scope.data = {};

	
	$scope.data.cb1 = true;
	$scope.listar = function(){
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
	
	$scope.salvar = function(){

		if(!$scope.bovino.identifier)
			{
				
			  //  $http.post("http://localhost:8084/bovino/statusbovinos/", $scope.bovino.statusbovino)
				
			    $http.post("http://localhost:8084/bovino/bovinos/", $scope.bovino)
				
				.then(function(response){
		        $scope.listar();
		        $scope.novo();
				},function (response){
					 window.alert("Erro de POST");
				});
			    
			}
		else
			{
			   $http.put("http://localhost:8084/bovino/bovinos/"+$scope.bovino.identifier, $scope.bovino)
			   $http.put("http://localhost:8084/bovino/statusbovinos/"+$scope.bovino.statusbovino.identifier , $scope.bovino.statusbovino)
			   .then(function(response){
				   $scope.listar();
				   $scope.novo();
			   }, function (response){
				   window.alert("erro Put");
			   });
			}
	};
	$scope.apagar = function(bovino)
	{
		/*if(window.confirm("tem certeza?"))
			{*/
			   $http.delete("http://localhost:8084/bovino/bovinos/"+$bovino.identifier)
			   .then(function(response){
				   $scope.listar();
				   $scope.novo();
			   }, function (response){
				   window.alert("erro Delete");
			   });
			//}		
	};
	
		
	$scope.selecionar = function(bovino)
	{
		$scope.bovino = angular.copy(bovino);
	
	};
	$scope.novo=function()
	{
		$scope.bovino = "";
		//$scope.peso ="";
		
	};
	
	$scope.editar = function(cat){
		$scope.bovino = angular.copy(cat);
		
	};
	
////////////////////////////////////////
	///////////////////////// pesos
	      $scope.salvarPeso = function(){
//	    	  if($scope.bovino.identifier)
//	    	  {
//                $scope.peso.bovino.identifier = 1;
//				$http.post("http://localhost:8084/bovino/pesos/", $scope.peso)
//				.then(function(response){
//		      				},function (response){
//					 window.alert("Erro de POST");
//				}
	    	   // $socpe.bovino.pesos.dtPesagem =  $filter('date')(data, 'dd/MM/yyyy')
	    	    
	    	    
	    	  $scope.peso.bovinos = $scope.bovino;
	    	  $http.post("http://localhost:8084/bovino/pesos/", $scope.peso)
			 			  
	    	  //$http.post("http://localhost:8084/bovino/statusbovinos/", $scope.bovino.statusbovino)
				.then(function(response){
		       //  $scope.listar();
		      //  $scope.novo();
				},function (response){
					 window.alert("Erro de POST");
				});
	    	  
				$scope.bovino.pesos.push(angular.copy( $scope.peso));
				
				$scope.pesos ="";
	    	  } ; 
			
			
			$scope.novoPeso=function()
			{
				$scope.pesos = "";
				
			};
		
			
	

	
});