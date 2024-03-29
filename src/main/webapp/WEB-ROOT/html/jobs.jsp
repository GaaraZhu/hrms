<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/jobs.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectJobsVal">
				<div class="row">
					<div class="form-group inputselect col-lg-3">
						<label for="searchCompany">公司</label> <input type="text"
							class="form-control" id="searchCompany" name="searchCompany"
						    placeholder="请输入所属企业">
					</div>
					<div class="form-group inputselect col-lg-3">
						<label for="searchCity">城市</label> <input type="text"
							class=" form-control" id="searchCity" name="searchCity"
							placeholder="请输入所在城市">
					</div>
					<div class="form-group inputselect col-lg-3">
                        <label for="searchDistrict">城区</label> <input type="text"
                            class=" form-control" id="searchDistrict" name="searchDistrict"
                            placeholder="请输入所在城区">
                    </div>
					<div class="form-group inputselect col-lg-3">
                        <label for="searchName">职位</label> <input type="text"
                            class="form-control" id="searchName" name="searchName"
                            placeholder="请输入职位名称">
                    </div>
                    <div class="form-group inputselect col-lg-3">
                        <label for="searchActive">有效</label>
                        <select id="searchActive" name="searchActive" style="width: 172px;height: 32px;">
                                <option value="true">有效</option>
                                <option value="false">无效</option>
                        </select>
                    </div>
                </div>
                <div class="row">
					<div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-info btn-sm" id="addJob">
                            <span class="glyphicon glyphicon-plus"></span> 新增职位
                        </button>
                        <button type="button" class="btn btn-info btn-sm" id="addJobApplication">
                            <span class="glyphicon glyphicon-user"></span> 新增求职
                        </button>
                        <button type="button" class="btn btn-info btn-sm" id="addJobQuota">
                            <span class="glyphicon glyphicon-user"></span> 新增指标
                        </button>
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-success btn-sm"
                            id="searchJobs" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm"
                            id="resetJobs">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
				</div>
			</form>
            <div class="table-responsive" style="margin-left: 3%;">
                <table class="table table-hover tablefont">
                    <tbody id="tableList"/>
                </table>
            </div>
            <div style="bottom: 10%">
                <div id="paging" style="text-align: center; margin-left: 32%;">
                </div>
            </div>
		</div>
	</div>

	<script type="text/javascript">
	    queryJobs(1);
	</script>
</body>
