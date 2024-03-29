<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>528人力资源管理系统</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
        	href="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet"
        	href="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/css/common.css">
        <link type="text/css" rel="stylesheet"
                    href="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/css/jquery-ui.min.css" />
        <link type="text/css" rel="stylesheet"
            href="<%=request.getContextPath() %>/WEB-ROOT/rvnm/assets/css/all.min.css" />
        <link type="text/css" rel="stylesheet"
            href="<%=request.getContextPath() %>/WEB-ROOT/rvnm/src/jquery-rvnm.css" />
        <link type="text/css" rel="stylesheet"
            href="<%=request.getContextPath() %>/WEB-ROOT/rvnm/assets/css/all.min.css" />
        <link type="text/css" rel="stylesheet"
            href="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/css/MonthPicker.min.css" />
        <script src="<%=request.getContextPath() %>/WEB-ROOT/rvnm/jquery.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/rvnm/src/jquery-rvnm.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/jquery-ui-1.11.4.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/datepicker-zh-CN.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/jquery.serializeObject.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/treeview.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/lTable.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/bootstrapValidator.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/jquery.maskedinput.min.js"></script>
        <script src="<%=request.getContextPath() %>/WEB-ROOT/bootstrap/js/MonthPicker.min.js"></script>
        <script type="text/javascript">
            $(function () {
                var rvnMenu = $("#navbar").rvnm({
                    searchable: true,
                    theme: 'dark-lesb'
                });
                rvnMenu.setTheme('dark-ruby');
                $("#homepage").show();
            });
        </script>
    </head>
    <body>
        <sec:authentication property="principal.authorities" scope="session" var="authority"/>
        <sec:authentication property="principal.username" scope="session" var="username"/>
        <div id="homepage" style="display:none;">
            <nav id="navbar" class="" style="width: 180px;">
                <ul>
                    <li>
                        <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/candidates.jsp',' 首页/ 简历管理','简历管理')">
                            <i class="fas fa-id-card"></i>
                            简历管理
                        </span>
                    </li>

                    <sec:authorize access="!hasRole('ROLE_ADMIN')">
                        <li>
                            <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/jobs.jsp',' 首页/ 职位管理','职位管理')">
                                <i class="fas fa-briefcase"></i>
                                职位管理
                            </span>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="#">
                                <i class="fas fa-briefcase"></i>
                                职位管理
                            </a>
                            <ul>
                                <li>
                                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/jobs.jsp',' 首页/ 职位管理/ 职位管理','职位管理')">
                                        职位管理
                                    </span>
                                </li>
                                <li>
                                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/jobQuotas.jsp',' 首页/ 职位管理/ 指标管理','指标管理')">
                                        指标管理
                                    </span>
                                </li>
                            </ul>
                        </li>
                    </sec:authorize>

                    <li>
                        <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/jobApplications.jsp',' 首页/ 求职管理','求职管理')">
                            <i class="fas fa-user-tie"></i>
                            求职管理
                        </span>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="#">
                                <i class="fas fa-chart-pie"></i>
                                数据报表
                            </a>
                            <ul>
                                <li>
                                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/reports/branchReport.jsp',' 首页/ 数据报表/ 门店业绩报表','门店业绩报表')">
                                        门店业绩报表
                                    </span>
                                </li>
                                <li>
                                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/reports/personalReport.jsp',' 首页/ 数据报表/ 个人业绩报表','个人业绩报表')">
                                        个人业绩报表
                                    </span>
                                </li>
                                <li>
                                    <span class="spliter" href="javascript:void(0)" onclick="htmlDispatcher('WEB-ROOT/html/reports/branchStuffReport.jsp',' 首页/ 数据报表/ 每月在职报表','每月在职报表')">
                                        每月在职报表
                                    </span>
                                </li>
                            </ul>
                        </li>
                    </sec:authorize>
                    <li>
                        <a href="#">
                            <i class="fa fa-cogs"></i>
                            系统管理
                        </a>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <ul>
                                <li>
                                    <a href="javascript:void(0)"
                                        onclick="htmlDispatcher('WEB-ROOT/html/users.jsp',' 首页/ 系统管理/ 用户管理','用户管理')">
                                        用户管理
                                    </a>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <a href="javascript:void(0)"
                                        onclick="htmlDispatcher('WEB-ROOT/html/companies.jsp',' 首页/ 系统管理/ 公司管理','公司管理')">
                                        公司管理
                                    </a>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <a href="javascript:void(0)"
                                        onclick="htmlDispatcher('WEB-ROOT/html/branches.jsp',' 首页/ 系统管理/ 门店管理','门店管理')">
                                        门店管理
                                    </a>
                                </li>
                            </ul>
                        </sec:authorize>
                        <ul>
                            <li>
                                <a href="javascript:void(0)"
                                        onclick="htmlDispatcher('WEB-ROOT/html/resetPassword.jsp',' 首页/ 系统管理/ 密码重置','密码重置')">
                                    密码重置
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span class="spliter" id="logout">
                            <i class="fas fa-power-off"></i>
                            退出系统
                        </span>
                    </li>
            </nav>
            <div id="wrapper">
                <div class="col-lg-10 col-sm-12">
                    <div style="margin-top: 3px" class="breadcrumb hid">
                        <div id="headTitle">首页</div>
                    </div>
                    <div id="frame"></div>
                </div>
            </div>
        </div>

        <script>
             $("#frame").load( "WEB-ROOT/html/candidates.jsp", function( response, status, xhr ) {
                $("#headTitle").text(" 首页/ 系统管理/ 简历管理");
             });

             htmlDispatcher=function(url, title){
                $("#frame").load(url);
                $("#headTitle").text(title);
            };

            $("#logout").click(
                function(){
                    if (confirm("确定退出系统？") == true) {
                        window.location.replace("logout");
                    }
                }
            );

            $(document).ajaxComplete(function(event,obj,settings){
                if (obj.status == 401) {
                    window.location.replace("login");
                }
            })
        </script>
    </body>
</html>

