    var pageSize = 8;
    var wto;

    // personalReport
	$("#resetPersonalReport").click(
        function() {
            $('#fromDate').datepicker("setDate", new Date());
            $('#toDate').datepicker("setDate", new Date());
            $("#searchName").val("");
            $("#searchType").val("WEEKLY");
        }
	);

	$("#searchPersonalReport").click(
        function() {
            queryPersonalReport(1);
	    }
	);

    function queryPersonalReport(cp) {
        fromDate = $("#searchFromDate").val();
        toDate = $("#searchToDate").val();
        name = $("#searchName").val();
        type = $("#searchType").val();
        $.ajax({
            url : "applicationReports/personalReport",
            type : "GET",
            async: true,
            data : "fromDate=" + (fromDate?fromDate:'') + "&toDate=" + (toDate?toDate:'') + "&name=" + name + "&type=" + type + "&pageSize=" + pageSize + "&currentPage=" + cp,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initPersonalReportTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initPersonalReportTable(data, currentPage) {
        $.lTable('#personalReportTableList',
        {
            data : data.results,
            title : [
                    "id",
                    "name",
                    "newApplied",
                    "newInterviewed",
                    "newOnboarded",
                    "fromDate",
                    "toDate"],
            name : ["ID", "姓名", "新增申请", "新增面试", "新增入职", "开始日期", "结束日期"],
            tid : "id",
            checkBox : "id"
        });
        $.lPaging('#paging',
        {
            pageNumber : currentPage,
            totalPage : data.totalPages,
            countSize : pageSize,
            count : data.totalElements,
            inputSearch : false,
            onPageChange : function(currentPage) {
                queryPersonalReport(currentPage);
            }
        });
    }

    // companyReport
    $("#resetCompanyReport").click(
        function() {
            $("#searchCompany").val("");
            $("#searchJobName").val("");
            $('#searchMonth').datepicker("setDate", new Date());
        }
    );

    $("#searchCompanyReport").click(
        function() {
            queryCompanyReport(1);
        }
    );

    function queryCompanyReport(cp) {
        company = $("#searchCompany").val();
        month = $("#searchMonth").val();
        $.ajax({
            url : "applicationReports/companyReport",
            type : "GET",
            async: true,
            data : "month=" + (month?month:'') + "&company=" + company + "&pageSize=" + pageSize + "&currentPage=" + cp,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initCompanyReportTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initCompanyReportTable(data, currentPage) {
        $.lTable('#companyReportTableList',
        {
            data : data,
            title : [
                    "company",
                    "month",
                    "quota",
                    "completePercentage",
                    "dailyQuota",
                    "dailyCompletePercentage",
                    "totalOnboarded",
                    "totalResigned",
                    "netOnboarded"],
            name : ["企业", "月份", "整体指标", "完成情况", "每日指标", "每日完成情况", "累计入职", "累计离职", "累计净入"]
        });
        $.lPaging('#paging',
        {
            pageNumber : currentPage,
            totalPage : data.totalPages,
            countSize : pageSize,
            count : data.totalElements,
            inputSearch : false,
            onPageChange : function(currentPage) {
                queryCompanyReport(currentPage);
            }
        });
    }

    // successApplicants
    $("#searchSuccessApplicantsReport").click(
        function() {
            querySuccessApplicantsReport();
        }
    );

    function querySuccessApplicantsReport() {
        fromDate = $("#searchSuccessApplicantsFromDate").val();
        toDate = $("#searchSuccessApplicantsToDate").val();
        $.ajax({
            url : "applicationReports/successApplicantsDistribution",
            type : "GET",
            async: true,
            data : "fromDate=" + (fromDate?fromDate:'') + "&toDate=" + (toDate?toDate:''),
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                var chart = new CanvasJS.Chart("chartContainer", {
                	theme: "light2",
                	exportEnabled: true,
                	animationEnabled: true,
                	title: {
                		text: "成功求职分布"
                	},
                	data: [{
                		type: "pie",
                		startAngle: 25,
                		toolTipContent: "<b>{label}</b>: {y}%",
                		showInLegend: "true",
                		legendText: "{label}",
                		indexLabelFontSize: 16,
                		indexLabel: "{label} - {y}%",
                		dataPoints: data.map(pair=>({y: pair.value, label: pair.key}))
                	}]
                });
                chart.render();
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }