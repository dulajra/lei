/**
 * Created by anuradhawick on 9/4/16.
 */
angular.module('lei-admin').directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

angular.module('lei-admin').controller('AdvertisementController', function ($scope) {
    $scope.advertisements = [];
    // loading advertisements
    let data = null;
    let xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            $scope.advertisements = JSON.parse(this.responseText);
            $scope.$apply();
        }
    });
    xhr.open("GET", "/lei-api/advertisement-management/get-ads");
    xhr.send(data);

    $scope.uploadFile = function () {
        let file = $scope.inputImage;
        let fr = new FileReader();
        if (file) {
            fr.readAsDataURL(file);
            fr.onload = function (event) {
                let data = event.target.result;
                let xhr = new XMLHttpRequest();
                xhr.withCredentials = true;
                xhr.addEventListener("readystatechange", function () {
                    if (this.readyState === this.DONE) {
                        $scope.advertisements.push(JSON.parse(this.responseText));
                        document.getElementById("imageFile").value = '';
                        $scope.$apply()
                    }
                });

                xhr.open("POST", "/lei-api/advertisement-management/add-image");
                xhr.setRequestHeader("content-type", "application/json");
                xhr.send(JSON.stringify({encodedImage: data}));
            };
        }
    };

    $scope.deleteAdd = function (index) {
        if (confirm("Are you sure you want to delete the item?")) {
            let data = JSON.stringify($scope.advertisements[index]);
            let xhr = new XMLHttpRequest();
            xhr.withCredentials = true;
            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === this.DONE) {
                    if (JSON.parse(this.responseText) == true) {
                        $scope.advertisements.splice(index, 1);
                        $scope.$apply();
                    }
                }
            });
            xhr.open("DELETE", "/lei-api/advertisement-management/delete-add");
            xhr.setRequestHeader("content-type", "application/json");
            xhr.send(data);
        }
    };
});