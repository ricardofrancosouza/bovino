var app = angular.module("app",[]);

app.controller("PessoaCtrl", function($scope)
{
	$scope.pessoas = [

	{"nome": "Bruce Wayne",   "idade": 33},
	{"nome": "Oliver Queen",  "idade": 33},
	{"nome": "Son Goku",      "idade": 33},
	{"nome": "Jaque Demolay", "idade": 33}
	];
	
	$scope.adicionarpessoa = function(pessoa){
		$scope.pessoas.push(angular.copy(pessoa));
		delete $scope.pessoa;
	};
	$scope.apagar = function()
	{
		var ind = $scope.pessoas.indexOf($scope.pessoa);
		$scope.pessoas.splice(ind,1);
	};
	$scope.selecionar = function( pessoa)
	{
		$scope.pessoa = pessoa;
	};
	$scope.limpar=function()
	{
		$scope.pessoa = "";
	};
	
});