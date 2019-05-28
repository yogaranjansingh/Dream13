app.controller('myCtrl', function($rootScope,$rootScope, $window, $http, $location,
		testService, addSelectedPlayerService, utilService) {

	$rootScope.count = 0;
	$rootScope.captainSelectedFlag = false;
	$rootScope.viceCaptainSelectedFlag = false;
	$rootScope.selectedPlayers = [];

	$rootScope.successMessage = "";
	$rootScope.LoginSuccessMessage = "";
	$rootScope.LoginFailureMessage = "";
	$rootScope.LoginDiv = true;
	$rootScope.UserDiv = false;
	$rootScope.addDiv = false;
	$rootScope.requestDiv = false;
	$rootScope.suggestDiv = false;
	$rootScope.viewDiv = false;
	$rootScope.addVisibility = false;
	$rootScope.loggedin = false;
	$rootScope.teamPlayers1 = [];
	$rootScope.teamPlayers2 = [];
	
	$rootScope.selectedMatch = null;
	$rootScope.loggedinUser = utilService.loggedUser;

	testService.async().then(function(d) {
		$rootScope.matches = d;
	});
	
	
	$rootScope.selectedPlayers = addSelectedPlayerService.selectedPlayers;

	console.log("inside controller " + $rootScope.matches);

	$rootScope.getIPlTeams = function(teamid1, teamid2) {
		
		console.log($rootScope.selectedMatch);

		$rootScope.selectedTeamId1 = teamid1;
		$rootScope.selectedTeamId2 = teamid2;

		$http({
		    method : "GET",
		      url : "http://localhost:8080/Dream13/rest/v1/getIPLTeam?iplTeamId="
					+ teamid1
		  }).then(function mySuccess(response) {
			  $rootScope.team1 = response.data;
		  }, function myError(response) {
			  $rootScope.team1 = null;
		  });

		
		
		$http({
		    method : "GET",
		      url : "http://localhost:8080/Dream13/rest/v1/getIPLTeam?iplTeamId="
					+ teamid2
		  }).then(function mySuccess(response) {
			  $rootScope.team2 = response.data;
		  }, function myError(response) {
			  $rootScope.team2 = null;
		  });
		
	};

	$rootScope.select = function(name, id) {
		$rootScope.count = $rootScope.count + 1;
		addSelectedPlayerService.myFunc(name,id);
		if ($rootScope.count == 11) {
			$rootScope.selectedPlayers = addSelectedPlayerService.selectedPlayers;
			window.alert("11 players selected, Please proceed");
		}
	};

	$rootScope.reload = function() {
		$window.location.reload();
	};
	
	$rootScope.joinMatch = function() {
			$http.get(
					"http://localhost:8080/Dream13/rest/v1/joinMatch?userId="
							+utilService.loggedUser.id +"&matchId=" +utilService.selectedMatch.id ).then(function(response) {
								utilService.loadedTeams = response.data;
								$rootScope.loadedTeams = response.data;
								console.log(utilService.loadedTeams);
			});
		
		$location.path('/myteam');
	};
	
//	$rootScope.loadTeamPlayers = function() {
//		
//		$http.get(
//				"http://localhost:8080/Dream13/rest/v1/getPlayersByTeamId?teamId="
//						+ match.get).then(function(response) {
//			$rootScope.teamPlayers1 = response.data;
//		});
//	};

	$rootScope.captainSelected = function() {
		$rootScope.captainSelectedFlag = true
	};

	$rootScope.viceCaptainSelected = function() {
		$rootScope.viceCaptainSelectedFlag = true
	};

	$rootScope.login = function(username, password) {
		var data = {
			"username" : username,
			"password" : password
		};
		$http.post("http://localhost:8080/Dream13/rest/user/login", data, null)
				.then(function(response) {
					console.log("login success")
					$rootScope.loggedinUser = response.data;
					utilService.loggedUser = $rootScope.loggedinUser;
					$rootScope.LoginFailureMessage = "";
					$rootScope.LoginDiv = false;
					$rootScope.UserDiv = true;
					$rootScope.requestDiv = true;
					$rootScope.suggestDiv = true;
					$rootScope.viewDiv = true;
					$rootScope.addVisibility = true;
					$rootScope.loggedin = true;
				});
	};

	$rootScope.register = function(name, age, username, password) {
		var data = {
			"name" : name,
			"age" : age,
			"username" : username,
			"password" : password
		};
		$http.post("http://localhost:8080/Dream13/rest/user/register", data,
				null).then(function(response) {
			console.log("register success");
			$rootScope.registerSuccess = "successfully registered.....!!!";
		});
	};

	$rootScope.go = function(path) {
		$location.path(path);
	};
	
	$rootScope.refreshTeams = function() {
		$scope.joinMatch();
	};
	
	
	$rootScope.selectMatch = function(match) {
		$rootScope.selectedMatch = match;
		utilService.selectedMatch = match;
	};

	$rootScope.saveTeam = function() {
		var data = {
			"team" : {
				"name" : 	"shadowKnights",
				"userId": 	utilService.loggedUser.id,
				"matchId" : utilService.selectedMatch.id,
				"players" : $rootScope.selectedPlayers
			},
			"user" : utilService.loggedUser,
			"game" : null
		};

		var config = null;

		$http.post("http://localhost:8080/Dream13/rest/v1/saveTeam", data,
				config).then(function(response) {
			console.log("success");
			$rootScope.joinMatch();
		}, function(response) {
			console.log("failure")
		});
		
		
	};

});

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'myCtrl',
		templateUrl : 'playerSelector.html'
	}).when("/myteam", {
		controller : 'myCtrl',
		templateUrl : 'myTeam.html'
	}).when('/Register', {
		controller : 'myCtrl',
		templateUrl : 'Register.html'
	})

} ]);