<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
HttpSession s = request.getSession();
%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/candidate.js"></script>
	<div id="alert"></div>
	<div id="addCandidatePage"></div>
	<div id="uploadCandidatesPage"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectCandidatesVal">
				<div class="row">
					<div class="form-group inputselect col-lg-3">
						<label for="name">姓名</label> <input type="text"
							class="form-control" id="searchName" name="searchName"
						    placeholder="请输入姓名">
					</div>
					<div class="form-group inputselect col-lg-3">
						<label for="name">电话</label> <input type="text"
							class=" form-control" id="searchPhone" name="searchPhone"
							placeholder="请输入电话">
					</div>
					<div class="form-group inputselect col-lg-3">
                        <label for="name">城市</label> <input type="text"
                            class="form-control" id="searchCity" name="searchCity"
                            placeholder="请输入城市">
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
                    <div class="form-group inputselect col-lg-4" style="left: 150px;">
                        <button type="button" class="btn btn-info btn-sm" id="uploadCandidates">
                            <span class="glyphicon glyphicon-user"></span> 上传候选人
                        </button>
                        <button type="button" class="btn btn-info btn-sm" id="addCandidate">
                            <span class="glyphicon glyphicon-user"></span> 新增候选人
                        </button>
                    </div>
				</div>
			</form>
			<form class="form-inline" role="form"></form>
			<div class="table-responsive " style="margin-left: 3%;">
				<table class="table table-hover tablefont">
					<tbody id="tableList"/>
				</table>
			</div>
			<div style="bottom: 10%">
                <div id="paging" style="text-align: center; margin-left: 25%;">
                </div>
            </div>
		</div>
	</div>
    <script type="text/javascript">
        queryPage(1);
    </script>
</body>
