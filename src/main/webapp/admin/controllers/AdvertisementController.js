/**
 * Created by anuradhawick on 9/4/16.
 */
angular.module('lei-admin').controller('AdvertisementController', function ($scope) {
    $scope.saveFile = function () {
        console.log($scope.inputImage);
    }
});