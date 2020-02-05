#!/bin/bash
export DERBY_OPTS='-Dij.database="jdbc:derby://localhost:1527/WM;create=true;user=WM;password=WM"'

if ij scripts/test_tables.sql | grep -q "not exist"; then
  echo "Tables not found. Seeding database"

  CREATE_DB="$(ij src/main/resources/createDB.sql)"
  if echo "$CREATE_DB" | grep -q "ERROR"; then
    echo "Failed to create tables"
    exit 2
  fi

  INIT_DB="$(ij src/main/resources/initDB.sql)"
  if echo "$INIT_DB" | grep -q "ERROR"; then
    echo "Failed to seed tables"
    exit 3
  fi

  if ij scripts/test_tables.sql | grep -q "selected"; then
    exit $?
  fi
fi
