var app = angular.module("myApp", [], function($locationProvider) {
	$locationProvider.html5Mode(true);});
	
app.controller("authenticationCtrl", function($scope, $http, $window, $location) {
	
	$scope.getAuthorizationUrl = function() {
		$http.get("http://localhost:8080/OauthService/webapi/auth/")
				.success(function(response) {
					$scope.loginUrl = response;
					$window.location.href = $scope.loginUrl;
				});

	};
	
	$scope.code = encodeURIComponent($location.search().code).replace("%","%25");
	
	$scope.getUserInfo = function(){
		$http.get("http://localhost:8080/OauthService/webapi/auth/"+$scope.code)
		.success(function(response) {
			$scope.profilePhoto = response.picture;
			$scope.firstName = response.family_name;
			$scope.lastName = response.given_name;
		});
	}
	
	
})


