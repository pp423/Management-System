(function(){
    'use strict';

    angular.module('foodspot', ['ui.router', 'ui.bootstrap']);

    angular
        .module('foodspot')
        .config(moduleConfig);

    moduleConfig.$inject = ['$stateProvider','$urlRouterProvider','$httpProvider'];

    function moduleConfig($stateProvider, $urlRouterProvider, $httpProvider){

        $urlRouterProvider.otherwise('/users');

        $stateProvider
            .state('users', {
                url: '/users',
                templateUrl: 'app/views/reservation-tmpl.html',
                controller: 'ReservationController',
                controllerAs: 'reserveVm'
            })
            .state('owner', {
                url: '/owner',
                templateUrl: 'app/views/ownerlogin-tmpl.html'
                /*controller: 'LoginController',
                controllerAs: 'loginVm'*/
            })
            .state('hoteldetails', {
                url: '/hoteldetails',
                templateUrl: 'app/views/hoteldetails-tmpl.html'
                /*controller: 'HotelController',
                controllerAs: 'hotelVm'*/
            })
            .state('hoteldetails.reservation', {
                url: '/reservation',
                templateUrl: 'app/views/reservationdetails-tmpl.html',
                controller: 'ReservationDetailsController',
                controllerAs: 'revdetailsVm'
            })
            .state('hoteldetails.seating', {
                url: '/seating',
                templateUrl: 'app/views/seating-tmpl.html'
            })
            .state('hoteldetails.profile', {
                url: '/profile',
                templateUrl: 'app/views/profile-tmpl.html'
            })
            .state('hoteldetails.contact', {
                url: '/contact',
                templateUrl: 'app/views/contact-tmpl.html'
            });

        $httpProvider.defaults.withCredentials = true;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
    }

    /*angular.module('foodspot', ['ngRoute', 'ui.bootstrap']);

    angular
        .module('foodspot')
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider){
        $routeProvider
            .when('/users', {
                templateUrl: 'app/views/reservation-tmpl.html',
                controller: 'ReservationController',
                controllerAs: 'reserveVm'
            })
            .when('/owner', {
                templateUrl: 'app/views/ownerlogin-tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/hoteldetails',{
                templateUrl: 'app/views/hoteldetails-tmpl.html',
                controller: 'HotelController',
                controllerAs: 'hotelVm'
            })
            .otherwise({
                redirectTo: '/users'
            });
    }*/
})();