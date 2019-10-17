<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
HttpSession s = request.getSession(); 
%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/department.js"></script>
	<div id="alert"></div>
	<div id="addDepList"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectDepVal">
				<div class="row">
					<div class="form-group inputselect col-lg-4">
						<label for="name">部门编号</label> <input type="text"
							class="form-control  " id="searchNumber" name="searchNumber"
						    placeholder="请输入编号">
					</div>
					<div class="form-group inputselect col-lg-4">
						<label for="name">部门名称</label> <input type="text"
							class=" form-control " id="searchName" name="searchName"
							placeholder="请输入名称">
					</div>
				
					<div class="form-group inputselect col-lg-4">
						<button type="button" class="btn btn-success btn-sm "
							id="search">
							<span class="glyphicon glyphicon-search"></span> 搜索
						</button>
						
						<button type="button" class="btn btn-success btn-sm "
							id="reset">
							<span class="glyphicon glyphicon-refresh"></span> 重置
						</button>
					</div>
					<div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-info btn-sm" style="margin-left: 155px;" id="addDep">
                            <span class="glyphicon glyphicon-plus"></span> 新增部门
                        </button>
					</div>
				</div>
			</form>
			<form class="form-inline" role="form"></form>
			<div class="table-responsive " style="margin-left: 3%;">
				<table class="table table-hover tablefont">
					<tbody id="tableList"/>
				</table>
				<div style="bottom: 10%">
					<div id="paging" style="text-align: center; margin-left: 25%;">
					</div>
				</div>
			</div>
		</div>
	</div>
    <script type="text/javascript">
        queryPage(1);
    </script>
</body>
