<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
입력 : 
<textarea rows="10" cols="200" id="input1"></textarea><br>

출력 묶음 조건 : 
<input id="cond"><br>
<button id="btn">출력</button><br>
<br>
몫 : <span id="resultQ"></span><br><br>
나머지 : <span id="resultM"></span><br>

<script>
$(document).ready(function(){
    $("#btn").click(function(){
    	
    	var input = $("#input1").get(0).value;
    	var cond = $("#cond").get(0).value;
        
        $.ajax({
		    	  type: "POST",
		    	  url: "/calc",
		    	  data: {
		    		  input : input,
		    		  cond : cond,
		    	  },
		 		  dataType: 'Json',
		    	  success: function(re){
		    		
		    		$("#resultQ").get(0).innerText = re.resultQ;
		    		$("#resultM").get(0).innerText = re.resultM;
		    		
		    	  },
    	}); 
    });
});
</script>


</body>
</html>
