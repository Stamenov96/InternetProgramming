$(document).ready(function() {
	"use strict"

	// search for jQuery selectors
	// 1. by element name:
	console.log($("body"));
	// 2. by ID - using #
	console.log($("#logo"));
	// 3. by CSS class - using .
	console.log($(".sbutton"));
	// 4. by element name and CSS class:
	console.log($("span.h2arr"));
	// 5. by parent (using SPACE) - children of ul that have class pretty:
	console.log($("div .latest"));
	// 6. by attribute which is EQUAL to string
	// ( "[attribute|='value']" )
	console.log($("a[rel|='bookmark']"));
	// 7. by attribute which CONTAINS string 
	console.log($( "a[href*='white']" ));
	// 8. by all elements that contains the specified text
	console.log($( "a:contains('Съобщения')"));
	// 9. by even elements, zero-indexed.
	console.log($( "div:even" ));
	// 10. all elements that are the first among siblings of the same element name.
	console.log($( "li:first-of-type" ));
	// 11. by attribute name
	console.log($( "a[rel]" ));
	// 12. by matching elements that matches all of the specified attribute filters.
	console.log($( "a[rel][href*='white']"));
	// 13. all next elements matching "next" that are immediately preceded by a sibling "prev".
	console.log($("label + input"));
	// 14. all elements that are the nth-child of their parent, counting from the last element to the first.
	console.log($("ul li:nth-last-of-type(2)"));
	// 15. all input elements
	console.log($(":input"));
	//DOM Manipulation
	$("h1").after("<h2>САМО ЛЕВСКИ ! </h2>");
	$("li").after("<b>ОЛЕ</b>")
	
	
	
});