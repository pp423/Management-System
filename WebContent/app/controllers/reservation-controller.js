/**
 * Created by Piyush on 9/5/2015.
 */
(function () {
    'use strict';

    angular.module('foodspot')
        .controller('ReservationController', ReservationControllerFn)
        .controller('ModalCtrl', ModalCtrlFn)
        .controller('ModalInstanceCtrl', ModalInstanceCtrlFn);

    ModalCtrlFn.$inject = ['$scope', '$modal'];
    function ModalCtrlFn($scope, $modal) {
        $scope.open = function (){
            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: 'ModalInstanceCtrl',
                resolve :{
                    item: function(){
                        return 'reserveVm.newReserve.reserveId';
                    }
                }
            });
        };
    }

    ModalInstanceCtrlFn.$inject = ['$scope', '$modalInstance'];
    function ModalInstanceCtrlFn($scope, $modalInstance){
        $scope.ok = function(){
            $modalInstance.close();
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }

    ReservationControllerFn.$inject = ['$scope', 'dataService'];
    function ReservationControllerFn($scope, dataService) {
        $scope.newReserve = {};
        var reserveVm = this;
        reserveVm.addRev = function(newReserve){
            dataService.addRev(newReserve)
                .success(function (){
                    reserveVm.newReserve = null;
                }).error(function(){
                    console.log(err);
                });
        }
    }
})();