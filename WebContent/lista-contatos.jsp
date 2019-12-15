<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<body>

<c:import url="cabecalho.jsp" />
	<!-- cria o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"/>
	<table>
		<!-- percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td><br><h4>Nome: </h4> ${contato.nome}</td>
				
				<td><br><h4>E-mail: </h4>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
					E-mail não informado
					</c:if>
				<td><br><h4>Endereço: </h4>${contato.endereco}</td>
				<td><br><h4>Data de Nascimento: </h4><fmt:formatDate value="${contato.dataNascimento.time}"
pattern="dd/MM/yyyy" /></td>
				
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>