#!/bin/sh

if (grep -r "Copyright \+(c) \+2017-.*Filipe Freire" \
  --exclude-dir "target" --exclude-dir ".git" --exclude "years.sh" \
  --exclude-dir ".idea" --exclude "settings.xml" \
  --exclude-dir "apache-maven-*" . | grep -v 2017-`date +%Y`); then
    echo "Files above have wrong years in copyrights"
    exit 1
fi

if (grep -r -L "Copyright \+(c) \+2017-.*Filipe Freire" \
  --include=*.java --include=*.xml --include=*.vm --include=*.groovy \
  --include=*.txt --include=*.fml --include=*.properties} \
  --exclude-dir "target" --exclude-dir "apache-maven-*" . \
  --exclude-dir ".idea" --exclude "settings.xml" \
  | grep -v 2017-`date +%Y`); then
    echo "Files above must have copyright block in header"
    exit 1
fi
