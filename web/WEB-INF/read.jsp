<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-12
  Time: 오후 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp"%>

<style>
    .poster {
        width:300px;
    }
</style>
<style>
    .panel-title{
        font-size: smaller;
    }
</style>


<div id="wrapper">



    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">영화 리뷰</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

        <div class="row">
            <div class="col-lg-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h1>${movie.mtitle}</h1>
                    </div>
                    <div class="panel-body">
                        <div class="panel-group" id="accordion">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h5 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">게시글 정보</a>
                                    </h5>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in">
                                    <div style="font-size: smaller" class="panel-body">
                                        글쓴이 : ${movie.userid} / 작성시간 : ${movie.regdate} / 게시물번호 : ${movie.mno}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">


                        <p>${movie.cmt}</p>
                    </div>
                    <div class="panel-footer">
                        <img src="${movie.mimg}" class="poster">
                    </div>
                </div>
            </div>

        </div>
        <!-- /.row -->
        <button type="button" onclick="location.href='modify?page=${page}&mno=${movie.mno}'" class="btn btn-primary">수정/삭제</button>
        <a href="/list?page=${page}"><button  class="btn btn-warning">목록으로</button></a>
    </div>

</div>




<%@include file="includes/footer.jsp"%>