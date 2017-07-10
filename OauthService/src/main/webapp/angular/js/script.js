var app = angular.module("myApp",[]);

app.controller("authenticationCtrl", function($scope, $http, $window){
	$scope.goToGoogle = function(){
		$http.get("http://localhost:8080/OauthService/webapi/auth/loginUrl").success(function(response){
			$scope.loginUrl = response;
			$window.location.href= $scope.loginUrl;
		});
		
	}
});