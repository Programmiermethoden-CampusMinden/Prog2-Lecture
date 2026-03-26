## Source files of our project
METADATA               ?= pm.yaml
BIB_FILE               ?= pm.bib
ROOT_DOC               ?= readme.md

## Generated output files and directories
BOOK_SRC               ?= book.md
BUILD_DIR              ?= build

## Image settings for dark and light themes
IMAGE_DARK_SUFFIX      ?= _inv
BASE_URL               ?= https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/

## Publishing settings for the output branch
PUBLISH_BRANCH         ?= _s26
GIT_AUTHOR_NAME        ?= cagix
GIT_AUTHOR_EMAIL       ?= cagix@users.noreply.github.com

## Folder containing the Pandoc-Lecture-Zen project tooling
PANDOC_DATA            ?= .pandoc


## Update Pandoc-Lecture-Zen dependency
update_tooling: $(PANDOC_DATA)
	cd $(PANDOC_DATA)  &&  git switch master  &&  git pull --ff-only

$(PANDOC_DATA):
	git clone --depth 1  https://github.com/cagix/pandoc-lecture-zen.git  $(PANDOC_DATA)


## Include targets from Pandoc-Lecture-Zen Makefile
-include $(PANDOC_DATA)/Makefile


## Declaration of phony targets
.PHONY: update_tooling
