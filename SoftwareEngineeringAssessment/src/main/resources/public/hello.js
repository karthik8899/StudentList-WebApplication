angular.module('demo', ['ngGrid'])
.controller('Hello', function($scope, $http) {
	$scope.studentList=[];
	$scope.showStudentData= false;
	$scope.newStudentData={};
	
	$scope.loadingData= function(){
		
		var request=[{name: "prudhvi",age:"27",id:1}, 
			{name: "srikanth",age:"27",id:2},
			{name: "kennedy",age:"27",id:3},
			{name: "punna",age:"27",id:4},
			{name: "rohith",age:"27",id:5}];

		$http({
		    method : "POST",
		    url : "/insertStudents",
		    data : angular.toJson(request),
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		}).then(function successCallback(response) {
	    
	    }, function errorCallback(response) {
	        console.log(response);
	    });
	}
	
	$scope.loadingData(); 
	
	
	
	
	
	
	$scope.getAllStudents = function(){
    
		$http({
		    method : "POST",
		    url : "/getStudents",
		    data : {},
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		}).then(function successCallback(response) {
	       $scope.studentList = response.data;
	       $scope.showStudentData= true;
	    }, function errorCallback(response) {
	        console.log(response);
	    });
		
		
     }
	
	$scope.insertStudent = function(){
		var request=[];
		request.push($scope.newStudentData);
		
		$http({
		    method : "POST",
		    url : "/insertStudents",
		    data : angular.toJson(request),
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		}).then(function successCallback(response) {
	     
	    }, function errorCallback(response) {
	        console.log(response);
	    });
	}
	$scope.deleteStudent = function(){
		var request=[];
		request.push($scope.newStudentData);

		$http({
		    method : "DELETE",
		    url : "/deleteStudents/"+$scope.newStudentData.id,
		    data : angular.toJson(request),
		    headers : {
		        'Content-Type' : 'application/json'
		    }
		}).then(function successCallback(response) {
			  alert ("Deleted Sucessfully");
	     
	    }, function errorCallback(response) {
	        console.log(response);
	    });
	}


	  $scope.gridOptions = {
	      data: 'studentList',
	      columnDefs: [{field:'id', displayName: 'Id', enableCellEdit: false},
	    	  {field:'name', displayName: 'Name', enableCellEdit: false},
	    	  {field:'age', displayName: 'Age', enableCellEdit: false}
	            ]
	     
	    };
	
	
     
});
