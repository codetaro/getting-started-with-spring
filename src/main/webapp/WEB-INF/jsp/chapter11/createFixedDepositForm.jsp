<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create a new fixed deposit</title>
    <style type="text/css">
        .td {
            font-family: Arial;
            font-size: 12px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<form:form commandName="newFixedDepositDetails"
           name="createFixedDepositForm" method="post"
           action="${pageContext.request.contextPath}/fixedDeposit?fdAction=create">
    <table align="left" style="padding-left: 300px;">
        <tr>
            <td style="font-family: Arial; font-size: 16px; font-weight: bold;"
                align="left">Open fixed deposit</td>
        </tr>
        <tr align="left">
            <td>
                <table class="border" cellpadding="10">
                    <tr>
                        <td class="td"><b>Amount (in USD):</b></td>
                        <td class="td"><form:input path="depositAmount"/>
                            <font style="color: #C11B17;"><form:errors path="depositAmount"/></font>
                        </td>
                    </tr>
                    <tr>
                        <td class="td"><b>Maturity date:</b></td>
                        <td class="td"><form:input path="maturityDate"/>
                            <font style="color: #C11B17;"><form:errors path="maturityDate"/></font>
                        </td>
                    </tr>
                    <tr>
                        <td class="td"><b>Email:</b></td>
                        <td class="td"><form:input path="email"/>
                            <font style="color: #C11B17;"><form:errors path="email"/></font>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr align="left">
            <td>
                <table style="padding-left: 100px;">
                    <tr align="center">
                        <td class="td"><input type="submit" value="Save"/>&nbsp;
                            &nbsp;<a href="${pageContext.request.contextPath}/fixedDeposit/list"
                                     style="color: green"><b>Go Back</b></a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
