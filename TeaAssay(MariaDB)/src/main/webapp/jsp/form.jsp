<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>茶の湯随想</title>
<link rel="stylesheet" href="css/another.css">
<script src="tea and program.js"></script>
<title>Insert title here</title>
</head>

<body id="form_body">
  <header>
    <h1>お問い合わせ</h1>
  </header>
  <main class="info_main">
    <section>
      <h2>お問い合わせフォーム</h2>

      <form action="FormServlet" method="post">
        <p>
          名前:<input type="text" name="name" value="<c:out value="${form.getName()}" />">
        </p>
        <p>
          メールアドレス:<input type="email" name="email" value="<c:out value="${form.getEmail()}" />">
        </p>
        <p>
          メールアドレス(確認用):<input type="email" name="check_email" value="<c:out value="${form.getEmail()}" />">
        </p>
        <p>
          件名:<input type="text" name="title" value="<c:out value="${form.getTitle()}" />">
        </p>
        <p>お問い合わせ内容:</p>
        <p>
          <textarea name="textarea" width="400" width="300"><c:out value="${form.getTextArea()}" /></textarea>
        </p>
        <p>
          <input type="submit" name="submit">
        </p>
      </form>
    </section>
  </main>
  <footer>
    <div class="footer">Posted by T. Shiotani</div>
  </footer>


</body>
</html>