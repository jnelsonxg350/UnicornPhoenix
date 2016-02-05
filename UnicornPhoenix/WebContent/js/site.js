$(document).ready(function(){
	//go to the update form
	$('.btnEditPerson').click(function(){
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/AddPerson?id=" + id;
	});
	$('.btnPersonDetails').click(function(){
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/PersonDetails?id=" + id;
	});
	$('.btnUpdateAllergy').click(function(){
		window.location = "/UnicornPhoenix/AddAllergy";
	});
	
	//delete the person
	$('.btnDeletePerson').click(function(){
		var id = $(this).data('id');
		$.post( "/UnicornPhoenix/DeletePerson?id=" + id, function(data){
			window.location = "/UnicornPhoenix/AllPeople";
		});		
	});
	$('.btnAddPerson').click(function(){
		window.location = "/UnicornPhoenix/AddPerson";
	});
	//Capture submit of form to press the add button
	$("#personForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddPerson", $( "#personForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});
	$("#emailForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddEmail", $( "#emailForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	  	
	});
	$("#AllergyForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddAllergy", $( "#AllergyForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllAllergy";
		});
	});
	$("#addMedHistory" ).submit(function(event) 
	{
		console.log('here');
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddMedHistory", $( "#addMedHistory" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});
	$("#VisitForm" ).submit(function(event) 
			{
				event.preventDefault();
			  	$.post( "/UnicornPhoenix/AddVisit", $( "#VisitForm" ).serialize())
			  	.done(function(data)
				{
			  		window.location = "/UnicornPhoenix/AllPeople";
				});
			});
});
