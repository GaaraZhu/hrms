**概述**

在科技高速发展的今天，传统劳务与人力资源企业应主动利用最新互联网技术，结合自身业务特点，进行改造和升级，全面转型互联网+，以实现其更灵活，更高效、更快速的反应与决策。

---

### 528人力资源管理系统

528人力资源管理系统分为 **528人力资源后台管理系统** 和 **528人力资源微信招聘系统**，企业通过Internet向外界发布招聘信息，应聘者根据兴趣选择空缺职位，进行职位申请或推荐。申请者/推荐者可以追踪求职申请/推荐状况，查询应聘的处理过程。公司可以建立自己的人才资源库，管理求职信息。并且在招聘的后台处理系统里，可以更快得到更多的招聘工作分析报表。

#### 528人力资源后台管理系统

第一阶段实现该系统，计划包括以下几个模块：**用户管理**，**简历管理**，**职位管理**，**求职管理**，**推荐费管理**。

1. **用户管理**（管理员可见）
	* 员工账号创建，修改，删除，搜索
	* 员工账号密码重置

2. **简历管理**
	* 简历功能：简历创建，修改，删除，上传，导出，搜索
		- 搜索条件：候选人姓名，候选人电话，候选人城市
		- 简历信息：候选人姓名，电话，性别，身份证号，城市，地址

3. **职位管理**
	* 职位功能：职位发布，修改，删除，搜索
		- 搜索条件：所属企业，城市
		- 职位信息：所属企业，城市，职位名称，工资待遇，工作性质（全职，兼职，小时工），招聘人数，发布人，发布时间，修改人，修改时间，是否推荐有奖，推荐奖励金额，推荐奖励条件（参加面试，入职，入职满1月，入职满2月），浏览次数

4. **求职管理**
	* 求职功能：求职创建，修改，删除，搜索
		- 搜索条件：企业，城市，职位，有无推荐，求职人姓名/电话，推荐人姓名/电话，求职/推荐时间，处理状态
		- 求职信息：申请人简历信息，应聘企业，应聘职位，应聘城市，推荐人姓名/电话，求职/推荐时间，入职/离职时间，最新状态，处理时间
	  	- 处理状态：未处理，申请失败，等待面试，参加面试，面试成功，面试失败，成功入职，入职满1月，入职满2月，入职满3月，入职满4月，入职满5月，离职
	* 求职数据统计（管理员可见）
		- 求职人数，入职比例（月/日，分业务员)

5. **推荐费管理**
	* 推荐费记录自动创建，搜索
		- 搜索条件：求职者，推荐者，应聘企业，应聘城市，应聘职位，奖励对象（求职者/推荐者），奖励缘由（参加面试，入职，入职满1月，入职满2月），奖励发放时间，是否发放
		- 推荐费信息：求职者，推荐者，应聘企业，应聘城市，应聘职位，奖励对象（求职者/推荐者），奖励缘由（参加面试，入职，入职满1月，入职满2月），奖励发放时间，是否发放
	* 推荐费记录汇总
	* 推荐费发放审批（管理员可见）
	* 推荐费发放记录更新

6. **工资预支申请**
	* 工资预支申请记录搜索（数据来自于微信公众号内员工手动申请预支时创建）
		- 搜索条件：申请人，所属企业，职位，利率
	* 工资预支申请额度及利率计算
	* 工资预支申请状态管理
		- 申请状态：申请，审批，放款，利息扣除
	* 工资预支盈利报表（月/季/年）


#### 528人力资源微信招聘系统

第二阶段实现该系统，打通微信公众号和后台管理系统，计划新增模块：
1. **公众号职位推送**
2. **职位申请**
3. **申请记录**
4. **职位推荐**
5. **推荐费记录**
6. **工资预支录**

### 安装及运行

1. 服务器设置
   修改web服务器默认编码
   比如tomcat服务器，修改conf/server.xml
```
   <Connector port="8080" protocol="HTTP/1.1"
        connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8"/>
```
2. 数据库设置
   mysql中新建数据库hrms_db，并执行dump file：[schema.sql](schema.sql)

3. maven打包生成war文件
```
  mvn clean install
```

4. 部署war文件至web服务器，并启动web服务器

5. 打开首页：http://localhost:8080/hrms
   登陆名：admin，密码：admin