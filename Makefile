# Makefile for compiling the 6502 emulator

SRC_DIR = src
BIN_DIR = bin

# Find all .java files in src/
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

# Compile Java files into bin/
compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SOURCES)

# Run the main class
run: compile
	java -cp $(BIN_DIR) Main

# Clean compiled files
clean:
	rm -rf $(BIN_DIR)
