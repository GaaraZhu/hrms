    var pageSize = 8;
	$("#resetUsers").click(
        function() {
            $("#name").val("");
            $("#authority").val("");
        }
	);

	$("#searchUsers").click(
        function() {
            queryUsers(1);
	    }
	);

    function queryUsers(cp) {
        name = $("#searchName").val();
        account = $("#searchAccount").val();
        authority = $("#searchAuthority").val();
        $.ajax({
            url : "users",
            type : "GET",
            async: true,
            data : "currentPage=" + cp + "&pageSize=" + pageSize + "&name=" +name+ "&account=" + account+"&authority="+authority,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                initUserTable(data, cp);
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                    alert("搜索失败，请查看控制台日志");
                }
            }
        });
    }

    function initUserTable(data, currentPage) {
        $.lTable('#tableList',
        {
            data : data.results,
            title : [
                    "id",
                    "name",
                    "account",
                    "authority",
                    "<button  class='btn btn-info btn-sm editUser'  ID='editUser' onclick='updateUser(id)'><span class='glyphicon glyphicon-pencil'></span> 编辑</button> <button  class='btn btn-info btn-sm delUser' ID='delUser' onclick='deleteUser(id)'><span class='glyphicon glyphicon-remove'></span>删除</button>" ] ,
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
                queryUsers(currentPage);
            }
        });
    }

	function updateUser(id) {
        $.ajax({
            type : "GET",
            url : "user?id="+id,
            async : true,
            contentType : "application/json;charset=utf-8",
            success : function(data) {
                $("#innerModal").load(
                    "WEB-ROOT/html/user.jsp",
                    function() {
                        $("#originalUserModal").modal({
                            keyboard : true
                        });
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#name").val(data.name);
                            $("#account").val(data.account);
                            $("#authority").val(data.authority);
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

    function deleteUser(id) {
        if (confirm("确定删除该记录？") == true) {
            $("#innerModal").load("WEB-ROOT/html/common/alert.jsp");
            $.ajax({
                type : "DELETE",
                url : "user?id="+id,
                async : true,
                contentType : "application/json;charset=utf-8",
                success : function() {
                    $("#alertText").text("删除成功");
                    $("#alertModel").modal({
                        keyboard : true
                    });
                    queryUsers(1);
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

    $("#addUser").click(
        function(){
             $("#innerModal").load("WEB-ROOT/html/user.jsp", function(){
                $("#originalUserModal").modal({
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
        onCreateOrUpdateUser
    );

    function onCreateOrUpdateUser(e){
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
            success : function() {
                 $("#userAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 queryUsers(1);
            },
            error : function(msg) {
                $("#userAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

