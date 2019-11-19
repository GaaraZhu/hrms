<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/applicationReport.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
		<form class="form-inline" role="form" id="selectCompanyReportVal">
                <div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchCompany">所属企业</label>
                        <input type="text" class="form-control" id="searchCompany" name="searchCompany" placeholder="所属企业">
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchMonth">报表月份</label>
                        <input type="text" class="form-control" id="searchMonth" name="searchMonth" placeholder="报表月份" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group inputselect col-lg-4"></div>
                    <div class="form-group inputselect">
                        <button type="button" class="btn btn-success btn-sm " id="searchCompanyReport" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm " id="resetCompanyReport">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
                </div>
            </form>
			<div class="table-responsive " style="margin-left: 3%;">
				<table class="table table-hover tablefont">
					<tbody id="companyReportTableList"/>
				</table>
				<div style="bottom: 10%">
					<div id="paging" style="text-align: center; margin-left: 32%;">
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	    queryCompanyReport(1);
	    $(function () {
            $('#searchMonth').datepicker({dateFormat: 'yy-mm', changeYear: true});
        });
	</script>
</body>
