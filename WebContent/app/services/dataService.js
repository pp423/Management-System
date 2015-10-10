(function(){
    'use strict';

    angular.module('foodspot')
        .service('dataService', dataServiceFn);

    dataServiceFn.$inject = ['$q', '$http'];

    function dataServiceFn($q, $http){
        var self = this;

        self.addRev = function(newReserve){
            return $http({
                method : 'POST',
                url : 'api/reservation/add',
                data: newReserve
            });
        }

        self.getResv = function(){
            var defer = $q.defer();

            $http({
                method: 'GET',
                url: 'api/reservation/all'
            }).success(function(data){
                defer.resolve(data);
            }).error(function(err){
                defer.reject(err);
            });

            return defer.promise;
        }
    }

})();