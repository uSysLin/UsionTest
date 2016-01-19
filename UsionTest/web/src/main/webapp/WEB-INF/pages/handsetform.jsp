<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="handsetDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='handsetDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="handsetList.handset"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="handsetDetail.heading"/></h2>
    <fmt:message key="handsetDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="handset" method="post" action="handsetform" cssClass="well"
           id="handsetForm" onsubmit="return validateHandset(this)">
<form:hidden path="id"/>
    <spring:bind path="handset.devId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="handset.devId" styleClass="control-label"/>
        <form:input cssClass="form-control" path="devId" id="devId"  maxlength="50"/>
        <form:errors path="devId" cssClass="help-block"/>
    </div>
    <spring:bind path="handset.innerId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="handset.innerId" styleClass="control-label"/>
        <form:input cssClass="form-control" path="innerId" id="innerId"  maxlength="50"/>
        <form:errors path="innerId" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty handset.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="handset" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['handsetForm']).focus();
    });
</script>
