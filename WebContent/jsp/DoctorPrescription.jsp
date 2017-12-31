<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="DoctorHeader.jsp"></jsp:include>

      <div class="clr"></div>
    </div>
  </div>
  <!--Header End -->
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2>Prescription</h2>
          <div class="clr"></div>
          
		  
           <div class="post_content">
			<br /><form action="/HealthOnlineProject/DoctorPrescription" method="post">
			<table align="center" width="85%" class="plain_text">
				
				<tr>
					<td>Patient Name<span style=" font-size:larger; color: red;">*</span></td>
					<td><select name="pname"  style="border-color:bl ; border-width: 1px">
				 
				<c:forEach var="n" items="${p }">
					<option value="${n.id }" ><c:out value="${n.name}"  /> </option>
				</c:forEach>
			</select></td>
					
				</tr>
				
				<tr>
					<td>Symptom<span style=" font-size:larger; color: red;">*</span></td>
					<td><input type="text" name="symptom" required="required"   > </td>
									
				</tr>
				<tr>
					<td>Diagnosis</td>
					<td><input type="text" name="diagnosis" > </td>
									
				</tr>
				<tr>
					<td>Comment</td>
					<td><textarea name="comment" cols="30px" style="border-color:bl ; border-width: 1px"></textarea> </td>
									
				</tr>
			</table>
		         
        
			
		   
          <div class="clr"></div>
        <br/>
			<table  width="70%" align="center" border="1" class="tablecontent">
          <tr ><th>
           Medicine</th>
            <th>Dosage</th>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine1" ></td>
            <td>           
            <input type="text" size="20px" name="dosage1"  ></td>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine2"></td>
            <td>           
            <input type="text" size="20px" name="dosage2" ></td>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine3"></td>
            <td>           
            <input type="text" size="20px" name="dosage3"></td>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine4"></td>
            <td>           
            <input type="text" size="20px" name="dosage4"></td>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine5" ></td>
            <td>           
            <input type="text" size="20px" name="dosage5" ></td>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine6" ></td>
            <td>           
            <input type="text" size="20px" name="dosage6" ></td>
            </tr><tr><td>           
            <input type="text" size="20px" name="medicine7" ></td>
            <td>           
            <input type="text" size="20px" name="dosage7" ></td>
            </tr>
            </table>
            <br/><center><input type="submit" value="Submit" class="button">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="Reset" class="button"></center>
            </form>
            <br/><br/>
         <div style="color: red;" >Fields which have * all are Mandatory.</div>
		   </div>
          <div class="clr"></div></div>
        </div>

<jsp:include page="DoctorSidebar.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>