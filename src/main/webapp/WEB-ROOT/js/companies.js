    var pageSize = 8;
    var companiesResultTable;
	$("#resetCompanies").click(
        function() {
            $("#searchName").val("");
            $("#searchCity").val("");
        }
	);

	$("#searchCompanies").click(
        function() {
            queryCompanies(1);
	    }
	);

    function queryCompanies(cp) {
        name = $("#searchName").val();
        city = $("#searchCity").val();
        $.ajax({
            url : "companies",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&name=" +name+ "&city="+city,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initCompanyTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initCompanyTable(data, currentPage) {
        companiesResultTable = $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "name",
                    "city",
                    "address",
                    "phone",
                    "branchCount",
                    "<button  class='btn btn-info btn-sm editDepa'  ID='editCompany' onclick='updateCompany(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='delCompany' onclick='deleteCompany(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "公司名称", "所在城市", "公司地址", "公司电话", "门店个数", "_opt" ],
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
                queryCompanies(currentPage);
            }
        });
    }

    $("#addBranch").click(
        function(){
            var idsStr = companiesResultTable.getCheckboxIds();
            if (idsStr=="" || idsStr.includes(",")) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("请选择一个公司进行操作");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            } else {
                $.ajax({
                    url : "company",
                    type : "GET",
                    async: true,
                    data : "id=" + idsStr,
                    contentType : "application/json;charset=utf-8",
                    success : function(data) {
                        $("#innerModal").load("WEB-ROOT/html/branch.jsp", function(){
                            $("#submitType").val("PUT");
                            $("#company").val(data.name);
                            $("#companyId").val(data.id);
                            $("#city").val(data.city);
                            $("#originalBranchModal").modal({
                                keyboard: true
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

	function updateCompany(id) {
        $.ajax({
            type : "GET",
            url : "company?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#innerModal").load(
                    "WEB-ROOT/html/company.jsp",
                    function() {
                        $("#originalCompanyModal").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#name").val(data.name);
                            $("#city").val(data.city);
                            $("#address").val(data.address);
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

    function deleteCompany(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
            $.ajax({
                type : "DELETE",
                url : "company?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function() {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryCompanies(1);
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

    $("#addCompany").click(
        function(){
             $("#innerModal").load("WEB-ROOT/html/company.jsp", function(){
                $("#originalCompanyModal").modal({
                    keyboard: true
                });
            });
        }
    );
