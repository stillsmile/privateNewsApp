<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
	</head>
	<body>
		<table border="1">
			<tr>
				<td>
					序号
				</td>
				<td>
					部门名称
				</td>
				<td>
					地址
				</td>
			</tr>
			<s:iterator value="depts" status="sta">
				<tr>
					<td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="dname" />
					</td>
					<td>
						<s:property value="loc" />
					</td>
				</tr>
			</s:iterator>

		</table>
	</body>
</html>
