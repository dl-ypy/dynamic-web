Mybatis


1.����mybatis��ذ�
	��վ��https://github.com/mybatis/mybatis-3/releases���������ļ���mybatis...��mybatis code..


2.�������jstl-1.2.jar��jstl�еģ�
		log4j-1.2.17.jar��������ʾ��־��
		mybatis-3.4.1.jar
		mysql-connector-java-5.1.33-bin(mysql����).jar
		standard-1.1.2.jar��jstl�еģ�


3.�����ļ�������mybatis-3-mybatis code-3.4.1\src\test\java\org\apache\ibatis\submitted\complex_property�µ�
	Configuration.xml�����������ļ�����User.xml�ļ���mybatis-3-mybatis code-3.4.1\src\test\java�µ�log4j.properties�ļ�����ʾ��־�����и��ġ�
	
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
			
			  <!-- ���ö�Ӧ��User.xml -->
			  <mappers>
			    <mapper resource="com/ypy/config/sql/User.xml"/>
			  </mappers>
			
			</configuration>
	
	User.xml��
	
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE mapper
		    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		
		<mapper namespace="Message">
		
		  <!-- type����ʵ�����·�� -->
		  <resultMap type="com.ypy.bean.Message" id="UserResult">
		      
		    <!-- ������id column�����ݿ����ֶε����ƣ�jdbcType���ֶε����ͣ�property��ʵ���������Ե�����-->
		    <id column="ID" jdbcType="INTEGER" property="id"/>
		    <!-- �������������Ե����� -->
		    <result column="COMMAND" jdbcType="VARCHAR" property="command"/>
		    <result column="DESCRIPTION" jdbcType="VARCHAR" property="description"/>
		    <result column="CONTENT" jdbcType="VARCHAR" property="content"/>
		  </resultMap>
			<!--��ѯ����   parameterType��ʾ���������ͣ�ֻ�ܴ�һ������ -->
		  <select id="selectMessage" parameterType="com.ypy.bean.Message" resultMap="UserResult">
		    select ID,COMMAND,DESCRIPTION,CONTENT from micro_message where 1=1
		    
		    <!-- ��̬ƴ��sql��� -->
		    <!-- test������ж������൱��java��䣺if(command!=null && !" ".equals(description.trim()))  and��ognl���ʽ -->
		    <if test="command!=null and !&quot;&quot;.equals(command.trim())">
		        and COMMAND=#{command}
		    </if>
		  </select>
		  
		  <!-- ����ɾ�� -->
		  <delete id="deleteOne" parameterType="int">
		      delete from micro_message where ID = #{_parameter}
		  </delete>
		  
		  <!-- ����ɾ�� -->
		  <delete id="deleteBatch" parameterType="java.util.List">
		      delete from micro_message where ID in (
		                                               <!-- ��ʾ��,�ָ� -->
		      	<foreach collection="list" item="item" separator=",">
		      	    #{item}
		      	</foreach>
		      )
		  </delete>
		</mapper>
		
	log4j.properties�������Ƶ�src��Ŀ¼�£�
	
		log4j.rootLogger=DEBUG, stdout

		log4j.logger.org.apache.ibatis=ERROR
		
		log4j.logger.org.apache.ibatis.session.AutoMappingUnknownColumnBehavior=WARN, lastEventSavedAppender
		
		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
		
		log4j.appender.lastEventSavedAppender=org.apache.ibatis.session.AutoMappingUnknownColumnBehaviorTest$LastEventSavedAppender
		

4.���ԣ�http://localhost:8080/MicroMessage/ListServlet


5.һ�Զ����ã�command.xml��command_content.xml(ע�⣺�������Ҫ��configuration.xml�����ã�����ʱ���������ӱ��������������ͬ�������ֻ�鵽һ����¼)
	
	command.xml:
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE mapper
		    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		
			<mapper namespace="Command">
			
			  <resultMap type="com.ypy.bean.Command" id="Command">
			      
			    <id column="ID" jdbcType="INTEGER" property="id"/>
			    <result column="name" jdbcType="VARCHAR" property="name"/>
			    <!-- Command���еļ������ԣ�Ҫ������һ��xml�����ļ��е����� -->
			    <collection property="list" resultMap="Command_Content.Content"/>
			  </resultMap>
			  
			  <select id="selectCommand" parameterType="com.ypy.bean.Command" resultMap="Command">
			      <!-- ����ѯ��� ��������������id������һ�����������Ϊ�����column��Ҫд������
			                          ���дid,ϵͳ��֪�����ĸ����е�id�����дa.id��b.idҲ�������Ϊ��ѯʱ����ӡ��������û��ǰ׺��-->
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
			
			
6.һ�Զ���ԣ�http://localhost:8080/MicroMessage/CommandServlet


7.��ҳ��ѯ��
	
	����User.xml:
		<!-- ��ҳ��ѯ -->
		  <select id="selectMessageByPage" parameterType="java.util.Map" resultMap="UserResult">
		    select ID,COMMAND,DESCRIPTION,CONTENT from micro_message where 1=1
		    
		    <if test="message.command!=null and !&quot;&quot;.equals(message.command.trim())">
		        and COMMAND=#{message.command}
		    </if>
		    order by ID
		  </select>
		  
	��д��������PageInterceptor.java
	
	��дDao.java, ListServletByPage.java, listByPage.jsp
	
	����Configuration.xml��
		<!-- ���������� -->
		  <plugins>
		      <plugin interceptor="com.ypy.interceptor.PageInterceptor"/>
		  </plugins>


8.��ҳ��ѯ���ԣ�http://localhost:8080/MicroMessage/ListByPageServlet		


9.������������ע����ʵ�鲢û����ʾ����������ֻ��ʾ��������������������������Ĵ��룩
	����User.xml:
		<!-- �������� -->
		  <insert id="insertBatch" parameterType="java.util.List">
		      insert into micro_message (COMMAND,DESCRIPTION,CONTENT) values
		      <foreach collection="list" item="item" separator=",">
		      <!-- ������ -->
		          (#{item.command},#{item.description},#{item.content})
		      </foreach>
		  </insert>  
		  
		  
10.��дDao.java, InsertServlet.java, insert.jsp��


11.�����������ԣ�http://localhost:8080/MicroMessage/ListByPageServlet


12.sql�����sql�ļ����µ�mysql.sql�ļ��С�