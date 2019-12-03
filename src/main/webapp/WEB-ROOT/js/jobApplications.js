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
            jobId = $("#jobId").val();
            $.ajax({
                url : "candidate",
                type : "GET",
                async: true,
                data : "idNumber=" + idNumber,
                contentType : "application/json;charset=utf-8",
                success : function(data) {
                    $("#candidateId").val(data.id);
                    $("#candidateName").val(data.name);

                    $.ajax({
                        url : "activeJobApplicationCount",
                        type : "GET",
                        async: true,
                        data : "candidateIdNumber=" + idNumber+"&jobId=" + jobId,
                        contentType : "application/json;charset=utf-8",
                        success : function(count) {
                            if (count> 0) {
                                $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                                    $("#alertText").text("该候选人正在申请该职位，请去求职记录页面查看");
                                    $("#alertModel").modal({
                                        keyboard: true
                                    });
                                });
                            }
                        },
                        error : function(e) {
                            if (e.status != 401) {
                                console.log(e);
                                $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                                    $("#alertText").text("查询用户求职记录失败，请联系管理员");
                                    $("#alertModel").modal({
                                        keyboard: true
                                    });
                                });
                            }
                        }
                    });
                },
                error : function(e) {
                    if (e.status != 401) {
                        console.log(e);
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
                    "company",
                    "branchName",
                    "jobName",
                    "referee",
                    "refereePhone",
                    "applicationDate",
                    "status",
                    "interviewDate",
                    "onboardDate",
                    "resignDate",
                    "creator",
                    "updatedTime",
                    "<button  class='btn btn-info btn-sm editJobA'  ID='editJobA' onclick='updateJobApplication(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delJobA' ID='delJobA' onclick='deleteJobApplication(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "姓名", "电话", "身份证号", "应聘企业", "应聘门店", "应聘职位", "推荐人", "推荐人电话", "求职/推荐时间", "最新状态", "面试时间", "入职时间", "离职时间", "业务员", "处理时间", "_opt" ],
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
            success : function(jobData) {
                $("#innerModal").load(
                    "WEB-ROOT/html/jobApplication.jsp",
                    function() {

                        $.ajax({
                            url : "branches",
                            type : "GET",
                            async: true,
                            data : "currentPage=1&pageSize=500&company=" +jobData.company+ "&branch=",
                            contentType : "application/json;charset=utf-8",
                            success : function(branchData) {
                                var branches = branchData.results;
                                var branchDropdown = $("#branchDropdown");
                                branches.forEach(function(c){
                                    branchDropdown.append($("<option />").val(c.id).text(c.name));
                                });
                                branchDropdown.val(jobData.branchId);

                                $("#id").val(jobData.id);
                                $("#jobId").val(jobData.jobId);
                                $("#candidateId").val(jobData.candidateId);
                                $("#jobName").val(jobData.jobName);
                                $("#company").val(jobData.company);
                                $("#idNumber").val(jobData.idNumber);
                                $("#candidateName").val(jobData.candidateName);
                                $("#referee").val(jobData.referee);
                                $("#refereePhone").val(jobData.refereePhone);
                                $("#status").val(jobData.status).change();
                                $("#applicationDate").datepicker("setDate", jobData.applicationDate);
                                $("#interviewDate").datepicker("setDate", jobData.interviewDate);
                                $("#onboardDate").datepicker("setDate", jobData.onboardDate);
                                $("#resignDate").datepicker("setDate", jobData.resignDate);
                                $("#submitType").val("POST");

                                $("#originalJobApplicationModal").modal({
                                    keyboard : true
                                });
                            },
                            error : function(e) {
                                if (e.status != 401) {
                                    console.log(e);
                                    alert("搜索失败，请查看控制台日志");
                                }
                            }
                        });
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
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
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
