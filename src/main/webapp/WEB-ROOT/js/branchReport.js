    var resultTable;
    var branchReports;

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

    $("#branchReportAnalysis").click(
        function(){
            var idsStr = resultTable.getCheckboxIds();
            if (idsStr=="" || idsStr.includes(",")) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("请选择一个部门进行操作");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            } else {
                var branchReport = branchReports[parseInt(idsStr)-1];
                var yearAndMonth = $("#month").val();
                var year = parseInt(yearAndMonth.split("-")[0]);
                var month = parseInt(yearAndMonth.split("-")[1]);
                var options = {
                    exportEnabled: false,
                    animationEnabled: true,
                    title:{
                        text: "门店入职 vs. 离职"
                    },
                    subtitles: [{
                        text: "门店: " + branchReport.branch
                    }],
                    axisX: {
                        title: "日期"
                    },
                    axisY: {
                        title: "人数",
                        titleFontColor: "#4F81BC",
                        lineColor: "#4F81BC",
                        labelFontColor: "#4F81BC",
                        tickColor: "#4F81BC",
                        includeZero: true
                    },
                    toolTip: {
                        shared: true
                    },
                    legend: {
                        cursor: "pointer",
                        itemclick: toggleDataSeries
                    },
                    data: [{
                        type: "spline",
                        name: "入职",
                        showInLegend: true,
                        xValueFormatString: "YYYY-MM-DD",
                        yValueFormatString: "#,##0 人",
                        dataPoints: [
                            { x: new Date(year, month-1, 1),  y: branchReport.onboardD1 },
                            { x: new Date(year, month-1, 2),  y: branchReport.onboardD2 },
                            { x: new Date(year, month-1, 3),  y: branchReport.onboardD3 },
                            { x: new Date(year, month-1, 4),  y: branchReport.onboardD4 },
                            { x: new Date(year, month-1, 5),  y: branchReport.onboardD5 },
                            { x: new Date(year, month-1, 6),  y: branchReport.onboardD6 },
                            { x: new Date(year, month-1, 7),  y: branchReport.onboardD7 },
                            { x: new Date(year, month-1, 8),  y: branchReport.onboardD8 },
                            { x: new Date(year, month-1, 9),  y: branchReport.onboardD9 },
                            { x: new Date(year, month-1, 10),  y: branchReport.onboardD10 },
                            { x: new Date(year, month-1, 11),  y: branchReport.onboardD11 },
                            { x: new Date(year, month-1, 12),  y: branchReport.onboardD12 },
                            { x: new Date(year, month-1, 13),  y: branchReport.onboardD13 },
                            { x: new Date(year, month-1, 14),  y: branchReport.onboardD14 },
                            { x: new Date(year, month-1, 15),  y: branchReport.onboardD15 },
                            { x: new Date(year, month-1, 16),  y: branchReport.onboardD16 },
                            { x: new Date(year, month-1, 17),  y: branchReport.onboardD17 },
                            { x: new Date(year, month-1, 18),  y: branchReport.onboardD18 },
                            { x: new Date(year, month-1, 19),  y: branchReport.onboardD19 },
                            { x: new Date(year, month-1, 20),  y: branchReport.onboardD20 },
                            { x: new Date(year, month-1, 21),  y: branchReport.onboardD21 },
                            { x: new Date(year, month-1, 22),  y: branchReport.onboardD22 },
                            { x: new Date(year, month-1, 23),  y: branchReport.onboardD23 },
                            { x: new Date(year, month-1, 24),  y: branchReport.onboardD24 },
                            { x: new Date(year, month-1, 25),  y: branchReport.onboardD25 },
                            { x: new Date(year, month-1, 26),  y: branchReport.onboardD26 },
                            { x: new Date(year, month-1, 27),  y: branchReport.onboardD27 },
                            { x: new Date(year, month-1, 28),  y: branchReport.onboardD28 },
                            { x: new Date(year, month-1, 29),  y: branchReport.onboardD29 },
                            { x: new Date(year, month-1, 30),  y: branchReport.onboardD30 },
                            { x: new Date(year, month-1, 31),  y: branchReport.onboardD31 }
                        ]
                    },
                    {
                        type: "spline",
                        name: "离职",
                        showInLegend: true,
                        xValueFormatString: "YYYY-MM-DD",
                        yValueFormatString: "#,##0 人",
                        dataPoints: [
                            { x: new Date(year, month-1, 1),  y: branchReport.resignD1 },
                            { x: new Date(year, month-1, 2),  y: branchReport.resignD2 },
                            { x: new Date(year, month-1, 3),  y: branchReport.resignD3 },
                            { x: new Date(year, month-1, 4),  y: branchReport.resignD4 },
                            { x: new Date(year, month-1, 5),  y: branchReport.resignD5 },
                            { x: new Date(year, month-1, 6),  y: branchReport.resignD6 },
                            { x: new Date(year, month-1, 7),  y: branchReport.resignD7 },
                            { x: new Date(year, month-1, 8),  y: branchReport.resignD8 },
                            { x: new Date(year, month-1, 9),  y: branchReport.resignD9 },
                            { x: new Date(year, month-1, 10),  y: branchReport.resignD10 },
                            { x: new Date(year, month-1, 11),  y: branchReport.resignD11 },
                            { x: new Date(year, month-1, 12),  y: branchReport.resignD12 },
                            { x: new Date(year, month-1, 13),  y: branchReport.resignD13 },
                            { x: new Date(year, month-1, 14),  y: branchReport.resignD14 },
                            { x: new Date(year, month-1, 15),  y: branchReport.resignD15 },
                            { x: new Date(year, month-1, 16),  y: branchReport.resignD16 },
                            { x: new Date(year, month-1, 17),  y: branchReport.resignD17 },
                            { x: new Date(year, month-1, 18),  y: branchReport.resignD18 },
                            { x: new Date(year, month-1, 19),  y: branchReport.resignD19 },
                            { x: new Date(year, month-1, 20),  y: branchReport.resignD20 },
                            { x: new Date(year, month-1, 21),  y: branchReport.resignD21 },
                            { x: new Date(year, month-1, 22),  y: branchReport.resignD22 },
                            { x: new Date(year, month-1, 23),  y: branchReport.resignD23 },
                            { x: new Date(year, month-1, 24),  y: branchReport.resignD24 },
                            { x: new Date(year, month-1, 25),  y: branchReport.resignD25 },
                            { x: new Date(year, month-1, 26),  y: branchReport.resignD26 },
                            { x: new Date(year, month-1, 27),  y: branchReport.resignD27 },
                            { x: new Date(year, month-1, 28),  y: branchReport.resignD28 },
                            { x: new Date(year, month-1, 29),  y: branchReport.resignD29 },
                            { x: new Date(year, month-1, 30),  y: branchReport.resignD30 },
                            { x: new Date(year, month-1, 31),  y: branchReport.resignD31 }
                        ]
                    }]
                };
                $("#chartContainer").CanvasJSChart(options);
            }
        }
    );

    function toggleDataSeries(e) {
    	if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
    		e.dataSeries.visible = false;
    	} else {
    		e.dataSeries.visible = true;
    	}
    	e.chart.render();
    }

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
                $("#branchReportAnalysisDiv").hide();
                branchReports = data;
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
        for (let i=0; i<data.length; i++) {
          data[i].id=i+1;
        }
        resultTable = $.lTable('#branchReportTableList',
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
                    "onboard2nd10Ds",
                    "resign2nd10Ds",
                    "onboard3rd10Ds",
                    "resign3rd10Ds",
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
            name : ["公司", "区域", "门店", "总入职", "总离职", "上旬入职", "上旬离职", "中旬入职", "中旬离职", "下旬入职", "下旬离职", "D1入职", "D1离职", "D2入职", "D2离职", "D3入职", "D3离职", "D4入职", "D4离职", "D5入职", "D5离职", "D6入职", "D6离职", "D7入职", "D7离职", "D8入职", "D8离职", "D9入职", "D9离职", "D10入职", "D10离职", "D11入职", "D11离职", "D12入职", "D12离职", "D13入职", "D13离职", "D14入职", "D14离职", "D15入职", "D15离职", "D16入职", "D16离职", "D17入职", "D17离职", "D18入职", "D18离职", "D19入职", "D19离职", "D20入职", "D20离职", "D21入职", "D21离职", "D22入职", "D22离职", "D23入职", "D23离职", "D24入职", "D24离职", "D25入职", "D25离职", "D26入职", "D26离职", "D27入职", "D27离职", "D28入职", "D28离职", "D29入职", "D29离职", "D30入职", "D30离职", "D31入职", "D31离职"],
            tid : "id",
            checkBox : "id"
        });
    }