<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%--    meta 태그의 http-equiv 속성은 content 속성에 명시된 값에 대한 HTTP 헤더를 제공한다.--%>
<%--    만약 http-equiv 속성이 명시되어 있다면, 반드시 content 속성도 함께 명시되어야 한다.--%>
<%--    속성값 content-type : 해당 문서의 문자 인코딩 방식을 명시함.--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--form 태그의 enctype속성은 폼 데이터가 서버로 제출될 때 해당 데이터가 인코딩되는 방법을 명시한다.--%>
<%--이 속성은 method 속성값이 post인 경우에만 사용할 수 있다.--%>

<%--속성값 : multipart/form-data--%>
<%--- 모든 문자를 인코딩하지 않음을 명시함.--%>
<%--- 이 방식은 form 요소가 파일이나 이미지를 서버로 전송할 때 주로 사용함    --%>
<form action = "/sample/exUploadPost" method="post"
      enctype="multipart/form-data">
    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="file" name="files">
    </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="submit">
        </div>
</form>
</body>
</html>