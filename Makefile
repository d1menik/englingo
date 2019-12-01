DC=docker-compose
DM=docker-compose exec -T mysql

docker-up-force:
	$(DC) up --build -d --force-recreate --remove-orphans

database-create:
	$(DM) /bin/sh -c "mysql -uroot -proot -e 'DROP DATABASE IF EXISTS englingo_dev;'"
	$(DM) /bin/sh -c "mysql -uroot -proot -e 'CREATE DATABASE englingo_dev;'"
