
<nav class="navbar navbar-inverse navbar-fixed-top">
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
					aria-expanded="false">Avion <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/avion/avionListe">Afficher
								Avion</a></li>
						<li><a
							href="${pageContext.request.contextPath}/avion/avionAfficheAjouter">Ajouter
								Avion</a></li>
						<li><a
							href="${pageContext.request.contextPath}/avion/avionAfficheModifier">Modifier
								Avion</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Voyage <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/conseillerMarketing/voyageCMListe">Afficher
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
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Hotel <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/hotel/hotelListe">Afficher
								Hotel</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotel/hotelAfficheAjouter">Ajouter
								Hotel</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotel/hotelAfficheModifier">Modifier
								Hotel</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Destination <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/destination/destinationListe">Afficher
								Destination</a></li>
						<li><a
							href="${pageContext.request.contextPath}/destination/destinationAfficheAjouter">Ajouter
								Destination</a></li>
						<li><a
							href="${pageContext.request.contextPath}/destination/destinationAfficheModifier">Modifier
								Destination</a></li>
						<li><a
							href="${pageContext.request.contextPath}/destination/destinationAfficheSupprimer">Supprimer
								Destination</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Voiture <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureListe">Afficher
								voiture</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureAfficheAjouter">Ajouter
								voiture</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureAfficheModifier">Modifier
								voiture</a></li>
					</ul></li>

			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li><a
					href="${pageContext.request.contextPath}/j_spring_security_logout">Déconnexion</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
