$(document).ready(function() {
	"use strict"
	
	//Task2
	var data = ($("a[title|='Технически Университет - София']"));
	console.log($(data).attr( "title" ));
	
	//Task3
	var data = ($("#col1 p"))
	console.log($(data).text())

	//Task4
	var data = ($("#menu-top-level-menu" ).append("<li id='menu-item-7777'><a>New Button</a></li>").addClass( "menu-item menu-item-type-post_type menu-item-object-page menu-item-2914" ))
	
	//Task5
	var data = ($("#footer").prepend("<div id ='dynamiccontent'></div>"))
	
	//Task6
	var data = ($("#dynamiccontent").append("<input id = 'textinput'>"))
	
	//Task7
	var data = ($("#dynamiccontent").append("<button id = 'addbutton'>Add</button>"))
	
	//Task8
	var data = ($("#dynamiccontent").append("<ul id = 'posts'>"))
	
	//Task9
	var data = $("#menu-item-7777").click(function() {
		alert("Hello World!");
	});
	
});