    var pageSize = 8;
    queryPage(1);

	$("#reset").click(
        function() {
            $("#selectNumber").val("");
            $("#selectName").val("");
        }
	);

	$("#search").click(
        function() {
            queryPage(1);
	    }
	);

    function queryPage(cp) {
        depNum = $("#selectNumber").val();
        depName = $("#selectName").val();
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
                    "<button  class='btn btn-info btn-sm editDepa'  ID='editDepa' onclick='updF(id)'><span class='glyphicon glyphicon-user'></span> 编辑</button> <button  class='btn btn-info btn-sm delDepa' ID='delDepa' onclick='delF(id)'><span class='glyphicon glyphicon-user'></span>删除</button>" ] ,
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
                    "WEB-ROOT/html/addDepartments.jsp",
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
                        getSelectInput();
                    })
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
            url : "department?id="+id,
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

    $("#addDep").click(
        function(){
             $("#addDepList").load("WEB-ROOT/html/addDepartments.jsp", function(){
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
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator');
        var formData = {}
        $.each($form, function(i, v){
            var input = $(v);
            formData[input.attr("name")] = input.val();
        });
        var data = $('form#depForm').serializeObject();

        $.ajax({
            type : $("#submitType").val(),
            url : "department?id="+$("#id").val(),
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function(msg) {
                console.log(123);
                console.log(msg);
                 $( "#addAlert" ).load( "WEB-ROOT/common/alert.jsp", function( response, status, xhr ) {
                    $('#addAlert').html(response);
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
            },
            error : function(msg) {
                console.log(msg);
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

