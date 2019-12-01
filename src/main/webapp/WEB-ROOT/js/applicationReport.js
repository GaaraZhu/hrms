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