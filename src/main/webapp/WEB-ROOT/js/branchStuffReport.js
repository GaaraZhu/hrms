    var branchStuffReports;

    // branch stuff report
    $("#resetBranchStuffReport").click(
        function() {
            $('#month').MonthPicker({SelectedMonth: new Date()});
            $("#company").val("");
            $("#jobName").val("");
        }
    );

    $("#searchBranchStuffReport").click(
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
            queryBranchStuffReport(1);
        }
    );

    $("#branchStuffReportAnalysis").click(
        function(){
            if (!branchStuffReports) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("请先查询数据再进行操作");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            } else {
                var options = {
                    animationEnabled: true,
                    theme: "light2",
                    title:{
                        text: "月初在职 vs. 月尾在职"
                    },
                    subtitles: [{
                        text: "月份: " + $("#month").val()
                    }],
                    axisX: {
                        title: "门店"
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
                        cursor:"pointer",
                        verticalAlign: "bottom",
                        horizontalAlign: "left",
                        dockInsidePlotArea: true,
                        itemclick: toggleDataSeries
                    },
                    data: [{
                        type: "line",
                        showInLegend: true,
                        name: "月初在职",
		                markerType: "square",
                        color: "#F08080",
                        yValueFormatString: "#,##0 人",
                        dataPoints: branchStuffReports.map(r=> ({x: r.id, y: r.firstDayCount}))
                    },
                    {
                        type: "line",
                        name: "月末在职",
                        showInLegend: true,
                        lineDashType: "dash",
                        yValueFormatString: "#,##0 人",
                        dataPoints: branchStuffReports.map(r=> ({x: r.id, y: r.lastDayCount}))
                    }]
                };
                $("#dialogBox").dialog({
                    open: function(event,ui) {
                        $(".ui-widget-overlay").bind("click", function(event,ui) {
                            $("#dialogBox").dialog("close");
                        });
                    },
                    closeOnEscape: true,
                    draggable: true,
                    resizable: true,
                    title: "月初月尾在职人数",
                    width: 700,
                    modal: true,
                    show: 500
                });
                $(".ui-widget-overlay").css({"background-color": "#111111"});
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

    function queryBranchStuffReport(cp) {
        month = $("#month").val();
        company = $("#company").val();
        jobName = $("#jobName").val();
        $.ajax({
            url : "applicationReports/branch/stuff",
            type : "GET",
            async: true,
            data : "month=" + month + "&company=" + company + "&jobName=" + jobName,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#branchStuffReportAnalysisDiv").hide();
                branchStuffReports = data;
                initBranchStuffReportTable(data);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initBranchStuffReportTable(data) {
        for (let i=0; i<data.length; i++) {
          data[i].id=i+1;
        }
        $.lTable('#branchStuffReportTableList',
        {
            data : data,
            title : [
                    "company",
                    "district",
                    "branch",
                    "month",
                    "firstDayCount",
                    "lastDayCount"],
            name : ["公司", "区域", "门店", "月份", "月初在职", "月末在职"],
            tid : "id"
        });
    }