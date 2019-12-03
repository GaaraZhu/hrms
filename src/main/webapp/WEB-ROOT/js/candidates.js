    var pageSize = 8;
	$("#resetCandidates").click(
        function() {
            $("#searchName").val("");
            $("#searchPhone").val("");
            $("#searchCity").val("");
        }
	);

	$("#searchCandidates").click(
        function() {
            queryCandidates(1);
	    }
	);

    function queryCandidates(cp) {
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
                initCandidateTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initCandidateTable(data, currentPage) {
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
                    "<button  class='btn btn-info btn-sm editDepa'  ID='editCandidate' onclick='updateCandidate(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='delCandidate' onclick='deleteCandidate(id)'><span class='glyphicon glyphicon-remove'></span> 删除</button>" ] ,
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
                queryCandidates(currentPage);
            }
        });
    }

	function updateCandidate(id) {
        $.ajax({
            type : "GET",
            url : "candidate?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#innerModal").load(
                    "WEB-ROOT/html/candidate.jsp",
                    function() {
                        $("#originalCandidateModal").modal({
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

    function deleteCandidate(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
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
                    queryCandidates(1);
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
             $("#innerModal").load("WEB-ROOT/html/candidate.jsp", function(){
                $("#originalCandidateModal").modal({
                    keyboard: true
                });
            });
        }
    );

    $("#uploadCandidates").click(
        function(){
            $("#innerModal").load(
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