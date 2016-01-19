<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="parkingDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='parkingDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="parkingList.parking"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="parkingDetail.heading"/></h2>
    <fmt:message key="parkingDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="parking" method="post" action="parkingform" cssClass="well"
           id="parkingForm" onsubmit="return validateParking(this)">
<form:hidden path="id"/>
    <spring:bind path="parking.parkingName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="parking.parkingName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="parkingName" id="parkingName"  maxlength="50"/>
        <form:errors path="parkingName" cssClass="help-block"/>
    </div>
    <spring:bind path="parking.parkingStatus">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="parking.parkingStatus" styleClass="control-label"/>
        <form:input cssClass="form-control" path="parkingStatus" id="parkingStatus"  maxlength="50"/>
        <form:errors path="parkingStatus" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty parking.id}">
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

<v:javascript formName="parking" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['parkingForm']).focus();
    });
</script>
