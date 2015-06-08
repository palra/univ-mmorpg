SRC_HOME=./src/main/java
JAVAC=javac
JAVA=java

MAIN=fr.univdevs.mmorpg.game.App

SOURCES = $(wildcard *.java)
CLASSES = $(sources:.java=.class)

all:
	cd $(SRC_HOME) && \
	$(JAVAC) fr/univdevs/mmorpg/game/App.java && \
	cp -r ../resources/* .

run: all
	cd $(SRC_HOME) && $(JAVA) $(MAIN)

sources:
	echo $(SOURCES)

clean:
	find . -type f -name "*.class" -exec rm {} \;
	cd $(SRC_HOME)/../resources && find -mindepth 1 -maxdepth 1 -type d -exec rm -r ../java/{}/ \;