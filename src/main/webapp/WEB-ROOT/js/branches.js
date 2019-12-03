    var pageSize = 8;
	$("#resetBranch").click(
        function() {
            $("#searchName").val("");
            $("#searchManager").val("");
        }
	);

	$("#searchBranches").click(
        function() {
            queryBranches(1);
	    }
	);

    function queryBranches(cp) {
        company = $("#searchCompany").val();
        branch = $("#searchBranch").val();
        $.ajax({
            url : "branches",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&company=" +company+ "&branch="+branch,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initBranchTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initBranchTable(data, currentPage) {
        $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "name",
                    "company",
                    "city",
                    "district",
                    "address",
                    "manager",
                    "phone",
                    "<button  class='btn btn-info btn-sm editDepa'  ID='editBranch' onclick='updateBranch(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='delBranch' onclick='deleteBranch(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "门店名称", "公司名称", "所在城市", "所在区域", "门店地址", "门店主管", "门店电话", "_opt" ],
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
                queryBranches(currentPage);
            }
        });
    }

	function updateBranch(id) {
        $.ajax({
            type : "GET",
            url : "branch?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#innerModal").load(
                    "WEB-ROOT/html/branch.jsp",
                    function() {
                        $("#originalBranchModal").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#company").val(data.company);
                            $("#city").val(data.city);
                            $("#district").val(data.district);
                            $("#address").val(data.address);
                            $("#name").val(data.name);
                            $("#manager").val(data.manager);
                            $("#phone").val(data.phone);
                            $("#submitType").val("POST")
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

    function deleteBranch(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
            $.ajax({
                type : "DELETE",
                url : "branch?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function() {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryBranches(1);
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

    $("#addBranch").click(
        function(){
             $("#innerModal").load("WEB-ROOT/html/branch.jsp", function(){
                $("#originalBranchModal").modal({
                    keyboard: true
                });
            });
        }
    );
