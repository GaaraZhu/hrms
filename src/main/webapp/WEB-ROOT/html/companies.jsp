<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession s = request.getSession(); 
%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/companies.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectCompanyVal">
				<div class="row">
					<div class="form-group inputselect col-lg-4">
						<label for="searchName">公司名称</label> <input type="text"
							class=" form-control" id="searchName" name="searchName"
							placeholder="请输入名称">
					</div>
					<div class="form-group inputselect col-lg-4">
                        <label for="searchCity">所在城市</label> <input type="text"
                            class="form-control" id="searchCity" name="searchCity"
                            placeholder="请输入城市">
                    </div>
				</div>
				<div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-info btn-sm" id="addCompany">
                            <span class="glyphicon glyphicon-plus"></span> 新增公司
                        </button>
                        <button type="button" class="btn btn-info btn-sm" id="addBranch">
                            <span class="glyphicon glyphicon-plus"></span> 新增门店
                        </button>
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-success btn-sm "
                            id="searchCompanies" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>

                        <button type="button" class="btn btn-success btn-sm "
                            id="resetCompanies">
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
        queryCompanies(1);
    </script>
</body>
