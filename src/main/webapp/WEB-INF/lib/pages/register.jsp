<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Student Records</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet" href="css/bootstrap.css">
<link href="<c:url value='css/app2.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<br>
	<div class="generic-container">
		<div class="panel panel-default">

		<div class="panel-heading"><span class="lead">Student Registration </span></div>

			<div class="formcontainer">
				<form action = "/MVC-MiniProjAnnotation/insertStudentList.htm" method="post">
					
				<input type="hidden" ng-model="ctrl.user.id" />
				     <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">ID</label>
                              <div class="col-md-7">
                                  <input type="text" name="sno" class="email form-control input-sm" placeholder="Enter your ID" required/>
                                  <div ng-show="myForm.$dirty">
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Name</label>
                              <div class="col-md-7">
                                  <input type="text" name="name" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address</label>
                              <div class="col-md-7">
                                  <input type="text" name="address" class="form-control input-sm" placeholder="Enter your Address"/>
                              </div>
                          </div>
                      </div>

                 
<br>
<br>
                      <div class="row">
                          
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                              
                        <input type="submit" name="submit" value="Submit" class="btn btn-primary btn-sm">&nbsp;
						<input type="reset" name="submit" value="Reset" class="btn btn-warning btn-sm">
				
                          
                      </div>
					
					
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>