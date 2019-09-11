    var pageSize = 8;
	$("#reset").click(
        function() {
            $("#name").val("");
            $("#authority").val("");
        }
	);

	$("#search").click(
        function() {
            queryPage(1);
	    }
	);

    function queryPage(cp) {
        name = $("#name").val();
        account = $("#account").val();
        authority = $("#authority").val();
        $.ajax({
            url : "users",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&name=" +name+ "&account=" + account+"&authority="+authority,
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
                    "name",
                    "account",
                    "authority",
                    "<button  class='btn btn-info btn-sm editUser'  ID='editUser' onclick='updF(id)'><span class='glyphicon glyphicon-user'></span> 编辑</button> <button  class='btn btn-info btn-sm delUser' ID='delUser' onclick='delF(id)'><span class='glyphicon glyphicon-user'></span>删除</button>" ] ,
            name : ["ID", "用户姓名", "账号", "是否为管理员", "_opt" ],
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
            url : "user?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#addUserList").load(
                    "WEB-ROOT/html/user.jsp",
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
        $("#alert").load("WEB-ROOT/common/alert.jsp",
            function(response, status, xhr) {
                $('#alert').html(response);
            });
        $.ajax({
            type : "DELETE",
            url : "user?id="+id,
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

    $("#addUser").click(
        function(){
             $("#addUserList").load("WEB-ROOT/html/user.jsp", function(){
                $("#addModel").modal({
                    keyboard: true
                });
            });
        }
    );

    $('#userForm').bootstrapValidator({
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
        var data = $('form#userForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"user?id="+$("#id").val():"user";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function(msg) {
                 $( "#addAlert" ).load( "WEB-ROOT/common/alert.jsp", function( response, status, xhr ) {
                    $('#addAlert').html(response);
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            },
            error : function(msg) {
                $( "#addAlert" ).load( "WEB-ROOT/common/alert.jsp", function( response, status, xhr ) {
                    $('#addAlert').html(response);
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

