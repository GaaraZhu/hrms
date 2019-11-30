    var resultTable;
    var personalReports;

    // personal Report
    $("#resetPersonalReport").click(
        function() {
            $('#month').datepicker("setDate", new Date());
            $("#company").val("");
            $("#jobName").val("");
        }
    );

    $("#searchPersonalReport").click(
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
            queryPersonalReport(1);
        }
    );

    $("#personalReportAnalysis").click(
        function(){
            var idsStr = resultTable.getCheckboxIds();
            if (idsStr=="" || idsStr.includes(",")) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("请选择一个业务员进行操作");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            } else {
                var personalReport = personalReports[parseInt(idsStr)-1];
                var yearAndMonth = $("#month").val();
                var year = parseInt(yearAndMonth.split("-")[0]);
                var month = parseInt(yearAndMonth.split("-")[1]);
                var options = {
                    exportEnabled: false,
                    animationEnabled: true,
                    title:{
                        text: "个人入职 vs. 离职"
                    },
                    subtitles: [{
                        text: "业务员: " + personalReport.creatorName
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
                            { x: new Date(year, month-1, 1),  y: personalReport.onboardD1 },
                            { x: new Date(year, month-1, 2),  y: personalReport.onboardD2 },
                            { x: new Date(year, month-1, 3),  y: personalReport.onboardD3 },
                            { x: new Date(year, month-1, 4),  y: personalReport.onboardD4 },
                            { x: new Date(year, month-1, 5),  y: personalReport.onboardD5 },
                            { x: new Date(year, month-1, 6),  y: personalReport.onboardD6 },
                            { x: new Date(year, month-1, 7),  y: personalReport.onboardD7 },
                            { x: new Date(year, month-1, 8),  y: personalReport.onboardD8 },
                            { x: new Date(year, month-1, 9),  y: personalReport.onboardD9 },
                            { x: new Date(year, month-1, 10),  y: personalReport.onboardD10 },
                            { x: new Date(year, month-1, 11),  y: personalReport.onboardD11 },
                            { x: new Date(year, month-1, 12),  y: personalReport.onboardD12 },
                            { x: new Date(year, month-1, 13),  y: personalReport.onboardD13 },
                            { x: new Date(year, month-1, 14),  y: personalReport.onboardD14 },
                            { x: new Date(year, month-1, 15),  y: personalReport.onboardD15 },
                            { x: new Date(year, month-1, 16),  y: personalReport.onboardD16 },
                            { x: new Date(year, month-1, 17),  y: personalReport.onboardD17 },
                            { x: new Date(year, month-1, 18),  y: personalReport.onboardD18 },
                            { x: new Date(year, month-1, 19),  y: personalReport.onboardD19 },
                            { x: new Date(year, month-1, 20),  y: personalReport.onboardD20 },
                            { x: new Date(year, month-1, 21),  y: personalReport.onboardD21 },
                            { x: new Date(year, month-1, 22),  y: personalReport.onboardD22 },
                            { x: new Date(year, month-1, 23),  y: personalReport.onboardD23 },
                            { x: new Date(year, month-1, 24),  y: personalReport.onboardD24 },
                            { x: new Date(year, month-1, 25),  y: personalReport.onboardD25 },
                            { x: new Date(year, month-1, 26),  y: personalReport.onboardD26 },
                            { x: new Date(year, month-1, 27),  y: personalReport.onboardD27 },
                            { x: new Date(year, month-1, 28),  y: personalReport.onboardD28 },
                            { x: new Date(year, month-1, 29),  y: personalReport.onboardD29 },
                            { x: new Date(year, month-1, 30),  y: personalReport.onboardD30 },
                            { x: new Date(year, month-1, 31),  y: personalReport.onboardD31 }
                        ]
                    },
                    {
                        type: "spline",
                        name: "离职",
                        showInLegend: true,
                        xValueFormatString: "YYYY-MM-DD",
                        yValueFormatString: "#,##0 人",
                        dataPoints: [
                            { x: new Date(year, month-1, 1),  y: personalReport.resignD1 },
                            { x: new Date(year, month-1, 2),  y: personalReport.resignD2 },
                            { x: new Date(year, month-1, 3),  y: personalReport.resignD3 },
                            { x: new Date(year, month-1, 4),  y: personalReport.resignD4 },
                            { x: new Date(year, month-1, 5),  y: personalReport.resignD5 },
                            { x: new Date(year, month-1, 6),  y: personalReport.resignD6 },
                            { x: new Date(year, month-1, 7),  y: personalReport.resignD7 },
                            { x: new Date(year, month-1, 8),  y: personalReport.resignD8 },
                            { x: new Date(year, month-1, 9),  y: personalReport.resignD9 },
                            { x: new Date(year, month-1, 10),  y: personalReport.resignD10 },
                            { x: new Date(year, month-1, 11),  y: personalReport.resignD11 },
                            { x: new Date(year, month-1, 12),  y: personalReport.resignD12 },
                            { x: new Date(year, month-1, 13),  y: personalReport.resignD13 },
                            { x: new Date(year, month-1, 14),  y: personalReport.resignD14 },
                            { x: new Date(year, month-1, 15),  y: personalReport.resignD15 },
                            { x: new Date(year, month-1, 16),  y: personalReport.resignD16 },
                            { x: new Date(year, month-1, 17),  y: personalReport.resignD17 },
                            { x: new Date(year, month-1, 18),  y: personalReport.resignD18 },
                            { x: new Date(year, month-1, 19),  y: personalReport.resignD19 },
                            { x: new Date(year, month-1, 20),  y: personalReport.resignD20 },
                            { x: new Date(year, month-1, 21),  y: personalReport.resignD21 },
                            { x: new Date(year, month-1, 22),  y: personalReport.resignD22 },
                            { x: new Date(year, month-1, 23),  y: personalReport.resignD23 },
                            { x: new Date(year, month-1, 24),  y: personalReport.resignD24 },
                            { x: new Date(year, month-1, 25),  y: personalReport.resignD25 },
                            { x: new Date(year, month-1, 26),  y: personalReport.resignD26 },
                            { x: new Date(year, month-1, 27),  y: personalReport.resignD27 },
                            { x: new Date(year, month-1, 28),  y: personalReport.resignD28 },
                            { x: new Date(year, month-1, 29),  y: personalReport.resignD29 },
                            { x: new Date(year, month-1, 30),  y: personalReport.resignD30 },
                            { x: new Date(year, month-1, 31),  y: personalReport.resignD31 }
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

    function queryPersonalReport(cp) {
        month = $("#month").val();
        company = $("#company").val();
        jobName = $("#jobName").val();
        $.ajax({
            url : "applicationReports/personal",
            type : "GET",
            async: true,
            data : "month=" + month + "&company=" + company + "&jobName=" + jobName,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#personalReportAnalysisDiv").hide();
                personalReports = data;
                initPersonalReportTable(data);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initPersonalReportTable(data) {
        for (let i=0; i<data.length; i++) {
          data[i].id=i+1;
        }
        resultTable = $.lTable('#personalReportTableList',
        {
            data : data,
            title : [
                    "creatorName",
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
            name : ["业务员", "总入职", "总离职", "上旬入职", "上旬离职", "中旬入职", "中旬离职", "下旬入职", "下旬离职", "D1入职", "D1离职", "D2入职", "D2离职", "D3入职", "D3离职", "D4入职", "D4离职", "D5入职", "D5离职", "D6入职", "D6离职", "D7入职", "D7离职", "D8入职", "D8离职", "D9入职", "D9离职", "D10入职", "D10离职", "D11入职", "D11离职", "D12入职", "D12离职", "D13入职", "D13离职", "D14入职", "D14离职", "D15入职", "D15离职", "D16入职", "D16离职", "D17入职", "D17离职", "D18入职", "D18离职", "D19入职", "D19离职", "D20入职", "D20离职", "D21入职", "D21离职", "D22入职", "D22离职", "D23入职", "D23离职", "D24入职", "D24离职", "D25入职", "D25离职", "D26入职", "D26离职", "D27入职", "D27离职", "D28入职", "D28离职", "D29入职", "D29离职", "D30入职", "D30离职", "D31入职", "D31离职"],
            tid : "id",
            checkBox : "id"
        });
    }