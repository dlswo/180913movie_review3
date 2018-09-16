<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-12
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">등록</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <style>
            .form {
                display: inline;
            }
        </style>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        영화를 등록하세요.
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form method="post" action="/write" class="form">
                                    <div class="form-group">
                                        <label>영화</label>
                                        <input class="form-control" type="text" name="mtitle" value="영화제목을 넣으세오">
                                    </div>
                                    <div class="form-group">
                                        <label>글쓴이</label>
                                        <input class="form-control" type="text" name="userid" value="글쓴이를 넣으세오">
                                    </div>
                                    <div class="form-group">
                                        <label>제목</label>
                                        <input class="form-control" type="text" name="rtitle" value="제목을 넣으세오">
                                    </div>
                                    <div class="form-group">
                                        <label>내용</label>
                                        <textarea class="form-control" type="text" name="cmt"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>이미지</label>
                                        <input class="form-control" type="text" name="mimg" value="이미지 주소를 넣으세오">
                                    </div>
                                    <button type="submit" class="btn btn-primary" onclick="alert('등록되었어요!')">등록</button>
                                </form>
                                <a href="/list?page=${page}"><button class="btn btn-danger">취소</button></a>
                                    <%--<a href="/list"> <button type="reset" class="btn btn-default">취소</button></a>--%>
                            </div>
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@include file="includes/footer.jsp"%>