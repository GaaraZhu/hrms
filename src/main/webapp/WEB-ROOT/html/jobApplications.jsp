<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/jobApplication.js"></script>
	<div id="alert"></div>
	<div id="addJobApplicationList"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectJobApplicationsVal">
				<div class="row">
					<div class="form-group inputselect">
						<label for="searchCompany">应聘企业</label> <input type="text"
							class="form-control" id="searchCompany" name="searchCompany"
						    placeholder="企业">
					</div>
					<div class="form-group inputselect">
						<label for="searchCity">应聘城市</label> <input type="text"
							class=" form-control" id="searchCity" name="searchCity"
							placeholder="城市">
					</div>
					<div class="form-group inputselect">
                        <label for="searchJobName">应聘职位</label> <input type="text"
                            class="form-control" id="searchJobName" name="searchJobName"
                            placeholder="职位名称">
                    </div>
                    <div class="form-group inputselect" style="margin-left: 63px;">
                        <label for="searchCandidate">求职者</label> <input type="text"
                            class="form-control" id="searchCandidate" name="searchCandidate"
                            placeholder="姓名或手机号">
                    </div>

                    <div class="form-group inputselect">
                        <label for="searchStatus">处理状态</label>
                        <select id="searchStatus" name="searchStatus" style="width: 170px;height: 32px;">
                            <option value="NEW">未处理</option>
                            <option value="FAILED">申请失败</option>
                            <option value="WAITING_INTERVIEW">等待面试</option>
                            <option value="INTERVIEWED">完成面试</option>
                            <option value="INTERVIEW_PASSED">面试通过</option>
                            <option value="INTERVIEW_FAILED">面试失败</option>
                            <option value="ON_BOARDED">入职</option>
                            <option value="ON_BOARDED_ONE_ONE_MONTH">入职满1月</option>
                            <option value="ON_BOARDED_ONE_THREE_MONTH">入职满3月</option>
                            <option value="ON_BOARDED_ONE_SIX_MONTH">入职满6月</option>
                            <option value="RESIGNED">离职</option>
                        </select>
                    </div>

                    <div class="form-group inputselect" style="margin-left: 41px;">
                        <label for="searchHasReferee">有无推荐人</label>
                        <select id="searchHasReferee" name="searchHasReferee" style="width: 170px;height: 32px;">
                            <option value="1">有</option>
                            <option value="0">无</option>
                        </select>
                    </div>
                    <div class="form-group inputselect" style="margin-left: 63px;">
                        <label for="searchReferee">推荐人</label> <input type="text"
                            class="form-control" id="searchReferee" name="searchReferee"
                            placeholder="姓名或手机号">
                    </div>

                    <div class="form-group inputselect">
                        <label for="searchFromTime">求职时间</label> <input type="text"
                            class="form-control" id="searchFromTime" name="searchFromTime"
                            placeholder="年年年年-月月-日日"> -
                         <input type="text"
                             class="form-control" id="searchToTime" name="searchToTime"
                             placeholder="年年年年-月月-日日">
                    </div>

                    <div class="form-group inputselect" style="padding-left: 600px;" >
                        <button type="button" class="btn btn-success btn-sm"
                            id="search">
                            <span class="glyphicon glyphicon-user"></span> 搜索
                        </button>

                        <button type="button" class="btn btn-success btn-sm"
                            id="reset">
                            <span class="glyphicon glyphicon-user"></span> 重置
                        </button>

                        <button type="button" class="btn btn-info btn-sm" id="addJobApplication">
                            <span class="glyphicon glyphicon-user"></span> 新增求职记录
                        </button>
                    </div>
				</div>
			</form>
			<form class="form-inline" role="form"></form>
			<div class="table-responsive" style="margin-left: 3%;">
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
