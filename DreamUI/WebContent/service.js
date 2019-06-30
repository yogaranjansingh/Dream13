var app = angular.module('app', [ "ngRoute" ]);

app.run(function($rootScope) {
	  $rootScope.color = 'blue';
	});

app.factory('testService', function($http) {
	  var myService = {
	    async: function() {
	      var promise = $http.get('http://localhost:8080/Dream13/rest/v1/getTodaysMatch').then(function (response) {
	        console.log("inside service function : "+response.data);
	        return response.data;
	      });
	      return promise;
	    }
	  };
	  return myService;
	});

app.service('addSelectedPlayerService', function() {
	  this.selectedPlayers = [];	
	  this.myFunc = function (name, id) {

		  this.selectedPlayers.push({
				"name" : name,
				"id" : id
			});
	  }
	});

app.service('utilService', function() {
	this.selectedMatch =null;	
	  this.loggedUser = null;
	  this.loadedTeams = null;
	  this.score1 = 0;
	  this.score2 = 0;
	});
