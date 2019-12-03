
    $('#branchForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            address : {
                validators : {
                    notEmpty : {
                        message : '门店地址不能为空'
                    },
                }
            },
            name : {
                validators : {
                    notEmpty : {
                        message : '门店名称不能为空'
                    },
                }
            },
            manager : {
                validators : {
                    notEmpty : {
                        message : '门店主管不能为空'
                    },
                }
            },
            telephone : {
                validators : {
                    notEmpty : {
                        message : '门店电话不能为空'
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
        var data = $('form#branchForm').serializeObject();
        data.companyId = $("#companyId").val();
        var method = $("#submitType").val();
        var url = method=="POST"?"branch?id="+$("#id").val():"branch";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#branchAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 if (method=="POST") {
                     queryBranches(1);
                  }
            },
            error : function(msg) {
                $("#branchAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

