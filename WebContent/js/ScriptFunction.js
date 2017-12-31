function countBMI()
{
  var xmlhttp;
  var hg=document.getElementById('height').value;
  var wg=document.getElementById('weight').value;
  var url="/HealthOnlineProject/CountBMI?height="+hg+"&weight="+wg;
  if (window.XMLHttpRequest)
  {
      xmlhttp=new XMLHttpRequest();
  }
  else
  {
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
    	  document.getElementById("displaybmi").value=xmlhttp.responseText;
      }
  };

  xmlhttp.open("GET", url, true);
  xmlhttp.send();
}

	function checkEmail()
    {
      var xmlhttp;
      var config=document.getElementById('email').value;
      var url="/HealthOnlineProject/isEmailExist?id="+config;
      if (window.XMLHttpRequest)
      {
          xmlhttp=new XMLHttpRequest();
      }
      else
      {
          xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlhttp.onreadystatechange=function()
      {
          if (xmlhttp.readyState==4 && xmlhttp.status==200)
          {
          	
          		document.getElementById("emailAlert").innerHTML=xmlhttp.responseText;
             	if(xmlhttp.responseText.length!=0){ 
             		document.getElementById("email").value="";
            		 }
          }
      }

      xmlhttp.open("GET", url, true);
      xmlhttp.send();
}
function getAmount()
  {
    var xmlhttp;
    var planId=document.getElementById('planId').value;
    var url="/HealthOnlineProject/GetAmoutForPlan?id="+planId;
    if (window.XMLHttpRequest)
    {
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("amount").value=xmlhttp.responseText;
        }
    };

    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
