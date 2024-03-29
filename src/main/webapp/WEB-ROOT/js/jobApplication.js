
    $('#jobApplicationForm').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            idNumber : {
                validators : {
                    notEmpty : {
                        message : '申请人身份证账号不能为空'
                    },

                }
            },
        }
    }).on(
        'success.form.bv',
        onCreateOrUpdateJobApplication
    );

    function onCreateOrUpdateJobApplication(e){
        e.preventDefault();
        var data = $('form#jobApplicationForm').serializeObject();
        data.jobId = $("#jobId").val();
        data.candidateId = $("#candidateId").val();
        data.branchId = $("#branchDropdown").val();
        var method = $("#submitType").val();
        var url = method=="POST"?"jobApplication?id="+$("#id").val():"jobApplication";
        $.ajax({
            type : method,
            url : url,
            data: JSON.stringify(data),
            async: true,
            contentType: 'application/json;charset=utf-8',
            success : function() {
                 $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作成功");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                 });
                 if (method=="POST") {
                    queryJobApplications(1);
                 }
            },
            error : function(msg) {
                $("#jobApplicationAlertModal").load( "WEB-ROOT/html/common/alert.jsp", function( response, status, xhr ) {
                    $("#alertText").text("操作失败");
                    $("#alertModel").modal({
                        keyboard: true
                    });
                });
            }
        });
    }
