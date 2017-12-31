$(document).ready(function(){
	
	$("#post_button").click(function(){
		$("#post_content").toggle();
	});
	$("#update_profile_button").click(function(){
		$("#update_profile").toggle();
		$("#display_profile").toggle();
	});
	$("#cancel_profile_button").click(function(){
		$("#update_profile").toggle();
		$("#display_profile").toggle();
	});	
	$("#today_appointmentt").click(function(){
		$("#today_appointment").show();
		$("#pre_appointment").hide();
	});	
	$("#pre_appointmentt").click(function(){
		$("#today_appointment").hide();
		$("#pre_appointment").show();
	});	
	$("#update_schedule_button").click(function(){
		$("#update_schedule").toggle();
		$("#display_schedule").toggle();
	});
	$("#cancel_schedule_button").click(function(){
		$("#update_schedule").toggle();
		$("#display_schedule").toggle();
	});
	$("#update_description_button").click(function(){
		$("#update_description").toggle();
		$("#display_description").toggle();
	});
	$("#cancel_description_button").click(function(){
		$("#update_description").toggle();
		$("#display_description").toggle();
	});
	$("#DoctorList_header").click(function(){
		
		$("#DoctorList").show();
		$("#PatientList").hide();
		
	});
	$("#PatientList_header").click(function(){
		
		$("#DoctorList").hide();
		$("#PatientList").show();
		
	});
	$("#medical_history_header").click(function(){
	
		$("#medical_history").show();
		$("#patient_prescription").hide();
		$("#self_description").hide();
	});
	$("#patient_prescription_header").click(function(){
		
		$("#medical_history").hide();
		$("#patient_prescription").show();
		$("#self_description").hide();
	});
	$("#self_description_header").click(function(){
	
		$("#medical_history").hide();
		$("#patient_prescription").hide();
		$("#self_description").show();
	});
$("#new_plan_click").click(function(){
		
		$("#new_plan_click").hide();
		$("#newPlan").show();
	});
	
	$("#new_plan_cancel").click(function(){
		
		$("#new_plan_click").show();
		$("#newPlan").hide();
	});
	$("#new_history_button").click(function(){
		
		$("#new_history_div").show();
		$("#new_history_button").hide();
	});
	$("#new_history_cancel").click(function(){
		
		$("#new_history_button").show();
		$("#new_history_div").hide();
	});
	
	
	$("#nav").mouseenter(function(){
		$(".notification").show();
	});
	$("#nav").mouseleave(function(){
		$(".notification").hide();
	});

	$('#validmobile').click(function() {
		 var intsOnly =/^\d{10}$/,
 		
 	    stri = $('#num').val();
 	if(intsOnly.test(stri)) {
 	    
 	}
 	else{
 		alert('please enter valid 10 digit mobile number');  
 	}
 		
 	 
 });
	/*$('#valid').click(function() {
		 var intsOnly =/^\d{10}$/,
		
	    stri = $('#num').val();
	if(intsOnly.test(stri)) {
	    
	}
	else{
		alert('please enter only number');  
	}
		
	 
}); */
	/*$('#validation').click(function() {
	        var sEmail = $('#emailtxt').val();
	        if ($.trim(sEmail).length == 0) {
	            alert('Please enter valid email address');
	            e.preventDefault();
	        }
	        if (validateEmail(sEmail)) {
	            //alert('Email is valid');
	        }
	        else {
	            alert('Invalid Email Address');
	            e.preventDefault();
	        }
	        
	        

	        	//var intsOnly =/^\-?([0-9]+(\.[0-9]+)?|Infinity)$/,
	    		var intsOnly =/^\d{10}$/,
	    		
	    	    stri = $('#num').val();
	    	if(intsOnly.test(stri)) {
	    	    
	    	}
	    	else{
	    		alert('please enter valid 10 digit mobile number');  
	    	}
	    		
	    	 
	    });
	*/
	 
});
/*function validateEmail() {
    var sEmail=document.getElementById("emailtxt");
	var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(sEmail)) {
        return true;
    }
    else {
    	alert('llllllInvalid Email Address');
    	return false;
    }
}
function validEmail() {
    var Email=document.getElementById("ppemail");
	var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(Email)) {
        return true;
    }
    else {
    	alert('ppppppppInvalid Email Address');
    	return false;
    }
}*/
function validEmail()
{
var x=document.forms["myForm"]["username"].value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}
function validateEmail()
{
var x=document.forms["myForm"]["pemail"].value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}