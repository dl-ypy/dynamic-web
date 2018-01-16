Mybatis


1.下载mybatis相关包
	网站：https://github.com/mybatis/mybatis-3/releases下载两个文件：mybatis...、mybatis code..


2.导入包：jstl-1.2.jar（jstl中的）
		log4j-1.2.17.jar（用于显示日志）
		mybatis-3.4.1.jar
		mysql-connector-java-5.1.33-bin(mysql驱动).jar
		standard-1.1.2.jar（jstl中的）


3.配置文件：复制mybatis-3-mybatis code-3.4.1\src\test\java\org\apache\ibatis\submitted\complex_property下的
	Configuration.xml（核心配置文件）、User.xml文件和mybatis-3-mybatis code-3.4.1\src\test\java下的log4j.properties文件（显示日志）进行更改。
	
	Configuration.xml:
	
		<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE configuration
			    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
			    "http://mybatis.org/dtd/mybatis-3-config.dtd">
			
			<configuration>
			  <!-- <settings>
			    <setting name="useGeneratedKeys" value="false"/>
			    <setting name="useColumnLabel" value="true"/>
			  </settings>
			
			  <typeAliases>
			    <typeAlias alias="UserAlias" type="org.apache.ibatis.submitted.complex_property.User"/>
			  </typeAliases> -->
			
			  <environments default="development">
			    <environment id="development">
			      <transactionManager type="JDBC">
			        <property name="" value=""/>
			      </transactionManager>
			      <dataSource type="UNPOOLED">
			        <property name="driver" value="com.mysql.jdbc.Driver"/>
			        <property name="url" value="jdbc:mysql://localhost:3306/mybatis"/>
			        <property name="username" value="root"/>
			        <property name="password" value="12345678900"/>
			      </dataSource>
			    </environment>
			  </environments>
			
			  <!-- 配置对应的User.xml -->
			  <mappers>
			    <mapper resource="com/ypy/config/sql/User.xml"/>
			  </mappers>
			
			</configuration>
	
	User.xml：
	
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE mapper
		    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		
		<mapper namespace="Message">
		
		  <!-- type中是实体类的路径 -->
		  <resultMap type="com.ypy.bean.Message" id="UserResult">
		      
		    <!-- 主键用id column是数据库中字段的名称，jdbcType是字段的类型，property是实体类中属性的名称-->
		    <id column="ID" jdbcType="INTEGER" property="id"/>
		    <!-- 下面是其他属性的配置 -->
		    <result column="COMMAND" jdbcType="VARCHAR" property="command"/>
		    <result column="DESCRIPTION" jdbcType="VARCHAR" property="description"/>
		    <result column="CONTENT" jdbcType="VARCHAR" property="content"/>
		  </resultMap>
			<!--查询方法   parameterType表示参数的类型，只能传一个参数 -->
		  <select id="selectMessage" parameterType="com.ypy.bean.Message" resultMap="UserResult">
		    select ID,COMMAND,DESCRIPTION,CONTENT from micro_message where 1=1
		    
		    <!-- 动态拼接sql语句 -->
		    <!-- test里面的判断条件相当于java语句：if(command!=null && !" ".equals(description.trim()))  and是ognl表达式 -->
		    <if test="command!=null and !&quot;&quot;.equals(command.trim())">
		        and COMMAND=#{command}
		    </if>
		  </select>
		  
		  <!-- 单条删除 -->
		  <delete id="deleteOne" parameterType="int">
		      delete from micro_message where ID = #{_parameter}
		  </delete>
		  
		  <!-- 批量删除 -->
		  <delete id="deleteBatch" parameterType="java.util.List">
		      delete from micro_message where ID in (
		                                               <!-- 表示用,分割 -->
		      	<foreach collection="list" item="item" separator=",">
		      	    #{item}
		      	</foreach>
		      )
		  </delete>
		</mapper>
		
	log4j.properties：（复制到src根目录下）
	
		log4j.rootLogger=DEBUG, stdout

		log4j.logger.org.apache.ibatis=ERROR
		
		log4j.logger.org.apache.ibatis.session.AutoMappingUnknownColumnBehavior=WARN, lastEventSavedAppender
		
		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
		
		log4j.appender.lastEventSavedAppender=org.apache.ibatis.session.AutoMappingUnknownColumnBehaviorTest$LastEventSavedAppender
		

4.测试：http://localhost:8080/MicroMessage/ListServlet


5.一对多配置：command.xml、command_content.xml(注意：配置完后要在configuration.xml中配置；建表时，主表与子表的主键名不能相同，否则会只查到一条记录)
	
	command.xml:
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE mapper
		    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		
			<mapper namespace="Command">
			
			  <resultMap type="com.ypy.bean.Command" id="Command">
			      
			    <id column="ID" jdbcType="INTEGER" property="id"/>
			    <result column="name" jdbcType="VARCHAR" property="name"/>
			    <!-- Command类中的集合属性，要引用另一个xml配置文件中的内容 -->
			    <collection property="list" resultMap="Command_Content.Content"/>
			  </resultMap>
			  
			  <select id="selectCommand" parameterType="com.ypy.bean.Command" resultMap="Command">
			      <!-- 多表查询语句 ，这里必须对两个id的其中一个起别名，因为上面的column中要写别名，
			                          如果写id,系统不知道是哪个表中的id，如果写a.id或b.id也会错误，因为查询时，打印出来的是没有前缀的-->
			    select a.id ID,a.name,b.content_id,b.content from command a left join command_content b
			    on a.id = b.command_id where 1=1
			    <if test="name!=null and !&quot;&quot;.equals(name.trim())">
			        and a.name=#{name}
			    </if>
			  </select>
			</mapper>
		
		command_content.xml:
			<?xml version="1.0" encoding="UTF-8"?>
			<!DOCTYPE mapper
			    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
			    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
			
			<mapper namespace="Command_Content">
			
			  <resultMap type="com.ypy.bean.Command_Content" id="Content">
			    <id column="content_id" jdbcType="INTEGER" property="id"/>
			    <result column="content" jdbcType="VARCHAR" property="content"/>
			    <result column="command_id" jdbcType="INTEGER" property="command_id"/>
			  </resultMap>
			</mapper>
			
			
6.一对多测试：http://localhost:8080/MicroMessage/CommandServlet


7.分页查询：
	
	配置User.xml:
		<!-- 分页查询 -->
		  <select id="selectMessageByPage" parameterType="java.util.Map" resultMap="UserResult">
		    select ID,COMMAND,DESCRIPTION,CONTENT from micro_message where 1=1
		    
		    <if test="message.command!=null and !&quot;&quot;.equals(message.command.trim())">
		        and COMMAND=#{message.command}
		    </if>
		    order by ID
		  </select>
		  
	编写拦截器：PageInterceptor.java
	
	编写Dao.java, ListServletByPage.java, listByPage.jsp
	
	配置Configuration.xml：
		<!-- 配置拦截器 -->
		  <plugins>
		      <plugin interceptor="com.ypy.interceptor.PageInterceptor"/>
		  </plugins>


8.分页查询测试：http://localhost:8080/MicroMessage/ListByPageServlet		


9.批量新增：（注：本实验并没有演示批量新增，只演示了新增，但代码就是批量新增的代码）
	配置User.xml:
		<!-- 批量新增 -->
		  <insert id="insertBatch" parameterType="java.util.List">
		      insert into micro_message (COMMAND,DESCRIPTION,CONTENT) values
		      <foreach collection="list" item="item" separator=",">
		      <!-- 属性名 -->
		          (#{item.command},#{item.description},#{item.content})
		      </foreach>
		  </insert>  
		  
		  
10.编写Dao.java, InsertServlet.java, insert.jsp等


11.批量新增测试：http://localhost:8080/MicroMessage/ListByPageServlet


12.sql语句在sql文件夹下的mysql.sql文件中。