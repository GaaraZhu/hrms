    $('#jobForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            company : {
                validators : {
                    notEmpty : {
                        message : '企业不能为空'
                    },

                }
            },
            city : {
                validators : {
                    notEmpty : {
                        message : '城市不能为空'
                    },

                }
            },
            district : {
                validators : {
                    notEmpty : {
                        message : '城市区域不能为空'
                    },
                }
            },
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
                        message : '职位名称不能为空'
                    },

                }
            },
            quota : {
                validators : {
                    notEmpty : {
                        message : '招聘人数不能为空'
                    },
                }
            },
            salaryRange : {
                validators : {
                    notEmpty : {
                        message : '薪资待遇不能为空'
                    },
                }
            },
            type : {
                validators : {
                    notEmpty : {
                        message : '工作性质不能为空'
                    },
                }
            },
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdateJob
    );

    function onCreateOrUpdateJob(e){
        e.preventDefault();
        var data = $('form#jobForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"job?id="+$("#id").val():"job";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 queryJobs(1);
            },
            error : function(msg) {
                $("#innerModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }

