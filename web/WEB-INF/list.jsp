<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-12
  Time: 오후 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>
<%@ page errorPage="/error.jsp" %>


<div id="page-wrapper">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Movie Review</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>글번호</th>
                            <th>영화</th>
                            <th>제목</th>
                            <th>글쓴이</th>
                            <th>시간</th>
                            <th>조회수</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${list}" var="movie">
                            <tr>
                                <td>${movie.mno}</td>
                                <td>${movie.mtitle}</td>
                                <td><a href="read?page=${curPage}&mno=${movie.mno}"> ${movie.rtitle}</a></td>
                                <td>${movie.userid}</td>
                                <td>${movie.regdate}</td>
                                <td>${movie.views}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                    <c:if test="${minPage != 1}">
                        <a href="/list?page=${minPage-1}">
                            <button class="btn btn-default"><</button>
                        </a>
                    </c:if>
                    <c:forEach var="pagenum" begin="${minPage}" end="${maxPage}" step="1">

                        <c:choose>
                            <c:when test="${pagenum eq curPage}">
                                <c:set var="str" value="active"/>
                            </c:when>
                            <c:when test="${pagenum ne curPage}">
                                <c:set var="str" value=""/>
                            </c:when>
                        </c:choose>
                        <a href="/list?page=${pagenum}">
                            <button class="btn btn-default ${str}">${pagenum}</button>
                        </a>
                    </c:forEach>
                    <c:if test="${maxPage != lastPage}">
                        <a href="/list?page=${maxPage+1}">
                            <button class="btn btn-default">></button>
                        </a>
                    </c:if>
                    <form action="/write" method="get">
                        <button class="btn btn-primary btn-lg btn-block">등록</button>
                    </form>
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


<%@include file="includes/footer.jsp" %>