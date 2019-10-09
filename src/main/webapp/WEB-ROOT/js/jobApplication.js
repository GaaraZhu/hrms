    var pageSize = 8;
	$("#reset").click(
        function() {
            $("#searchCompany").val("");
            $("#searchCity").val("");
            $("#searchName").val("");
            $("#searchActive").val("true");
        }
	);

	$("#search").click(
        function() {
            queryPage(1);
	    }
	);

    function queryPage(cp) {
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
                initTable(data, cp);
            },
            error : function(e) {
                console.log(e);
                alert("搜索失败，请查看控制台日志");
            }
        });
    }

    function initTable(data, currentPage) {
        $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "name",
                    "phone",
                    "idNumber",
                    "referee",
                    "refereePhone",
                    "company",
                    "city",
                    "jobName",
                    "applicationTime",
                    "status",
                    "onBoardedTime",
                    "resignedTime",
                    "lastUpdatedTime",
                    "<button  class='btn btn-info btn-sm editJobA'  ID='editJobA' onclick='updF(id)'><span class='glyphicon glyphicon-user'></span> 编辑</button> <button  class='btn btn-info btn-sm delJobA' ID='delJobA' onclick='delF(id)'><span class='glyphicon glyphicon-user'></span>删除</button>" ] ,
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
                queryPage(currentPage);
            }
        });
    }

	function updF(id) {
        $.ajax({
            type : "GET",
            url : "jobApplication?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#addJobApplicationList").load(
                    "WEB-ROOT/html/job.jsp",
                    function() {
                        $("#addModel").modal({
                            keyboard : true
                        });
                        if (data != null) {
//                            $("#id").val(data.id);
//                            $("#company").val(data.company);
//                            $("#city").val(data.city);
//                            $("#name").val(data.name);
//                            $("#salaryRange").val(data.salaryRange);
//                            $("#type").val(data.type);
//                            $("#quota").val(data.quota);
//                            $("#referralBonus").val(data.referralBonus);
//                            $("#referralBonusAmount").val(data.referralBonusAmount);
//                            $("#active").val(data.active);
//                            $("#submitType").val("POST");
                        }
                    });
            },
            error : function(msg) {
                alert("bb");
            }
        });
    }

    function delF(id) {
        $("#alert").load("WEB-ROOT/html/common/alert.jsp",
            function(response, status, xhr) {
                $('#alert').html(response);
            });
        $.ajax({
            type : "DELETE",
            url : "jobApplication?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(msg) {
                $("#alertText").text(msg);
                $("#alertModel").modal({
                    keyboard : true
                });
            },
            error : function(msg) {
                $("#alertText").text("删除失败");
                $("#alertModel").modal({
                    keyboard : true
                });
            }
        });
    }

    $("#addJobApplication").click(
        function(){
             $("#addJobApplicationList").load("WEB-ROOT/html/jobApplication.jsp", function(){
                $("#addModel").modal({
                    keyboard: true
                });
            });
        }
    );

    $('#jobApplicationForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            company : {
                validators : {
                    notEmpty : {
                        message : '企业不能为空'
                    },

                }
            },
            city : {
                validators : {
                    notEmpty : {
                        message : '城市不能为空'
                    },

                }
            },
            name : {
                validators : {
                    notEmpty : {
                        message : '职位名称不能为空'
                    },

                }
            },
            quota : {
                validators : {
                    notEmpty : {
                        message : '招聘人数不能为空'
                    },
                }
            },
            salaryRange : {
                validators : {
                    notEmpty : {
                        message : '薪资待遇不能为空'
                    },
                }
            },
            type : {
                validators : {
                    notEmpty : {
                        message : '工作性质不能为空'
                    },
                }
            },
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdate
    );

    function onCreateOrUpdate(e){
        e.preventDefault();
        var data = $('form#jobApplicationForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"jobApplication?id="+$("#id").val():"jobApplication";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function(msg) {
                 $( "#addAlert" ).load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $('#addAlert').html(response);
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            },
            error : function(msg) {
                $( "#addAlert" ).load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $('#addAlert').html(response);
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

