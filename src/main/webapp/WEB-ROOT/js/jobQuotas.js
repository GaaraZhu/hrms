    var pageSize = 8;
    $("#resetJobQuotas").click(
        function() {
            $("#searchJobName").val("");
            $("#searchCompany").val("");
            $("#searchCity").val("");
            $("#searchDistrict").val("");
            $("#searchDistrict").datepicker('setDate','');
        }
    );

    $("#searchJobQuotas").click(
        function() {
            queryJobQuotas(1);
        }
    );

    function queryJobQuotas(cp) {
        jobName = $("#searchJobName").val();
        company = $("#searchCompany").val();
        city = $("#searchCity").val();
        district = $("#searchDistrict").val();
        month = $("#searchMonth").val();
        $.ajax({
            url : "jobQuotas",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&jobName="+ jobName
                + "&company=" + company + "&city=" + city + "&district=" + district + "&month=" + month,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initJobQuotaTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initJobQuotaTable(data, currentPage) {
        $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "jobName",
                    "city",
                    "company",
                    "branch",
                    "month",
                    "quota",
                    "<button  class='btn btn-info btn-sm editUser'  ID='editUser' onclick='updateJobQuota(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delUser' ID='delJobQuota' onclick='deleteJobQuota(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "职位", "城市", "企业", "门店", "指标月份", "指标人数", "_opt" ],
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
                queryJobQuotas(currentPage);
            }
        });
    }

    function updateJobQuota(id) {
        $.ajax({
            type : "GET",
            url : "jobQuota?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#innerModal").load(
                    "WEB-ROOT/html/jobQuota.jsp",
                    function() {
                        if (data != null) {
                            $.ajax({
                                url : "branches",
                                type : "GET",
                                async: true,
                                data : "currentPage=1&pageSize=5000&company=" +data.company+ "&branch=",
                                contentType : "application/json;charset=utf-8",
                                success : function(branchData) {
                                    var branches = branchData.results;
                                    if (branches.length == 0) {
                                        $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                                            $("#alertText").text("请先创建门店再进行操作");
                                            $("#alertModel").modal({
                                                keyboard: true
                                            });
                                         });
                                        return;
                                    }
                                    var branchDropdown = $("#branchDropdown");
                                    branches.forEach(function(c){
                                        branchDropdown.append($("<option />").val(c.id).text(c.name));
                                    });
                                    branchDropdown.val(branches[0].id);

                                    $("#id").val(data.id);
                                    $("#jobId").val(data.jobId);
                                    $("#jobName").val(data.jobName);
                                    $("#company").val(data.company);
                                    $("#city").val(data.city);
                                    $("#district").val(data.district);
                                    $('#month').MonthPicker({SelectedMonth: data.month});
                                    $("#quota").val(data.quota);
                                    $("#submitType").val("POST");
                                    $("#originalJobQuotaModal").modal({
                                        keyboard: true
                                    });
                                },
                                error : function(e) {
                                    if (e.status != 401) {
                                        console.log(e);
                                        alert("搜索失败，请查看控制台日志");
                                    }
                                }
                            });
                        }
                    });
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("更新失败，请查看控制台日志");
                }
            }
        });
    }

    function deleteJobQuota(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
            $.ajax({
                type : "DELETE",
                url : "jobQuota?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function() {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryJobQuotas(1);
                },
                error : function(msg) {
                    $("#alertText").text("删除失败");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                }
            });
        }
    }
