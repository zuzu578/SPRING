<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.2.xsd">
	
	<context:annotation-config />
	<bean class="com.javalec.ex.ApplicationConfig" />
	
	<bean id="student2" class="com.javalec.ex.Student">
		<constructor-arg value="홍길순"></constructor-arg>
		<constructor-arg value="30"></constructor-arg>
		<constructor-arg >
			<list>
				<value>마라톤</value>
				<value>요리</value>
			</list>
		</constructor-arg>
		<property name="height" value="190" />
		<property name="weight" value="70" />
	</bean>
	
	<bean id="student4" class="com.javalec.ex.Student">
		<constructor-arg value="이주환2"></constructor-arg>
		<constructor-arg value="22"></constructor-arg>
		<constructor-arg >
			<list>
				<value>게임</value>
				<value>잠자기</value>
			</list>
		</constructor-arg>
		<property name="height" value="168" />
		<property name="weight" value="65" />
	</bean>
	

</beans>
