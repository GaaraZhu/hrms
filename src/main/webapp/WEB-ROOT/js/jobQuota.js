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
                    "company",
                    "city",
                    "district",
                    "month",
                    "quota",
                    "<button  class='btn btn-info btn-sm editUser'  ID='editUser' onclick='updateJobQuota(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delUser' ID='delJobQuota' onclick='deleteJobQuota(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "职位名称", "所属企业", "所在城市", "所在区域", "指标月份", "指标人数", "_opt" ],
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
                        $("#originalJobQuotaModal").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#jobId").val(data.jobId);
                            $("#jobName").val(data.jobName);
                            $("#company").val(data.company);
                            $("#city").val(data.city);
                            $("#district").val(data.district);
                            $("#month").datepicker("setDate", new Date(data.month+'-01')).datepicker('disable');
                            $("#quota").val(data.quota);
                            $("#submitType").val("POST");
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

    $('#month').change(function() {
        wto = setTimeout(function() {
            jobId = $("#jobId").val();
            month = $("#month").val();
            $.ajax({
                url : "jobQuotaCount",
                type : "GET",
                async: true,
                data : "jobId=" + jobId + "&month=" + month,
                contentType : "application/json;charset=utf-8",
                success : function(count) {
                    if (count> 0) {
                        $("#jobQuotaAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                            $("#alertText").text("该月指标已创建，请去每月指标页面查看");
                            $("#alertModel").modal({
                                keyboard: true
                            });
                        });
                    }
                },
                error : function(e) {
                    if (e.status != 401) {
                        console.log(e);
                    }
                }
            });
        }, 1000);
    });

    $('#jobQuotaForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            quota : {
                validators : {
                    notEmpty : {
                        message : '指标不能为空'
                    },
                    integer: {
                        message: '指标格式错误'
                    },
                }
            },
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdateJobQuota
    );

    function onCreateOrUpdateJobQuota(e){
        e.preventDefault();
        var data = $('form#jobQuotaForm').serializeObject();
        data.jobId = $('#jobId').val();
        data.month = $('#month').val();
        var method = $("#submitType").val();
        var url = method=="POST"?"jobQuota?id="+$("#id").val():"jobQuota";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#jobQuotaAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 queryJobQuotas(1);
            },
            error : function(msg) {
                $("#jobQuotaAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

