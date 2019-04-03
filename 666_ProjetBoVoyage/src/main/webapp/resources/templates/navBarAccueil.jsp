<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">BoVoyage</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Voyage <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/voyage/voyageListe">Afficher
								Voyage</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voyage/voyageAjouter">Ajouter
								Voyage</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voyage/voyageModifier">Modifier
								Voyage</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voyage/voyageSupprimer">Supprimer
								Voyage</a></li>

					</ul></li>

			</ul>
			
			<ul class="nav navbar-nav">
			<li><a
							href="${pageContext.request.contextPath}/map/carte">TestCarte</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Connexion<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/j_spring_security_logout">Déconnexion</a></li>
						<li><form
								action="${pageContext.request.contextPath}/connexion"
								method="post">
								<input type="text" name="j_username" /> <input type="password"
									name="j_password" /> <input type="submit" name="submit"
									value="Send">
							</form></li>
					</ul></li>
				<%-- ${pageContext.request.contextPath}/choixLogin/choix --%>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
