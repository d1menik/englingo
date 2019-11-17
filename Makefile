DC=docker-compose

docker-up-force:
	$(DC) up --build -d --force-recreate --remove-orphans
