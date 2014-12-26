$(document).ready(function() {
	"use strict"
	
	//Task2
	var data = ($("a[title|='Технически Университет - София']"));
	console.log($(data).attr( "title" ));
	
	//Task3
	var data = ($("#col1 p"))
	console.log($(data).text())
});