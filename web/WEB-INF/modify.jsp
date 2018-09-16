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
                <h1 class="page-header">수정</h1>
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
                        영화를 수정하세요.
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form action="/modify" method="post" class="form" >
                                    <input hidden name="page" value="${page}">
                                    <input hidden name="mno" value="${movie.mno}">
                                    <div class="form-group">
                                        <label>영화</label>
                                        <input class="form-control" type="text" name="mtitle" value="${movie.mtitle}">
                                    </div>
                                    <div class="form-group">
                                        <label>글쓴이</label>
                                        <input class="form-control" type="text" name="userid" value="${movie.userid}">
                                    </div>
                                    <div class="form-group">
                                        <label>제목</label>
                                        <input class="form-control" type="text" name="rtitle" value="${movie.rtitle}">
                                    </div>
                                    <div class="form-group">
                                        <label>내용</label>
                                        <input class="form-control" type="text" name="cmt" value="${movie.cmt}">
                                    </div>
                                    <div class="form-group">
                                        <label>이미지</label>
                                        <input class="form-control" type="text" name="mimg" value="${movie.mimg}">
                                    </div>
                                    <button type="submit" onclick="alert('수정되었어요!')" class="btn btn-primary">수정</button>
                                    <%--<a href="read?page=${curPage}&mno=${movie.mno}"> ${movie.rtitle}</a>--%>
                                    <%--<a href="/remove" methods="post"><input type="button" class="btn btn-default" value="삭제"></a>--%>
                                    <%--<a href="/list"><input type="button" class="btn btn-default" value="목록으로"></a>--%>
                                </form>
                                <form action="/remove" method="post" class="form" >
                                    <input hidden name="mno" value="${mno}">
                                    <button class="btn btn-danger" onclick="alert('삭제되었어요!')" >삭제</button>
                                </form>

                                    <a href="/list?page=${page}"><button  class="btn btn-warning">목록으로</button></a>

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


<script type="text/javascript">

    function goBack() {
        window.history.go(-2);
    }
</script>

<%@include file="includes/footer.jsp"%>
