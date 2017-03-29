var insuranceApp = angular.module("insuranceApp", ["ui.router"]);

insuranceApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("home");

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: URLS.partialsHome,
            controller: 'HomeController'
        });
});


insuranceApp.factory("insuranceAppFactory", function ($http) {
    var factory = {};

    factory.getMessageResponse = function(message) {
        message = "categories";
        return $http.post(URLS.dispatch, {payload: message});
    };

    return factory;
});


insuranceApp.controller("HomeController", function ($scope, insuranceAppFactory) {

    function init() {
        $scope.message = "";
        $scope.errorMessage = "";
        $scope.insurance = "";
        $scope.categories = [];
    }

    $scope.getMessageResponse = function(message) {
    	insuranceAppFactory.getMessageResponse(message).success(function(data){
            console.log("Respuesta"+JSON.stringify(data));
            
            $scope.message = data;
            $scope.errorMessage = "";
            $scope.insurance = data.name+" "+data.description;
            $scope.categories = data.categories;
            
        }).error(function(data, status, headers, config) {
            $scope.errorMessage = data.error;
        });
    }
    init();
});