    var pageSize = 8;
    var jobsResultTable;
    var companies;
	$("#resetJobs").click(
        function() {
            $("#searchCompany").val("");
            $("#searchCity").val("");
            $("#searchName").val("");
            $("#searchActive").val("true");
        }
	);

	$("#searchJobs").click(
        function() {
            queryJobs(1);
	    }
	);

    function queryJobs(cp) {
        company = $("#searchCompany").val();
        city = $("#searchCity").val();
        name = $("#searchName").val();
        active = $("#searchActive").val();
        $.ajax({
            url : "jobs",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&company=" +company+ "&city="+city + "&name="+name+ "&active="+active,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initJobTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initJobTable(data, currentPage) {
        jobsResultTable = $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "company",
                    "city",
                    "name",
                    "salaryRange",
                    "type",
                    "referralBonus",
                    "referralBonusAmount",
                    "creator",
                    "createdTime",
                    "active",
                    "<button class='btn btn-info btn-sm editDepa' ID='editJob' onclick='updateJob(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='deleteJob' onclick='deleteJob(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "企业", "城市", "职位名称", "待遇", "工作性质", "推荐有奖", "奖励金额", "发布人", "发布时间", "是否有效", "_opt" ],
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
                queryJobs(currentPage);
            }
        });
    }

	function updateJob(id) {
        $.ajax({
            type : "GET",
            url : "job?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#innerModal").load(
                    "WEB-ROOT/html/job.jsp",
                    function() {
                        $("#originalJobModal").modal({
                            keyboard : true
                        });

                        if (!companies) {
                            $.ajax({
                                url : "companies",
                                type : "GET",
                                async: true,
                                data : "currentPage=1&pageSize=500&name=&city=",
                                contentType : "application/json;charset=utf-8",
                                success : function(data) {
                                    companies = data.results;
                                    initCompanyDropdown(companies, companies[0].id);
                                    $("#city").val(companies[0].city);
                                },
                                error : function(e) {
                                    if (e.status != 401) {
                                        console.log(e);
                                        alert("加载公司列表失败，请查看控制台日志");
                                    }
                                }
                            });
                        } else {
                            initCompanyDropdown(companies, data.companyId);
                            $("#city").val(companies.filter(c=>c.id==data.companyId)[0].city);
                        }

                        if (data != null) {
                            $("#id").val(data.id);
                            $("#companyId").val(data.companyId);
                            $("#city").val(data.city);
                            $("#name").val(data.name);
                            $("#salaryRange").val(data.salaryRange);
                            $("#type").val(data.type);
                            $("#referralBonus").val(data.referralBonus);
                            $("#referralBonusAmount").val(data.referralBonusAmount);
                            $("#active").val(data.active);
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

    function initCompanyDropdown(companies, companyId) {
        var companyDropdown = $("#companyId");
        companies.forEach(function(c){
            companyDropdown.append($("<option />").val(c.id).text(c.name));
        });
        companyDropdown.val(companyId);
    }

    function deleteJob(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
            $.ajax({
                type : "DELETE",
                url : "job?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function(msg) {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryJobs(1);
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

    $("#addJob").click(
        function(){
            $("#innerModal").load("WEB-ROOT/html/job.jsp", function(){
                $("#originalJobModal").modal({
                    keyboard: true
                });

                if(!companies) {
                    $.ajax({
                        url : "companies",
                        type : "GET",
                        async: true,
                        data : "currentPage=1&pageSize=500&name=&city=",
                        contentType : "application/json;charset=utf-8",
                        success : function(data) {
                            companies = data.results;
                            initCompanyDropdown(companies, companies[0].id);
                        },
                        error : function(e) {
                            console.log(e);
                            if (e.status != 401) {
                                alert("加载公司列表失败，请查看控制台日志");
                            }
                        }
                    });
                } else {
                    initCompanyDropdown(companies, companies[0].id);
                }
            });
        }
    );

    $("#addJobQuota").click(
        function(){
            var idsStr = jobsResultTable.getCheckboxIds();
            if (idsStr=="" || idsStr.includes(",")) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("请选择一个职位进行操作");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            } else {
                $.ajax({
                    url : "job",
                    type : "GET",
                    async: true,
                    data : "id=" + idsStr,
                    contentType : "application/json;charset=utf-8",
                    success : function(jobData) {
                        $.ajax({
                            url : "company",
                            type : "GET",
                            async: true,
                            data : "id=" + jobData.companyId,
                            contentType : "application/json;charset=utf-8",
                            success : function(companyData) {
                                $("#innerModal").load("WEB-ROOT/html/jobQuota.jsp", function(){
                                    $.ajax({
                                        url : "branches",
                                        type : "GET",
                                        async: true,
                                        data : "currentPage=1&pageSize=5000&company=" +companyData.name+ "&branch=",
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
                                            $("#jobId").val(jobData.id);
                                            $("#jobName").val(jobData.name);
                                            $("#company").val(companyData.name);
                                            $("#city").val(companyData.city);

                                            $("#submitType").val("PUT");
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
                                });
                            },
                            error : function(e) {
                                if (e.status != 401) {
                                    console.log(e);
                                    alert("操作失败，请查看控制台日志");
                                }
                            }
                        });
                    },
                    error : function(e) {
                        if (e.status != 401) {
                            console.log(e);
                            alert("操作失败，请查看控制台日志");
                        }
                    }
                });
            }
        }
    );

    $("#addJobApplication").click(
        function(){
            var idsStr = jobsResultTable.getCheckboxIds();
            if (idsStr=="" || idsStr.includes(",")) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("请选择一个职位进行操作");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            } else {
                $.ajax({
                    url : "job",
                    type : "GET",
                    async: true,
                    data : "id=" + idsStr,
                    contentType : "application/json;charset=utf-8",
                    success : function(jobData) {
                        $("#innerModal").load("WEB-ROOT/html/jobApplication.jsp", function(){
                            $.ajax({
                                url : "branches",
                                type : "GET",
                                async: true,
                                data : "currentPage=1&pageSize=500&company=" +jobData.company+ "&branch=",
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

                                    if (jobData.referralBonus=='无') {
                                        $("#referee").attr("disabled","disabled");
                                        $("#refereePhone").attr("disabled","disabled");
                                    }
                                    $("#submitType").val("PUT");
                                    $("#jobId").val(jobData.id);
                                    $("#jobName").val(jobData.name);
                                    $("#company").val(jobData.company);
                                    $("#city").val(jobData.city);
                                    $("#status").val("未处理").change();
                                    $("#originalJobApplicationModal").modal({
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
                        });
                    },
                    error : function(e) {
                        if (e.status != 401) {
                            console.log(e);
                            alert("操作失败，请查看控制台日志");
                        }
                    }
                });
            }
        }
    );

    $('#jobForm').bootstrapValidator({
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
            district : {
                validators : {
                    notEmpty : {
                        message : '城市区域不能为空'
                    },
                }
            },
            address : {
                validators : {
                    notEmpty : {
                        message : '门店地址不能为空'
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
        onCreateOrUpdateJob
    );

    function onCreateOrUpdateJob(e){
        e.preventDefault();
        var data = $('form#jobForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"job?id="+$("#id").val():"job";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 queryJobs(1);
            },
            error : function(msg) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

