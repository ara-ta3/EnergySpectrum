GRADLE=gradle
JAVA=java

.PHONY: build


build:
	$(GRADLE) build

run:
	$(GRADLE) run

run/jar:
	$(JAVA) -jar build/libs/EnergySpectrum.jar
