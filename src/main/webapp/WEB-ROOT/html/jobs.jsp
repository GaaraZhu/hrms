<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/job.js"></script>
	<div id="alert"></div>
	<div id="addJobList"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectJobsVal">
				<div class="row">
					<div class="form-group inputselect col-lg-2">
						<label for="name">公司</label> <input type="text"
							class="form-control  " id="searchCompany" name="searchCompany"
						    placeholder="请输入所属企业">
					</div>
					<div class="form-group inputselect col-lg-2">
						<label for="name">城市</label> <input type="text"
							class=" form-control " id="searchCity" name="searchCity"
							placeholder="请输入所在城市">
					</div>
					<div class="form-group inputselect col-lg-2">
                        <label for="name">职位名称</label> <input type="text"
                            class="form-control  " id="searchName" name="searchName"
                            placeholder="请输入职位名称">
                    </div>
                    <div class="form-group inputselect col-lg-2">
                        <label for="name">是否有效</label><br/>
                        <select id="searchActive" name="searchActive" style="width: 62px;height: 32px;">
                                <option value="true">有效</option>
                                <option value="false">无效</option>
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
					<div class="form-group inputselect col-lg-2">
                        <button type="button" class="btn btn-info btn-sm " style="margin-left: 225px" id="addJob">
                            <span class="glyphicon glyphicon-user"></span> 新增职位
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
