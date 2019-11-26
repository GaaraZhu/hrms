<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
HttpSession s = request.getSession(); 
%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/branch.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectBranchVal">
				<div class="row">
					<div class="form-group inputselect col-lg-4">
						<label for="searchCompany">公司名称</label> <input type="text"
							class=" form-control" id="searchCompany" name="searchCompany"
							placeholder="请输入公司名称">
					</div>
					<div class="form-group inputselect col-lg-4">
                        <label for="searchBranch">门店名称</label> <input type="text"
                            class="form-control" id="searchBranch" name="searchBranch"
                            placeholder="请输入经理">
                    </div>
				</div>
				<div class="row">
                    <div class="form-group inputselect col-lg-4">
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-success btn-sm "
                            id="searchBranches" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>

                        <button type="button" class="btn btn-success btn-sm "
                            id="resetBranch">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
                </div>
			</form>
			<div class="table-responsive " style="margin-left: 3%;">
				<table class="table table-hover tablefont">
					<tbody id="tableList"/>
				</table>
				<div style="bottom: 10%">
					<div id="paging" style="text-align: center; margin-left: 32%;">
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
        queryBranches(1);
    </script>
</body>
