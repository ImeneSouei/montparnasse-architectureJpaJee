<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Personne</title>
</head>
<body>
<section class="container">

	

		<div>
			<form action="ServletPersonne">
			<h1 	id="pos">Récupération des infos</h1>
			
			
				<!--action="/URL" et 'Post' pour envoyer les informations-->
				<div>
					<div class="form-group row">
					
						<label for="Nom" class="col-sm-2 col-form-label">id</label>
						<div class="col-sm-10">
							<input type="id" class="form-control" id="nom" name="id"
								placeholder="id" value="${id}" >
						</div>
					</div>
				</div>
				
				<div>
					<div class="form-group row">
					
						<label for="Nom" class="col-sm-2 col-form-label">Nom</label>
						<div class="col-sm-10">
							<input type="nom" class="form-control" id="nom" name="nom"
								placeholder="nom" value="${nom }" required>
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="prenom" class="col-sm-2 col-form-label">Prenom</label>
						<div class="col-sm-10">
							<input type="prenom" class="form-control" id="prenom" name="prenom"
								placeholder="prenom"  value="${prenom }" required>
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="age" class="col-sm-2 col-form-label">Age</label>
						<div class="col-sm-10">
							<input type="age" class="form-control" id="age" placeholder="age" name="age"  value="${age }" >
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="login" class="col-sm-2 col-form-label">Login</label>
						<div class="col-sm-10">
							<input type="login" class="form-control" id="login" placeholder="login" name="login"  value="${login }" >
						</div>
					</div>
				</div>
				<div>
					<div class="form-group row">
						<label for="mdp" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="mdp" placeholder="mdp" name="mdp"  value="${mdp }" >
						</div>
					</div>
				</div>
				Adresse : <select name="idAdresse"> 
				               <optgroup>
				                   <option value="0">---</option>  
				                   <c:if test="${! empty adresses}">    
				                       <c:forEach items="${adresses}" var="a">                   
				                          <option value="${a.idAdresse}"> 
				                              <c:out value="${a.numRue},${a.nomRue},${a.ville}"></c:out> 
				                          </option>      
				                       </c:forEach>                    
				                   </c:if>               
				               </optgroup>             
				         </select>

				<div>
					<button type="submit" name="ajouter" >ajouter</button>
					<button type="submit" name="modifier" >modifier</button>
					
                    
				</div>
			</form>

		</div>
	</section>
	<!-- creer table dynamique -->
	
	<div class="container">
	<h2>Liste des personnes</h2>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Age</th>
     
      
       <th scope="col">Supprimer</th>
        <th scope="col">Modifier</th>
    </tr>
  </thead>
  <tbody>
  <c:if test="${! empty personnes }">
  <c:forEach items="${personnes }" var="x">
    <tr>
      <td><c:out value="${x.id }"/></td>
      <td><c:out value="${x.nom }"/></td>
      <td><c:out value="${x.prenom }"/></td>
      <td><c:out value="${x.age }"/></td>
       <td><a href="SupprimerPersonne?idPersonne=${x.id }">supprimer</a></td>
        <td><a href="ModifierPersonne?idPersonne=${x.id }">modifier</a></td>
    </tr>
  </c:forEach>
  </c:if>
   
  </tbody>
</table>
</div>

</body>
</html>