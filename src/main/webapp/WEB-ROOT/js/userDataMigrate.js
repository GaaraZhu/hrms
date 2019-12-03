
    $('#userDataMigrateForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            originalUserAccount : {
                validators : {
                    notEmpty : {
                        message : '归属用户信息不能为空'
                    }
                }
            }
        }
    }).on(
        'success.form.bv',
        onMigrateUserData
    );

    function onMigrateUserData(e){
        e.preventDefault();
        originalUserId = $("#originalUserId").val();
        targetUserId = $("#targetUserId").val();
        var url = "migrateData?originalUserId="+originalUserId+"&targetUserId="+targetUserId;
        $.ajax({
            type : "POST",
            url : url,
            data: {},
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#userDataMigrateAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 queryUsers(1);
            },
            error : function(msg) {
                $("#userDataMigrateAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    console.log(msg);
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }
