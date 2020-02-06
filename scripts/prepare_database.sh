#!/bin/bash
export DERBY_OPTS='-Dij.database="jdbc:derby://localhost:1527/WM;create=true;user=WM;password=WM"'

if ij scripts/test_tables.sql | grep -q "not exist"; then
  echo "Tables not found. Seeding database"

  CREATE_DB="$(ij src/main/resources/createDB.sql)"
  if echo "$CREATE_DB" | grep -qP 'ERROR (?!(42Y55|X0X05)).*' ; then
    echo "Failed to create tables"
    echo "$CREATE_DB"
    exit 2
  fi

  INIT_DB="$(ij src/main/resources/initDB.sql)"
  if echo "$INIT_DB" | grep -q "ERROR"; then
    echo "Failed to seed tables"
    echo "$INIT_DB"
    exit 3
  fi

  if ij scripts/test_tables.sql | grep -q "selected"; then
    exit $?
  fi
fi
