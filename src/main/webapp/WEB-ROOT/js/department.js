    var pageSize = 8;
	$("#reset").click(
        function() {
            $("#searchNumber").val("");
            $("#searchName").val("");
        }
	);

	$("#search").click(
        function() {
            queryPage(1);
	    }
	);

    function queryPage(cp) {
        depNum = $("#searchNumber").val();
        depName = $("#searchName").val();
        $.ajax({
            url : "departments",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&depNum=" +depNum+ "&depName="+depName,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initTable(data, cp);
            },
            error : function(e) {
                console.log(e)
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
                    "number",
                    "name",
                    "manager",
                    "telephone",
                    "<button  class='btn btn-info btn-sm editDepa'  ID='editDepa' onclick='updF(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='delDepa' onclick='delF(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
            name : ["ID", "部门编号", "部门名称", "部门主管", "部门电话", "_opt" ],
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
            url : "department?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#addDepList").load(
                    "WEB-ROOT/html/department.jsp",
                    function() {
                        $("#addModel").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#number").val(data.number);
                            $("#name").val(data.name);
                            $("#manager").val(data.manager);
                            $("#telephone").val(data.telephone);
                            $("#submitType").val("POST")
                        }
                    });
            },
            error : function(msg) {
                alert("bb");
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
                url : "department?id="+id,
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

    $("#addDep").click(
        function(){
             $("#addDepList").load("WEB-ROOT/html/department.jsp", function(){
                $("#addModel").modal({
                    keyboard: true
                });
            });
        }
    );

    $('#depForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            number : {
                message : '部门编号验证失败',
                validators : {
                    notEmpty : {
                        message : '部门编号不能为空'
                    },
                    regexp : {
                        regexp : /^[a-zA-Z0-9_]+$/,
                        message : '员工编号只能包含大写、小写、数字和下划线'
                    }
                }
            },
            name : {
                validators : {
                    notEmpty : {
                        message : '部门名称不能为空'
                    },

                }
            },
            manager : {
                validators : {
                    notEmpty : {
                        message : '部门主管不能为空'
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
        var data = $('form#depForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"department?id="+$("#id").val():"department";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
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

