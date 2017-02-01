var app = angular.module("app",[]);

var init = function ($scope)
{
  $scope.numero1 = 0;
  $scope.numero2 = 0;
  $scope.count = 0;
  
  $scope.somar = function(){
	$scope.count =  $scope.numero1 + $scope.numero2;
  }
  $scope.multiplicar = function(){
	  $scope.count = $scope.numero1 * $scope.numero2;
  }
  $scope.dividir = function(){
	  $scope.count = $scope.numero1 / $scope.numero2;
  }  
 
  $scope.subtrair = function(){
	  $scope.count = $scope.numero1 - $scope.numero2;
  } 
}

app.controller("ctrl",init);
