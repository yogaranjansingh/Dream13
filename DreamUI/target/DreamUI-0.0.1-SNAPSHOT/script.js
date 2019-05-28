app.controller('myCtrl', function($scope, $window, $http, $location,
		testService, addSelectedPlayerService, selectedEntityService, utilService) {

	$scope.count = 0;
	$scope.captainSelectedFlag = false;
	$scope.viceCaptainSelectedFlag = false;
	$scope.selectedPlayers = [];

	$scope.successMessage = "";
	$scope.LoginSuccessMessage = "";
	$scope.LoginFailureMessage = "";
	$scope.LoginDiv = true;
	$scope.UserDiv = false;
	$scope.addDiv = false;
	$scope.requestDiv = false;
	$scope.suggestDiv = false;
	$scope.viewDiv = false;
	$scope.addVisibility = false;
	$scope.loggedin = false;
	$scope.teamPlayers1 = [];
	$scope.teamPlayers2 = [];
	
	$scope.selectedMatch = null;
	$scope.loggedinUser = utilService.loggedUser;
	console.log("Anishwa");
	console.log("Anishwa----"+$scope.loadedTeams);
	console.log("Yogwa----"+  utilService.loadedTeams);
	
	

	testService.async().then(function(d) {
		$scope.matches = d;
	});
	
	
	$scope.selectedPlayers = addSelectedPlayerService.selectedPlayers;

	console.log("inside controller " + $scope.matches);

	$scope.getIPlTeams = function(teamid1, teamid2) {
		
		console.log($scope.selectedMatch);

		$scope.selectedTeamId1 = teamid1;
		$scope.selectedTeamId2 = teamid2;

		$http({
		    method : "GET",
		      url : "http://localhost:8080/Dream13/rest/v1/getIPLTeam?iplTeamId="
					+ teamid1
		  }).then(function mySuccess(response) {
			  $scope.team1 = response.data;
		  }, function myError(response) {
			  $scope.team1 = null;
		  });

		
		
		$http({
		    method : "GET",
		      url : "http://localhost:8080/Dream13/rest/v1/getIPLTeam?iplTeamId="
					+ teamid2
		  }).then(function mySuccess(response) {
			  $scope.team2 = response.data;
		  }, function myError(response) {
			  $scope.team2 = null;
		  });
		
	};

	$scope.select = function(name, id) {
		$scope.count = $scope.count + 1;
		addSelectedPlayerService.myFunc(name,id);
		if ($scope.count == 11) {
			$scope.selectedPlayers = addSelectedPlayerService.selectedPlayers;
			window.alert("11 players selected, Please proceed");
		}
	};

	$scope.reload = function() {
		$window.location.reload();
	};
	
	$scope.joinMatch = function() {
//			$http.get(
//					"http://localhost:8080/Dream13/rest/v1/joinMatch?userId="
//							+selectedEntityService.loggedUser.id +"&matchId=" +selectedEntityService.selectedMatch.id ).then(function(response) {
//								selectedEntityService.loadedTeams = response.data;
//								console.log(selectedEntityService.loadedTeams);
//			});
		
		selectedEntityService.async().then(function(d) {
			$scope.loadedTeams = d;
		});
			
			$location.path('/myteam');
	};
	
//	$scope.loadTeamPlayers = function() {
//		
//		$http.get(
//				"http://localhost:8080/Dream13/rest/v1/getPlayersByTeamId?teamId="
//						+ match.get).then(function(response) {
//			$scope.teamPlayers1 = response.data;
//		});
//	};

	$scope.captainSelected = function() {
		$scope.captainSelectedFlag = true
	};

	$scope.viceCaptainSelected = function() {
		$scope.viceCaptainSelectedFlag = true
	};

	$scope.login = function(username, password) {
		var data = {
			"username" : username,
			"password" : password
		};
		$http.post("http://localhost:8080/Dream13/rest/user/login", data, null)
				.then(function(response) {
					console.log("login success")
					$scope.loggedinUser = response.data;
					utilService.loggedUser = $scope.loggedinUser;
					$scope.LoginFailureMessage = "";
					$scope.LoginDiv = false;
					$scope.UserDiv = true;
					$scope.requestDiv = true;
					$scope.suggestDiv = true;
					$scope.viewDiv = true;
					$scope.addVisibility = true;
					$scope.loggedin = true;
				});
	};

	$scope.register = function(name, age, username, password) {
		var data = {
			"name" : name,
			"age" : age,
			"username" : username,
			"password" : password
		};
		$http.post("http://localhost:8080/Dream13/rest/user/register", data,
				null).then(function(response) {
			console.log("register success");
			$scope.registerSuccess = "successfully registered.....!!!";
		});
	};

	$scope.go = function(path) {
		$location.path(path);
	};
	
	
	$scope.selectMatch = function(match) {
		$scope.selectedMatch = match;
		utilService.selectedMatch = match;
	};

	$scope.saveTeam = function() {
		var data = {
			"team" : {
				"name" : 	"shadowKnights",
				"userId": 	utilService.loggedUser.id,
				"matchId" : utilService.selectedMatch.id,
				"players" : $scope.selectedPlayers
			},
			"user" : utilService.loggedUser,
			"game" : null
		};

		var config = null;

		$http.post("http://localhost:8080/Dream13/rest/v1/saveTeam", data,
				config).then(function(response) {
			console.log("success");
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