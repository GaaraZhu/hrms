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

    // branch Report
    $("#resetBranchReport").click(
        function() {
            $('#month').datepicker("setDate", new Date());
            $("#company").val("");
            $("#jobName").val("");
        }
    );

    $("#searchBranchReport").click(
        function() {
            var errorMessage='';
            if($("#month").val()==''){
                errorMessage="请选择报表月份";
            } else if($("#company").val()==''){
                errorMessage="请输入公司名称";
            } else if($("#jobName").val()==''){
                errorMessage="请输入职位名称";
            }
            if(errorMessage!='') {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text(errorMessage);
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 return;
            }
            queryBranchReport(1);
        }
    );

    function queryBranchReport(cp) {
        month = $("#month").val();
        company = $("#company").val();
        jobName = $("#jobName").val();
        $.ajax({
            url : "applicationReports/branch",
            type : "GET",
            async: true,
            data : "month=" + month + "&company=" + company + "&jobName=" + jobName,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initBranchReportTable(data);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initBranchReportTable(data) {
        $.lTable('#branchReportTableList',
        {
            data : data,
            title : [
                    "company",
                    "district",
                    "branch",
                    "onboard",
                    "resign",
                    "onboard1st10Ds",
                    "resign1st10Ds",
                    "onboardD1",
                    "resignD1",
                    "onboardD2",
                    "resignD2",
                    "onboardD3",
                    "resignD3",
                    "onboardD4",
                    "resignD4",
                    "onboardD5",
                    "resignD5",
                    "onboardD6",
                    "resignD6",
                    "onboardD7",
                    "resignD7",
                    "onboardD8",
                    "resignD8",
                    "onboardD9",
                    "resignD9",
                    "onboardD10",
                    "resignD10",
                    "onboard2nd10Ds",
                    "resign2nd10Ds",
                    "onboardD11",
                    "resignD11",
                    "onboardD12",
                    "resignD12",
                    "onboardD13",
                    "resignD13",
                    "onboardD14",
                    "resignD14",
                    "onboardD15",
                    "resignD15",
                    "onboardD16",
                    "resignD16",
                    "onboardD17",
                    "resignD17",
                    "onboardD18",
                    "resignD18",
                    "onboardD19",
                    "resignD19",
                    "onboardD20",
                    "resignD20",
                    "onboard3rd10Ds",
                    "resign3rd10Ds",
                    "onboardD21",
                    "resignD21",
                    "onboardD22",
                    "resignD22",
                    "onboardD23",
                    "resignD23",
                    "onboardD24",
                    "resignD24",
                    "onboardD25",
                    "resignD25",
                    "onboardD26",
                    "resignD26",
                    "onboardD27",
                    "resignD27",
                    "onboardD28",
                    "resignD28",
                    "onboardD29",
                    "resignD29",
                    "onboardD30",
                    "resignD30",
                    "onboardD31",
                    "resignD31"],
            name : ["公司", "区域", "门店", "总入职", "总离职", "上旬入职", "上旬离职", "D1入职", "D1离职", "D2入职", "D2离职", "D3入职", "D3离职", "D4入职", "D4离职", "D5入职", "D5离职", "D6入职", "D6离职", "D7入职", "D7离职", "D8入职", "D8离职", "D9入职", "D9离职", "D10入职", "D10离职", "中旬入职", "中旬离职", "D11入职", "D11离职", "D12入职", "D12离职", "D13入职", "D13离职", "D14入职", "D14离职", "D15入职", "D15离职", "D16入职", "D16离职", "D17入职", "D17离职", "D18入职", "D18离职", "D19入职", "D19离职", "D20入职", "D20离职", "下旬入职", "下旬离职", "D21入职", "D21离职", "D22入职", "D22离职", "D23入职", "D23离职", "D24入职", "D24离职", "D25入职", "D25离职", "D26入职", "D26离职", "D27入职", "D27离职", "D28入职", "D28离职", "D29入职", "D29离职", "D30入职", "D30离职", "D31入职", "D31离职"],
            tid : "id",
            checkBox : "id"
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
                    exportEnabled: false,
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