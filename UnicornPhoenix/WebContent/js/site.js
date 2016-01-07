$(document).ready(function(){
	//go to the update form
	$('.btnEditPerson').click(function(){
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/AddPerson?id=" + id;
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
	$( "#personForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddPerson", $( "#personForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});
	
});