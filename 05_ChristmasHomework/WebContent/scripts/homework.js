$(document).ready(function() {
	"use strict"
	
	//Task2
	var data = ($("a[title|='Технически Университет - София']"));
	console.log($(data).attr( "title" ));
	
});