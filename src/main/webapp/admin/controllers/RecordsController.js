/**
 * Created by anuradhawick on 9/4/16.
 */
angular.module("lei-admin").controller('recordsController', function ($scope) {
    let selectedSVGColor = null;
    let selectedSVGId = null;
    let svg = null;

    $scope.productType = null;
    $scope.products = [];

    $scope.remove = function (index) {
        $scope.products.splice(index, 1);
    };

    $scope.init = function () {
        $scope.svg = Snap('#productTypeLocations');
        $scope.svg.click($scope.click);
    };

    $scope.click = function (e) {
        let clickedSvg = $scope.svg.select("#" + e.target.id);
        // only for clickable svgs
        if ((e.target.id).match('^svg')) {
            // reset previously clicked svg
            if (selectedSVGId) {
                $scope.svg.select("#" + selectedSVGId).attr({fill: selectedSVGColor});
            }
            // change the color or the new svg
            selectedSVGColor = clickedSvg.attr().fill;
            selectedSVGId = clickedSvg.attr().id;
            clickedSvg.attr({
                fill: "#f00",
            })
        }
    };

    $scope.addProduct = function () {
        if ($scope.name.length > 0 && $scope.price && $scope.description.length > 0) {
            $scope.products.push({name: $scope.name, price: $scope.price, description: $scope.description});
            $scope.name = '';
            $scope.price = '';
            $scope.description = '';
        }
    };

    $scope.saveProducts = function () {
        let data = {};
        data.products = $scope.products;
        data.productType = $scope.productType;
        data.location = {name: selectedSVGId};
        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {
                if (!this.responseText.error) {
                    $scope.productType = '';
                    $scope.products = [];
                    $scope.$apply();
                    alert('success');
                }
            }
        });

        xhr.open("POST", "/lei-api/product-management");
        xhr.setRequestHeader("content-type", "application/json");

        xhr.send(JSON.stringify(data));
    };

    $scope.init();
});