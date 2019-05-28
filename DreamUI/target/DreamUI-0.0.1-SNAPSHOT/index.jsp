<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js">
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<script src="service.js"></script>	
<script src="script.js"></script>


<script>
	$(document).ready(function() {
		$("#match").click(function() {
			$("#teamSelector").show();
			$("#points").show();
		});

		$("#playerButton").click(function() {
			document.getElementById("playerButton").disabled = true;
		});
		
	});
</script>

<style type="text/css">
.wrapper .post {
	-moz-border-radius: 7px 7px 7px 7px;
	border: 1px solid silver;
	float: left;
	margin: 10px;
	min-height: 100px;
	padding: 5px;
	width: 700px;
	background-color: #ff9999;
}

body {
	background-image: url("images/others/cric.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#myteam {
	clear: both;
}

#outer #team {
	clear: none;
	-moz-border-radius: 7px 7px 7px 7px;
	border: 1px solid silver;
	float: left;
	margin: 10px;
	min-height: 50px;
	padding: 5px;
	width: 130px;
	background-color: #ff9999;
}
</style>
<title>Dream 11 fantasy league</title>
</head>

<body ng-controller="myCtrl">

	<div class="row">
		<div class="col-sm-2">
			<img src="images/others/home.jpg" ng-click="reload()"
				style="width: 100px; height: 100px; margin-left: 30px">

			<h3 style="margin-left: 50px">Home</h3>
			<h6 style="text-shadow: 2px 2px 8px orange;"><%=new java.util.Date()%></h6>

		</div>

		<div class="col-sm-7 ">
			<h1 style="color: red; text-align: center">Welcome to Dream11</h1>
		</div>

		<div class="col-sm-3 ">


			<div ng-show="LoginDiv">
				<form role="form">
					<div class="form-group">
						<b>Username: </b> <input type="text" class="form-control"
							ng-model="username">
					</div>
					<div class="form-group">
						<b>Password: </b> </label> <input type="password" class="form-control"
							ng-model="password">
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
						<button type="submit" class="btn btn-default"
							ng-click="login(username,password)">Submit</button>
						<a href="" class="bg-info" ng-click="go('/Register')"> Create
							Account </a>
					</div>
				</form>
			</div>

			<h3>{{LoginFailureMessage}}</h3>

			<div ng-show="UserDiv">
				<h2>
					Welcome
					<code>{{loggedinUser.name}} </code>
				</h2>
			</div>


		</div>

	</div>

	<div class="row">

		<div ng-show="addVisibility" class="col-md-3 bg-success"
			ng-click="go('/AddBook')">
			<h2>Home</h2>
		</div>

		<div class="{{suggestDiv ? 'col-md-3' : 'col-md-4'}} bg-info"
			ng-click="go('/todaysMatch')">
			<h2>See todays match</h2>
		</div>

		<div class="{{viewDiv ? 'col-md-3' : 'col-md-4'}} bg-success"
			ng-click="getAllBooks(); go('/ViewAllBooks')">
			<h2>View my team</h2>
		</div>

		<div class="{{requestDiv ? 'col-md-3' : 'col-md-4'}} bg-info"
			ng-click="go('/RequestBook')">
			<h2>My Dashboard</h2>
		</div>
	</div>


	<div ng-show="loggedin" ng-repeat="x in matches" id="match">

		<div ng-click=" selectMatch(x); getIPlTeams(x.iplTeam1Id, x.iplTeam2Id);" id="team"
			style="display: inline-block">
			<img src="images/csk/dhoni.png" height="150 px" width="150 px"
				alt="Smiley face">
		</div>

		<div id="team" style="display: inline-block">
			<img src="images/others/vs.png" height="150 px" width="150 px"
				alt="Smiley face">
		</div>

		<div id="team" style="display: inline-block">
			<img src="images/mi/rohit.png" height="150 px" width="150 px"
				alt="Smiley face">
		</div>

	</div>




	<div id="placeholder" class="ng-view"></div>
	<button type="button" class="btn btn-primary btn-block"
		ng-click="reload()">Reset</button>



</body>
</html>