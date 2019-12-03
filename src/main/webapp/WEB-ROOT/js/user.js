
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

