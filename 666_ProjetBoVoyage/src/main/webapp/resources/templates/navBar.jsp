
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
				<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
				<li><a href="#">Link</a></li>
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
						<li><a
							href="${pageContext.request.contextPath}/avion/avionAfficheSupprimer">Supprimer
								Avion</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>

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
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
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
						<li><a
							href="${pageContext.request.contextPath}/hotel/hotelAfficheSupprimer">Supprimer
								Hotel</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
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
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Voiture <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureListe">Afficher
								Voiture</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureAfficheAjouter">Ajouter
								Voiture</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureAfficheModifier">Modifier
								Voiture</a></li>
						<li><a
							href="${pageContext.request.contextPath}/voiture/voitureAfficheSupprimer">Supprimer
								Voiture</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Continent <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/continent/continentListe">Afficher
								Continent</a></li>
						<li><a
							href="${pageContext.request.contextPath}/continent/continentAfficheAjouter">Ajouter
								Continent</a></li>
						<li><a
							href="${pageContext.request.contextPath}/continent/continentAfficheModifier">Modifier
								Continent</a></li>
						<li><a
							href="${pageContext.request.contextPath}/continent/voitureAfficheSupprimer">Supprimer
								Continent</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Client <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/client/clientListe">Afficher
								client</a></li>
						<li><a
							href="${pageContext.request.contextPath}/client/clientAfficheAjouter">Ajouter
								client</a></li>
						<li><a
							href="${pageContext.request.contextPath}/client/clientAfficheModifier">Modifier
								client</a></li>
						<li><a
							href="${pageContext.request.contextPath}/client/clientAfficheSupprimer">Supprimer
								Destination</a></li>
						<li><a
							href="${pageContext.request.contextPath}/client/cbAfficheAjouter">Ajouter
								carte bancaire</a></li>
						<li><a
							href="${pageContext.request.contextPath}/client/cbAfficheModifier">Modifier
								carte bancaire</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>

			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Rechercher">
				</div>
				<button type="submit" class="btn btn-default">Chercher</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Connexion<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Client</a></li>
						<li><a
							href="${pageContext.request.contextPath}/conseillerClient/espace">Conseiller
								Client</a></li>
						<li><a
							href="${pageContext.request.contextPath}/conseillerMarketing/espace">Conseiller
								Marketing</a></li>
					</ul></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
