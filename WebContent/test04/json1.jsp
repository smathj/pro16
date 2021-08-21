<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(function() {
        $("#checkJson").click(function() {
        var jsonStr  = '{"name": ["홍길동", "이순신", "임꺽정"] }'; // 문자열
        
        console.log("jsonStr");
        console.log(typeof jsonStr);				// string
        console.log(jsonStr);
        
        var jsonInfo = JSON.parse(jsonStr);			// 문자열을 객체로 휘리릭
        
        console.log("jsonInfo");
        console.log(typeof jsonInfo);				// object
        console.log(jsonInfo);
        
        var output ="회원 이름<br>";
 			output += "=======<br>";
        for(var i in jsonInfo.name) {
            output += jsonInfo.name[i]+"<br>";
        }
        $("#output").html(output);
      });
    });
        
</script>
  </head>
  <body>
    <a id="checkJson" style="cursor:pointer">출력</a><br><br>
    <div id="output"></div>
  </body>
</html>
