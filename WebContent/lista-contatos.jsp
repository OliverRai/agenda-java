<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<body>
	<!-- cria o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"/>
	<table>
		<!-- percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td><h4>Nome: </h4> ${contato.nome}</td>
				<td><h4>E-mail: </h4>${contato.email}</td>
				<td><h4>Endereço: </h4>${contato.endereco}</td>
				<td><h4>Data de Nascimento: </h4>${contato.dataNascimento.time}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>