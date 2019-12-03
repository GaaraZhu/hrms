
    $('#candidateForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            name : {
                validators : {
                    notEmpty : {
                        message : '名称不能为空'
                    },

                }
            },
            gender : {
                validators : {
                    notEmpty : {
                        message : '性别不能为空'
                    },

                }
            },
            phone : {
                validators : {
                    notEmpty : {
                        message : '电话不能为空'
                    },

                }
            },
            idNumber : {
                validators : {
                    notEmpty : {
                        message : '身份证号不能为空'
                    },

                }
            }
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdateCandidate
    );

    function onCreateOrUpdateCandidate(e){
        e.preventDefault();
        var data = $('form#candidateForm').serializeObject();
        var method = $("#submitType").val();
        var url = method=="POST"?"candidate?id="+$("#id").val():"candidate";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function(msg) {
                 $("#candidateAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                queryCandidates(1);
            },
            error : function(msg) {
                $("#candidateAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }
