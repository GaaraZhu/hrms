<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>528人力资源管理系统</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
        	href="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet"
        	href="<%=request.getContextPath() %>/WEB-ROOT/css/common.css">
        <link type="text/css" rel="stylesheet"
        href="<%=request.getContextPath() %>/WEB-ROOT/rvnm/assets/css/all.min.css" />
        <link type="text/css" rel="stylesheet"
        href="<%=request.getContextPath() %>/WEB-ROOT/rvnm/src/jquery-rvnm.css" />
        <script src="<%=request.getContextPath() %>/WEB-ROOT/rvnm/jquery.min.js"></script>
        <script type="text/javascript"
        src="<%=request.getContextPath() %>/WEB-ROOT/rvnm/src/jquery-rvnm.js"></script>
        <script type="text/javascript">
            $(function () {
                var rvnMenu = $("#navbar").rvnm({
                    searchable: true,
                    theme: 'dark-lesb'
                });
                rvnMenu.setTheme('dark-ruby');
            });
        </script>
    </head>
    <body>
        <nav id="navbar" class="">
            <ul>
                <li>
                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/candidates.jsp',' 首页/ 简历管理','简历管理')">
                        <i class="fas fa-id-card"></i>
                        简历管理
                    </span>
                </li>
                <li>
                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/jobs.jsp',' 首页/ 职位管理','职位管理')">
                        <i class="fas fa-id-card"></i>
                        职位管理
                    </span>
                </li>
                <li>
                    <a href="#">
                        <i class="fas fa-user-tie"></i>
                        求职管理
                    </a>
                    <ul>
                        <li>
                            <a href="#">
                                求职信息
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                求职统计
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fab fa-alipay"></i>
                        推荐费管理
                    </a>
                    <ul>
                        <li>
                            <a href="#">
                                推荐费信息
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                推荐费审批
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-cogs"></i>
                        系统管理
                    </a>
                    <ul>
                        <li>
                            <a href="#">
                                用户管理
                            </a>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <a href="javascript:void(0)"
                                onclick="htmlDispatcher('WEB-ROOT/html/departments.jsp',' 首页/ 系统管理/ 部门管理','部门管理')">
                                部门管理
                            </a>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <a href="#">
                                密码重置
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <span class="spliter">
                        <i class="fas fa-bell"></i>
                        系统通知
                    </span>
                </li>
        </nav>
        <div id="wrapper">
            <div class="col-lg-10 col-sm-12">
                <div style="margin-top: 3px">
                    <ol class="breadcrumb hid">
                        <li class="active" id="headTitle">首页</li>
                    </ol>
                </div>
                <div id="frame"></div>
            </div>
        </div>

        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/jquery.serializeObject.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/js/common.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/treeview.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/lTable.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/bootstrapValidator.js"></script>
        <script>
             $( "#frame" ).load( "WEB-ROOT/html/departments.jsp", function( response, status, xhr ) {
                    $('#frame').html(response);
                    $("#headTitle").text(" 首页/ 系统管理/ 部门管理");
             });
            htmlDispatcher=function(url, title){
                $( "#frame" ).load(url, function(response, status, xhr) {
                    $('#frame').html(response);
                });
                $( "#headTitle" ).text(title);
            };
        </script>
    </body>
</html>

