<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/user.js"></script>
	<div id="alert"></div>
	<div id="addUserList"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectUserVal">
				<div class="row">
					<div class="form-group inputselect col-lg-4">
						<label for="name">用户姓名</label> <input type="text"
							class="form-control" id="name" name="name"
						    placeholder="请输入姓名">
					</div>
					<div class="form-group inputselect col-lg-2">
                        <label for="name">用户权限</label><br/>
                        <select id="authority" name="authority" style="width: 62px;height: 32px;">
                                <option value="0">普通用户</option>
                                <option value="1">管理员</option>
                        </select>
                    </div>
				
					<div class="form-group inputselect col-lg-4">
						<button type="button" class="btn btn-success btn-sm "
							id="search">
							<span class="glyphicon glyphicon-user"></span> 搜索
						</button>
						
						<button type="button" class="btn btn-success btn-sm "
							id="reset">
							<span class="glyphicon glyphicon-user"></span> 重置
						</button>
					</div>
					<div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-info btn-sm " id="addUser">
                            <span class="glyphicon glyphicon-user"></span> 新增用户
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
