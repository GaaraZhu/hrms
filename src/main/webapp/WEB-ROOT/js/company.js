
    $('#companyForm').bootstrapValidator({
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
            city : {
                validators : {
                    notEmpty : {
                        message : '所在城市不能为空'
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
        var data = $('form#companyForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"company?id="+$("#id").val():"company";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#companyAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 queryCompanies(1);
            },
            error : function(msg) {
                $("#companyAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

