
    $('#jobQuotaForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            quota : {
                validators : {
                    notEmpty : {
                        message : '指标不能为空'
                    },
                    integer: {
                        message: '指标格式错误'
                    },
                }
            },
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdateJobQuota
    );

    function onCreateOrUpdateJobQuota(e){
        e.preventDefault();
        var data = $('form#jobQuotaForm').serializeObject();
        data.jobId = $('#jobId').val();
        data.month = $('#month').val();
        data.branchId = $("#branchDropdown").val();
        // validate whether job quota exists for the job and month
        $.ajax({
            url : "jobQuotaCount",
            type : "GET",
            async: true,
            data : "jobId=" + data.jobId + "&month=" + data.month + "&branchId=" + data.branchId,
            contentType : "application/json;charset=utf-8",
            success : function(count) {
                if (count> 0) {
                    $("#jobQuotaAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                        $("#alertText").text("该指标已存在，请重新输入信息进行操作");
                        $("#alertModel").modal({
                            keyboard: true
                        });
                    });
                } else {
                    var method = $("#submitType").val();
                    var url = method=="POST"?"jobQuota?id="+$("#id").val():"jobQuota";
                    $.ajax({
                        type : method,
                        url : url,
                        data: JSON.stringify(data),
                        async: true,
                        contentType: 'application/json;charset=utf-8',
                        success : function() {
                             $("#jobQuotaAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                                $("#alertText").text("操作成功");
                                $("#alertModel").modal({
                                    keyboard: true
                                });
                             });
                             if (method=="POST") {
                                 queryJobQuotas(1);
                              }
                        },
                        error : function(msg) {
                            $("#jobQuotaAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                                $("#alertText").text("操作失败");
                                $("#alertModel").modal({
                                    keyboard: true
                                });
                            });
                        }
                    });
                }
            },
            error : function(e) {
                if (e.status != 401) {
                    console.log(e);
                }
            }
        });
    }
