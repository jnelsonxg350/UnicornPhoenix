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
	$('#personForm').validator().on('submit', function (e) {
		  if (!e.isDefaultPrevented()) {
			  event.preventDefault();
			  $.post( "/UnicornPhoenix/AddPerson", $( "#personForm" ).serialize())
			  	.done(function(data)
				{
			  		window.location = "/UnicornPhoenix/AllPeople";
				});
		  }
	});
	$('#emailForm').validator().on('submit', function (e) {
		  if (!e.isDefaultPrevented()) {
			  event.preventDefault();
			  $.post( "/UnicornPhoenix/AddEmail", $( "#emailForm" ).serialize())
			  	.done(function(data)
				{
			  		window.location = "/UnicornPhoenix/AllPeople";
				});
		  }
	});
	$('#AllergyForm').validator().on('submit', function (e) {
		  if (!e.isDefaultPrevented()) {
			  event.preventDefault();
			  $.post( "/UnicornPhoenix/AddAllergy", $( "#AllergyForm" ).serialize())
			  	.done(function(data)
				{
			  		window.location = "/UnicornPhoenix/AllAllergy";
				});
		  }
	});
	$('#addMedHistory').validator().on('submit', function (e) {
		  if (!e.isDefaultPrevented()) {
			  event.preventDefault();
		  	$.post( "/UnicornPhoenix/AddMedHistory", $( "#addMedHistory" ).serialize())
		  	.done(function(data)
			{
		  		window.location = "/UnicornPhoenix/AllPeople";
			});
		  }
	});
	$('#VisitForm').validator().on('submit', function (e) {
	  if (!e.isDefaultPrevented()) {
		  event.preventDefault();
	    $.post( "/UnicornPhoenix/AddVisit", $( "#VisitForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	  }
	});
});