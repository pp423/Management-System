(function(){
    'use strict';

    angular.module('foodspot')
        .controller('ReservationDetailsController', ReservationDetailsControllerFn);

    ReservationDetailsControllerFn.$inject = ['dataService'];

    function ReservationDetailsControllerFn(dataService){
        var revdetailsVm = this;

        dataService.getResv().then(function(data){
            revdetailsVm.entries = data;
        }, function(err){
            console.log(err);
        });
    }
})();