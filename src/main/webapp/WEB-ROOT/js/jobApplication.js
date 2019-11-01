    var pageSize = 8;
    var wto;
	$("#resetJobApplications").click(
        function() {
            $("#searchCompany").val("");
            $("#searchCity").val("");
            $("#searchName").val("");
            $("#searchActive").val("true");
        }
	);

	$("#searchJobApplications").click(
        function() {
            queryJobApplications(1);
	    }
    );

    $('#idNumber').change(function() {
        clearTimeout(wto);
        wto = setTimeout(function() {
            idNumber = $("#idNumber").val();
            $.ajax({
                url : "candidate",
                type : "GET",
                async: true,
                data : "idNumber=" + idNumber,
                contentType : "application/json;charset=utf-8",
                success : function(data) {
                    $("#candidateId").val(data.id);
                    $("#candidateName").val(data.name);
                },
                error : function(e) {
                    if (e.status != 401) {
                        $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                            $("#alertText").text("该候选人不存在，请先录入系统再进行操作");
                            $("#alertModel").modal({
                                keyboard: true
                            });
                        });
                    }
                }
            });
        }, 1000);
    });

    function queryJobApplications(cp) {
        company = $("#searchCompany").val();
        city = $("#searchCity").val();
        jobName = $("#searchJobName").val();
        candidate = $("#searchCandidate").val();
        hasReferee = $("#searchHasReferee").val();
        referee = $("#searchReferee").val();
        status = $("#searchStatus").val();
        $.ajax({
            url : "jobApplications",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&company=" + company
                    +"&city="+city + "&jobName="+jobName+ "&candidate="+candidate +"&hasReferee="+hasReferee
                    +"&referee="+referee + "&status="+status+"&fromTime="+"" + "&toTime="+"",
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initJobApplicationTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initJobApplicationTable(data, currentPage) {
        $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "candidateName",
                    "phone",
                    "idNumber",
                    "referee",
                    "refereePhone",
                    "company",
                    "city",
                    "jobName",
                    "applicationDate",
                    "status",
                    "onBoardedTime",
                    "resignedTime",
                    "lastUpdatedTime",
                    "<button  class='btn btn-info btn-sm editJobA'  ID='editJobA' onclick='updateJobApplication(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delJobA' ID='delJobA' onclick='deleteJobApplication(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "姓名", "电话", "身份证号", "推荐人", "推荐人电话", "应聘企业", "应聘城市", "应聘职位", "求职/推荐时间", "最新状态", "入职时间", "离职时间", "处理时间", "_opt" ],
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
                queryJobApplications(currentPage);
            }
        });
    }

	function updateJobApplication(id) {
        $.ajax({
            type : "GET",
            url : "jobApplication?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#jobApplicationModal").load(
                    "WEB-ROOT/html/jobApplication.jsp",
                    function() {
                        $("#addModel").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#jobId").val(data.jobId);
                            $("#candidateId").val(data.candidateId);
                            $("#jobName").val(data.jobName);
                            $("#company").val(data.company);
                            $("#city").val(data.city);
                            $("#district").val(data.district);
                            $("#idNumber").val(data.idNumber);
                            $("#candidateName").val(data.candidateName);
                            $("#referee").val(data.referee);
                            $("#refereePhone").val(data.refereePhone);
                            $("#status").val(data.status).change();
                            $("#applicationDate").datepicker("setDate", data.applicationDate);
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

    function deleteJobApplication(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#jobApplicationsAlertModal").load("WEB-ROOT/html/common/alert.jsp");
            $.ajax({
                type : "DELETE",
                url : "jobApplication?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function() {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryJobApplications(1);
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

    $('#jobApplicationForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            idNumber : {
                validators : {
                    notEmpty : {
                        message : '申请人身份证账号不能为空'
                    },

                }
            },
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdateJobApplication
    );

    function onCreateOrUpdateJobApplication(e){
        e.preventDefault();
        var data = $('form#jobApplicationForm').serializeObject();
        data.jobId = $("#jobId").val();
        data.candidateId = $("#candidateId").val();
        console.log(data);
        var method = $("#submitType").val();
        var url = method=="POST"?"jobApplication?id="+$("#id").val():"jobApplication";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 if (method=="POST") {
                    queryJobApplications(1);
                 }
            },
            error : function(msg) {
                $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

