<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/jobQuota.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectJobQuotasVal">
				<div class="row">
					<div class="form-group inputselect">
						<label for="searchCompany">所属企业</label> <input type="text"
							class="form-control" id="searchCompany" name="searchCompany"
						    placeholder="所属企业">
					</div>
					<div class="form-group inputselect">
						<label for="searchCity">所在城市</label> <input type="text"
							class=" form-control" id="searchCity" name="searchCity"
							placeholder="所在城市">
					</div>
					<div class="form-group inputselect">
                        <label for="searchJobName">职位名称</label> <input type="text"
                            class="form-control" id="searchJobName" name="searchJobName"
                            placeholder="职位名称">
                    </div>
                    <div class="form-group inputselect">
                        <label for="searchMonth">指标月份</label> <input type="text"
                            class="form-control" id="searchMonth" name="searchMonth"
                            readonly="readonly">
                    </div>

                    <div class="form-group inputselect" style="margin-left: 310px;">
                        <button type="button" class="btn btn-success btn-sm" style="margin-left: 130px;" id="searchJobQuotas">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm" id="resetJobQuotas">
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
	    queryJobQuotas(1);
	    $('#searchMonth').MonthPicker({
            Button: false,
            MonthFormat: 'yy-mm',
            i18n: {
                year: '年份: ',
                prevYear: '前一年',
                nextYear: '后一年',
                next12Years: '往后12年',
                prev12Years: '往前12年',
                nextLabel: '后',
                prevLabel: '前',
                buttonText: '打开月份选择器',
                jumpYears: '挑选年份',
                backTo: '回到',
                months: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12']
            }
        });
	</script>
</body>
