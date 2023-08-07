# Database Migration
**for postgres**

	# create data tables in the database
	psql -d blogger -U postgres -a -f migration.sql
	
	# populate data tables with mock data
	psql -d blogger -U postgres -a -f populate.sql