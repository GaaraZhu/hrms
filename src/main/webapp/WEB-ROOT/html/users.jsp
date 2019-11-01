<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/user.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectUserVal">
				<div class="row">
					<div class="form-group inputselect col-lg-3">
						<label for="searchName">用户姓名</label> <input type="text"
							class="form-control" id="searchName" name="searchName"
						    placeholder="请输入姓名">
					</div>
					<div class="form-group inputselect col-lg-3">
                        <label for="searchAccount">用户账号</label> <input type="text"
                            class="form-control" id="searchAccount" name="searchAccount"
                            placeholder="请输入账号">
                    </div>
					<div class="form-group inputselect col-lg-3">
                        <label for="searchAuthority">用户权限</label><br/>
                        <select id="searchAuthority" name="searchAuthority" style="width: 125px;height: 32px;">
                            <option value="-1">所有用户</option>
                            <option value="0">普通用户</option>
                            <option value="1">管理员</option>
                        </select>
                    </div>
				</div>
				<div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-info btn-sm " id="addUser">
                            <span class="glyphicon glyphicon-user"></span> 新增用户
                        </button>
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-success btn-sm "
                            id="searchUsers" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm "
                            id="resetUsers">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
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
        queryUsers(1);
    </script>
</body>
