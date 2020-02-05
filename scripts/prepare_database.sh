#!/bin/bash
export DERBY_OPTS='-Dij.database="jdbc:derby://localhost:1527/WM;create=true;user=WM;password=WM"'

if ij scripts/test_tables.sql | grep -q "not exist"; then
  echo "Tables not found. Seeding database"
  echo $(ij src/main/resources/createDB.sql)
  echo $(ij src/main/resources/initDB.sql)

  if ij scripts/test_tables.sql | grep -q "selected"; then
    exit $?
  fi
fi
