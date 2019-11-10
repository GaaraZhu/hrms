    var pageSize = 8;
    var wto;
	$("#resetUsers").click(
        function() {
            $('#fromDate').datepicker("setDate", new Date());
            $('#toDate').datepicker("setDate", new Date());
            $("#searchName").val("");
            $("#searchType").val("WEEKLY");
        }
	);

	$("#searchApplicationReport").click(
        function() {
            queryApplicationReport(1);
	    }
	);

    function queryApplicationReport(cp) {
        fromDate = $("#searchFromDate").val();
        toDate = $("#searchToDate").val();
        name = $("#searchName").val();
        type = $("#searchType").val();
        $.ajax({
            url : "applicationReports",
            type : "GET",
            async: true,
            data : "fromDate=" + (fromDate?fromDate:'') + "&toDate=" + (toDate?toDate:'') + "&name=" + name + "&type=" + type + "&pageSize=" + pageSize + "&currentPage=" + cp,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initApplicationReportTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initApplicationReportTable(data, currentPage) {
        $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "name",
                    "newApplied",
                    "newInterviewed",
                    "newOnboarded",
                    "fromDate",
                    "toDate",
                    "<button  class='btn btn-info btn-sm editUser'  ID='editUser' onclick='updateUser(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delUser' ID='delUser' onclick='deleteUser(id)'><span class='glyphicon glyphicon-remove'></span>删除</button> <button  class='btn btn-info btn-sm importData' ID='migrateUserData' onclick='migrateUserData(id)'><span class='glyphicon glyphicon-remove'></span>数据迁移</button>" ] ,
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
                queryApplicationReport(currentPage);
            }
        });
    }
