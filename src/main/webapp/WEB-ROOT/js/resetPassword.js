$('#resetPasswordForm').bootstrapValidator({
    message : 'This value is not valid',
    feedbackIcons : {
        valid : 'glyphicon glyphicon-ok',
        invalid : 'glyphicon glyphicon-remove',
        validating : 'glyphicon glyphicon-refresh'
    },
    fields : {
        currentPassword : {
            validators : {
                notEmpty : {
                    message : '当前密码不能为空'
                },
            }
        },
        newPassword : {
            validators : {
                notEmpty : {
                    message : '新密码不能为空'
                },
            }
        },
        newPasswordAgain : {
            validators : {
                notEmpty : {
                    message : '新密码不能为空'
                },
                identical: {
                    field: 'newPassword',
                    message: '两次输入密码不一致'
                },
            }
        },
    }
}).on(
    'success.form.bv',
    resetPassword
);

function resetPassword(e){
    e.preventDefault();
    var data = $('form#resetPasswordForm').serializeObject();
    $.ajax({
        url : "updatePassword",
        type : "POST",
        async: true,
        data : JSON.stringify(data),
        contentType : "application/json;charset=utf-8",
        success : function(msg) {
             $( "#resetAlert" ).load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                $("#alertText").text("操作成功");
                $("#alertModel").modal({
                    keyboard: true
                });
             });
        },
        error : function(msg) {
            $( "#resetAlert" ).load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                $("#alertText").text("操作失败");
                $("#alertModel").modal({
                    keyboard: true
                });
            });
        }
    });
}

