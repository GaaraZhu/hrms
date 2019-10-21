    var pageSize = 8;
	$("#reset").click(
        function() {
            $("#searchName").val("");
            $("#searchPhone").val("");
            $("#searchCity").val("");
        }
	);

	$("#search").click(
        function() {
            queryPage(1);
	    }
	);

    function queryPage(cp) {
        name = $("#searchName").val();
        phone = $("#searchPhone").val();
        city = $("#searchCity").val();
        $.ajax({
            url : "candidates",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&name=" +name+ "&phone="+phone,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
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
                    "gender",
                    "idNumber",
                    "phone",
                    "ethnicity",
                    "politicalStatus",
                    "degree",
                    "bornAddress",
                    "currentAddress",
                    "bankAccount",
                    "bank",
                    "emergencyContactName",
                    "emergencyContactPhone",
                    "emergencyContactRelationship",
                    "<button  class='btn btn-info btn-sm editDepa'  ID='editDepa' onclick='updF(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='delDepa' onclick='delF(id)'><span class='glyphicon glyphicon-remove'></span> 删除</button>" ] ,
            name : ["ID", "姓名", "性别", "身份证号", "电话号码", "民族", "政治面貌", "学历", "户籍地址", "当前住址", "银行卡号", "开户银行", "紧急联系人", "联系人电话", "联系人关系", "_opt" ],
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
            url : "candidate?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#addCandidatePage").load(
                    "WEB-ROOT/html/candidate.jsp",
                    function() {
                        $("#addModel").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#name").val(data.name);
                            $("#gender").val(data.gender);
                            $("#idNumber").val(data.idNumber);
                            $("#phone").val(data.phone);
                            $("#ethnicity").val(data.ethnicity);
                            $("#degree").val(data.degree);
                            $("#politicalStatus").val(data.politicalStatus);
                            $("#bornAddress").val(data.bornAddress);
                            $("#currentAddress").val(data.currentAddress);
                            $("#bankAccount").val(data.bankAccount);
                            $("#bank").val(data.bank);
                            $("#emergencyContactName").val(data.emergencyContactName);
                            $("#emergencyContactPhone").val(data.emergencyContactPhone);
                            $("#emergencyContactRelationship").val(data.emergencyContactRelationship);
                            $("#submitType").val("POST")
                        }
                    });
            },
            error : function(msg) {
                if (e.status != 401) {
                    console.log(msg);
                    alert("更新失败，请查看控制台日志");
                }
            }
        });
    }

    function delF(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#alert").load("WEB-ROOT/html/common/alert.jsp",
                    function(response, status, xhr) {
                        $('#alert').html(response);
                    });
            $.ajax({
                type : "DELETE",
                url : "candidate?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function() {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryPage(1);
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

    $("#addCandidate").click(
        function(){
             $("#addCandidatePage").load("WEB-ROOT/html/candidate.jsp", function(){
                $("#addModel").modal({
                    keyboard: true
                });
            });
        }
    );

    $("#uploadCandidates").click(
        function(){
            $("#uploadCandidatesPage").load(
                "WEB-ROOT/html/common/upload.jsp",
                function() {
                    $("#addModel").modal({
                        keyboard : true
                    });
                    $("#uploadDataType").val("candidate");
                    $("#uploadModalHeader").text("上传候选人");
            });
        }
    );

    $('#candidateForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            name : {
                validators : {
                    notEmpty : {
                        message : '名称不能为空'
                    },

                }
            },
            gender : {
                validators : {
                    notEmpty : {
                        message : '性别不能为空'
                    },

                }
            },
            phone : {
                validators : {
                    notEmpty : {
                        message : '电话不能为空'
                    },

                }
            },
            idNumber : {
                validators : {
                    notEmpty : {
                        message : '身份证号不能为空'
                    },

                }
            }
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdate
    );

    function onCreateOrUpdate(e){
        e.preventDefault();
        var data = $('form#candidateForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"candidate?id="+$("#id").val():"candidate";
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
                queryPage(1);
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

