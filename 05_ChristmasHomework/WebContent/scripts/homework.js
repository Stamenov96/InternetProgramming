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
		//alert("Hello World!");
		//Task10
		$("#col1").before($("#col2"));
	});
	
	
//Task11
	function handleError(error) {
		console.error("error", error, arguments);
	}
	
	function appendToList(list, post) {
		var newElement = $("<li/>");
		newElement.text(post.title);
		list.append(newElement);
	}
	function processResponse(response) {
		var list = $("#posts");
		var i = 0;
		$.each(response, function() {
			appendToList(list, this);
			if (++i >= 5) {
				return false;
			}
		});
	}
		
	$.ajax("http://jsonplaceholder.typicode.com/posts", {
	  method: "GET"
	}).then(processResponse, handleError);

//Task12
	
	var data = $("#addbutton").click(function() {
		 var text = $("#textinput").val();
		 if(text.length <=0){
			 alert(("You must enter text"));
		 } 
	});
	
	
});