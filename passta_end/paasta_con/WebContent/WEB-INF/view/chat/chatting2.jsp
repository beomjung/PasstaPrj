<%@page import="poly.dto.ChatJsonDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<List<ChatJsonDTO>> rList = (List<List<ChatJsonDTO>>) request.getAttribute("rList");
	String user_id = (String) session.getAttribute("user_id");
	int ListCnt = rList.size();
	int c = 0;
%>
	     	    		
<%-- <% for(List<ChatJsonDTO> pList : rList){ --%>

<% 	for(c = ListCnt; c > 0; c--) {
		for(ChatJsonDTO pDTO : rList.get(c-1)){
			if(user_id.equals(pDTO.getChat_id())) { %>
	
			<li class="message left appeared" id="chat_ul">
				<div class="avatar"></div>
				<div class="text_wrapper">
					<div class="text" style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;  margin-bottom: -8px;">
					<%=pDTO.getChat_dt() %>&nbsp;&nbsp;<%=pDTO.getChat_id()%>&nbsp;&nbsp;  <%=pDTO.getChat_contents() %>
					</div>
				</div>
			</li>
			
		<% }else {%>
			<li class="message right appeared" id="chat_ul">
				<div class="avatar"></div>
				<div class="text_wrapper">
					<div class="text" style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;  margin-bottom: -8px;">
					<%=pDTO.getChat_dt() %>&nbsp;&nbsp;<%=pDTO.getChat_id()%>&nbsp;&nbsp;  <%=pDTO.getChat_contents() %>
					</div>
				</div>
			</li>
		<%} %>
<% 	}
}  %>      			 
	        			 
<%-- 자바스크립트에서 이중 for문으로 List<List<ChatJsonDTO> rList>> 를 처리한다.  dataType: "json"
	           		그러나 유지보수면에서 model에서 새로운 jsp로 가공하여 text로 뿌려주면 효율적이기때문에 다른방법으로 구현
	           
	           $.each(result, function(index, object) {
	        		console.log("result" + index + " " + object);
	        		
	        		$.each(object, function(index, val) {
	        			console.log("result" + index + " " + val.chat_id);
	        			
	        			 let pre = "";
	     	    		
	        			 if('<%=user_id%>' == val.chat_id){
		     	    			pre += '<li class="message left appeared" id="chat_ul">';
		     	    			pre += '<div class="avatar"></div>';
		     	    			pre += '<div class="text_wrapper">';
		     	    			pre += '<div class="text">'+ val.chat_dt + '&nbsp&nbsp&nbsp&nbsp' + val.chat_contents + '</div>';
		     	    			pre += '</div>';
		     	    			pre += '</li>';
	     	    		}else{
	     	    			pre += '<li class="message right appeared" id="chat_ul">';
	     	    			pre += '<div class="avatar"></div>';
	     	    			pre += '<div class="text_wrapper">';
	     	    			pre += '<div class="text">'+ val.chat_dt + '&nbsp&nbsp&nbsp&nbsp' + val.chat_contents + '</div>';
	     	    			pre += '</div>';
	     	    			pre += '</li>';
	     	    		}
	     	    		
	     	    		$(".messages").append(pre);
	        		
	        		});
	        		
	        	}); 
	        	
	        	 console.log("data : "+ data);
	        	 console.log("data.get[0] : "+ data[0][0]['chat_contents']); --%>