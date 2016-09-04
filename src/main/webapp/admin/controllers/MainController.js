/**
 * Created by anuradhawick on 9/4/16.
 */
var app = angular.module('lei-admin', ['ngRoute']);

app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/add-records', {
            templateUrl: '/admin/addRecords.html',
            activeTab: 'addRecords'
        })
        .when('/advertisements', {
            templateUrl: '/admin/advertisements.html',
            activeTab: 'advertisement'
        });
    $locationProvider.html5Mode(true);
});

angular.module('lei-admin').controller('MainController', function ($route, $routeParams, $location, $scope) {
    this.$route = $route;
    this.$location = $location;
    this.$routeParams = $routeParams;

    $scope.isActive = function(path){
        return ($location.path()).match(path);
    }
});