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
		
	$.ajax(/*"http://jsonplaceholder.typicode.com/posts"*/"http://localhost:3000/posts", {
	  method: "GET"
	}).then(processResponse, handleError);

	
	
	
//Task12
	
	
	
	var data = $("#addbutton").click(function() {
		 var xbtn =0
		 var text = $("#textinput").val();
		 if(text.length <=0){
			 alert(("You must enter text"));
		 } else {
			 //Task13
			 xbtn++;
			 $.ajax('http://localhost:3000/posts', {
				  method: 'POST',
				  data: {
					    title: 'newTitle',
					    body: text,
					    userId: 1,
					    id:(100+xbtn)
				  } 
				}).then(function(data) {
					//console.log("Data send")
					console.log(data)
					//Task14
					var id = ($(data).attr("id"))
					//console.log(id)
					//console.log("asd")
					//console.log("http://jsonplaceholder.typicode.com/posts"+id)
					$.ajax("http://localhost:3000/posts/"+id, {
						method: "GET"
							
						}).then(function(data2){
							
							var list = $("#posts");
							var i = 0;
								var newElement = $("<li id="+xbtn+">");
								var newButton = $("<button>X</button>");
								newElement.append($(data2).attr("body"));
								newElement.append("</li>")
								
								newButton.click(function(){
									var r = confirm("Are you sure you want to delete it ?");
									if (r == true) {	 
									    $.ajax('http://jsonplaceholder.typicode.com/posts/'+(data2.id), {
									    	  method: 'DELETE',
									    	  success: function() {
													$(".xbtn" + data2.id).remove();
													
												}
									    	})
									
									}
								})
								newElement.attr("class", "xbtn" + data2.id);
								newButton.attr("class", "xbtn" + data2.id);
								newElement.append(newButton)
								list.append(newElement);
							
								
							
						});

				});

			 
		 }


	});
	
	var processNewResponse = function(response) {
				$.each(response, function() {
					appendToList($("ul#posts"), this);
				});
			};
	
	 var inputelement  = $("<input/>")
	// var delsupport = $("<button>X</button>");
	 inputelement.attr("id","inputelement")
	 inputelement.insertBefore( $( "#posts" ) );
	 inputelement.change(function(){
	 console.log($("#inputelement").val())
		 
			var inputval = $("#inputelement").val();
	 		$("#posts li").remove();
		 		$.ajax("http://localhost:3000/posts?userId=" + inputval, {
		 			method: "GET"
		 		}).then(function(data3){
		 			var list = $("#posts");
		 			$.each(data3, function() {
		 			
		 				
		 				
		 				var newElement = $("<li>");
						var delsupport = $("<button>X</button>");
						newElement.text(this.title);
						newElement.append("</li>")
		 				
		 				delsupport.click(function(){
							var r = confirm("Are you sure you want to delete it ?");
							if (r == true) {	 
							    $.ajax('http://jsonplaceholder.typicode.com/posts/'+(data3.id), {
							    	  method: 'DELETE',
							    	  success: function() {
											$("#delsupport" + data3.id).remove();
											
										}
							    	})
							
							}
						})
						newElement.attr("id", "delsupport" + data3.id);
						delsupport.attr("id", "delsupport" + data3.id);
						newElement.append(delsupport)
						list.append(newElement);
		 			})
		 			
		 		});
	 })
	
	

});