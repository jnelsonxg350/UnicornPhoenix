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
	$(".btnUpdateEmail").click(function(){
		var emailID = $(this).data('emailid');
		window.location = "/UnicornPhoenix/AddEmail?EmailID=" + emailID;
	});
	$('.btnDeleteEmail').click(function(){
		var emailID = $(this).data('emailid');
		$.post( "/UnicornPhoenix/DeleteEmail?EmailID=" + emailID, function(data){
			window.location = "/UnicornPhoenix/AllPeople";
		});		
	});
	$("#addEmail" ).click(function(event) 
	{
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/AddEmail?id=" + id;		
			  	
	});
		
	//Person details visit add, update, delete
	$("#VisitForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddVisit", $( "#VisitForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});
	$(".btnUpdateVisit").click(function(){
		
		var visitID = $(this).data('visitid');		
		window.location = "/UnicornPhoenix/AddVisit?VisitID=" + visitID;
		
	});	
	$("#addVisit" ).click(function(event) 
	{
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/AddVisit?id=" + id;		
	  	
	});
	$(".btnDeleteVisit").click(function(){
			
		var visitID = $(this).data('visitid');		
		$.post("/UnicornPhoenix/DeleteVisit?VisitID=" + visitID)
	  	.done(function(data)
	  	{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});	
	
	//Person details allergy add, update, delete
	$("#AllergyForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddAllergy", $( "#AllergyForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});
	$(".btnUpdateAllergy").click(function(){
		var allergyID = $(this).data('allergyid');
		window.location = "/UnicornPhoenix/AddAllergy?AllergyID=" + allergyID;
	});
	$("#addAllergy" ).click(function(event) 
	{
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/AddAllergy?id=" + id;		
			  	
	});
	$(".btnDeleteAllergy").click(function(){
					
		var allergyID = $(this).data('allergyid');		
		$.post("/UnicornPhoenix/DeleteAllergy?AllergyID=" + allergyID)
	  	.done(function(data)
	  	{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});	
	
	//Person details medical history add, update, delete
	$(".btnUpdateMedicalHistory").click(function(){
		
		var medHistoryID = $(this).data('medicalhistoryid');		
		window.location = "/UnicornPhoenix/AddMedHistory?MedicalHistoryID=" + medHistoryID;
		
	});	
	$("#addMedHistory" ).click(function(event) 
	{
		var id = $(this).data('id');
		window.location = "/UnicornPhoenix/AddMedHistory?id=" + id;		
	  	
	});
	$(".btnDeleteMedicalHistory").click(function(){
			
			var medHistoryID = $(this).data('medicalhistoryid');		
			$.post("/UnicornPhoenix/DeleteMedicalHistory?MedicalHistoryID=" + medHistoryID)
		  	.done(function(data)
			{
		  		window.location = "/UnicornPhoenix/AllPeople";
			});
	});	
	$("#addMedHistoryForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/UnicornPhoenix/AddMedHistory", $( "#addMedHistoryForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/UnicornPhoenix/AllPeople";
		});
	});
	
});